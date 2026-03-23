import React, { useRef, useState } from "react";
import Counter from "./Counter";
import InputSample from "./InputSample";
import UserList from "./UserList";
import CreateUser from "./CreateUser";

function App() {
  const [inputs, setInputs] = useState({
    username: "",
    email: "",
  });
  const { username, email } = inputs; // 구조 분해로 쉽게 사용
  const onChange = (e) => {
    // 하나의 함수로 name = username, name = email
    const { name, value } = e.target;
    setInputs({
      ...inputs,
      [name]: value,
    });
  };
  // input 입력 -> onChange 실행 -> inputs 상태 변경 -> 화면에 반영

  // 사용자 배열 저장
  const [users, setUsers] = useState([
    {
      id: 1,
      username: "velopert",
      email: "public.velopert@gmail.com",
    },
    {
      id: 2,
      username: "tester",
      email: "tester@example.com",
    },
    {
      id: 3,
      username: "liz",
      email: "liz@example.com",
    },
  ]);
  const nextId = useRef(4); // useRef() 사용할 때 파라미터 넣어주면 .current 기본값
  const onCreate = () => {
    // 나중에 구현할 배열에 항목 추가하는 로직
    const user = {
      id: nextId.current,
      username,
      email,
    };
    // const user = {id, username, email}
    setUsers([...users, user]); // ...users 기존 배열 + 새 데이터
    setInputs({
      username: "",
      email: "",
    });
    nextId.current += 1; // 다음 사용자 id 준비
  };
  const onRemove = (id) => {
    // id가 일하는 사용자를 제외하고 새로운 배열을 만들어 state에 넣는다
    setUsers(users.filter((user) => user.id !== id));
    // filter는 조건에 만족하는 것만 남김
  };

  const onToggle = (id) => {
    setUsers(
      users.map(
        (
          user, // 배열을 하나씩 돌면서 새로운 배열 생성
        ) => (user.id === id ? { ...user, active: !user.active } : user),
      ),
    );
  };
  // user.id === id 클릭한 사용자
  // id가 같으면 -> active 값 뒤집기

  // onToggle
  // map 실행 -> 해당 user만 active 변경
  // => setUsers로 상태 업데이트
  // -> 다시 화면 렌더링

  return (
    <div>
      <CreateUser
        username={username}
        email={email}
        onCreate={onCreate}
        onChange={onChange}
        // 값은 username, email / 이벤트는 onChange, onCreate
      />
      <UserList users={users} onRemove={onRemove} onToggle={onToggle} />
      {/* users 배열을 받아 리스트 출력 */}
    </div>
  );
}

export default App;
// 1. input 입력
// 2. onChange → inputs 상태 변경
// 3. 버튼 클릭
// 4. onCreate 실행
// 5. users 배열에 추가
// 6. UserList 재렌더링
// 7. 화면에 사용자 추가됨
