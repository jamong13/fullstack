/**
 * 예제: DB(member 테이블)로 로그인만 하는 최소 서버
 * 사용법: 이름을 index.js로 바꿔 쓰거나, node index-login-db-minimal.example.js 로 실행
 * 필요: env.js, db.js, .env, MySQL에 kculture_platform 스키마 + member 데이터
 */
import "./env.js"; // .env를 읽어 process.env 올림(포트, db비밀번호)
import express from "express"; // 웹서버, 라우팅
import cors from "cors"; // 다른 출처 react(5173) 에서 이 api 호출 가능하게
import session from "express-session"; // 로그인 후 세션 id 만들고, 쿠키로 브라우저에 줄 때
import { pool } from "./db.js"; // mysql에 연결, member 테이블 조회

const PORT = Number(process.env.PORT, 10) || 3002; // 서버 포트
const CLIENT_ORIGIN = process.env.CLIENT_ORIGIN || "http://localhost:5173"; // react(5173) 온 요청만 허용 (쿠키 포함)
const SESSION_SECRET = process.env.SESSION_SECRET || "dev-secret-change-me"; // 세션 아이디 암호화

const app = express();

app.use(
  cors({
    // 브라우저 : fetch(credentials:'include')로 쿠키를 실어 보낼 수 있게 함
    origin: CLIENT_ORIGIN,
    credentials: true, // 프론트 엔드와 세션 연결 ok - 로그인 유지
  }),
);
app.use(express.json()); // post 본문이 json일 때 req.body{email, passsword}를 채워 줌
app.use(
  session({
    // 세션 설정 - 로그인 성공 시 req.session.memberId 같은 값을 서버 메모리 저장
    name: "kculture1.sid", // 응답 set-Cookie : kculture1.sid 를 붙여줌
    secret: SESSION_SECRET, // 세션데이터 보호
    resave: false,
    saveUninitialized: false,
    cookie: {
      // 쿠키 설정
      httpOnly: true, // js 못 읽게, document.cookie 못 읽음
      maxAge: 7 * 24 * 60 * 60 * 1000, // 쿠키 유지 시간 7일
      sameSite: "lax",
      secure: process.env.NODE_ENV === "production", // https 일 때문 쿠키 전송
    },
  }),
);

// DB에서 가져온 한 행에서 api로 내려줄 필드만 골라서 객체로 만듦 - 비밀번호 넣지 않음 - 응답에 비번 나가면 안됨
function mapMemberRow(row) {
  if (!row) return null;
  return {
    id: row.id,
    email: row.email,
    name: row.name,
    nationality: row.nationality,
    language: row.language,
  };
}

app.get("/", (req, res) => res.send("OK")); // 서버 살아 있는지 단순 체크

app.get("/api/auth/me", async (req, res) => {
  try {
    if (!req.session.memberId) {
      // 세션에 memberId 없으면 비로그인
      res.json({ member: null });
      return;
    }
    // 세션에 아이디 id 있으면 id로 member 조회 후 mapMemberRow Json
    // -> 지금 로그인된 사용자 정보를 프론트가 새로고침 후 확인할 때 씀
    const [rows] = await pool.query(
      "SELECT id, email, name, nationality, language FROM member WHERE id = ?",
      [req.session.memberId],
    );
    res.json({ member: mapMemberRow(rows[0]) });
  } catch (e) {
    console.error(e);
    res.status(500).json({ error: "Database error." });
  }
});

app.post("/api/auth/login", async (req, res) => {
  try {
    const { email, password } = req.body;
    if (!email || !password) {
      res.status(400).json({ error: "email and password are required." });
      return;
    }
    // DB 조회
    const [rows] = await pool.query(
      "SELECT * FROM member WHERE email = ? AND password = ?",
      [email, password],
    );
    const row = rows[0];
    if (!row) {
      res.status(401).json({ error: "Invalid email or password." });
      return;
    }
    req.session.memberId = row.id;
    res.json({ member: mapMemberRow(row) });
  } catch (e) {
    console.error(e);
    res.status(500).json({ error: "Database error." });
  }
});

app.post("/api/auth/logout", (req, res) => {
  req.session.destroy((err) => {
    // 세션 삭제
    if (err) {
      res.status(500).json({ error: "Could not log out." });
      return;
    }
    res.clearCookie("kculture1.sid", { path: "/" });
    res.json({ ok: true });
  });
});

app.listen(PORT, () => {
  console.log(`Login API (DB) http://localhost:${PORT}`);
});
// 지정한 포트에서 http 서버를 열고, 콘솔에 주소를 출력

// 프론트는 POST /api/auth/login에 이메일·비번을 JSON으로 보내고, 성공 시 서버가 세션 + 쿠키를 준다.
// 이후 요청은 같은 쿠키로 memberId를 알 수 있고, GET /api/auth/me로 회원 정보를 다시 받을 수 있다.
// DB는 pool이 member 테이블을 조회할 때만 사용된다.
