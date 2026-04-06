import React from "react";
import { useState } from "react";

function App() {
  const [isLogin, setIsLogin] = useState(false);
  const onToggle = () => {
    setIsLogin(!isLogin);
  };
  return (
    <div className="app">
      <div className="container">
        <h2>3번 — 조건부 렌더링 (로그인)</h2>
        <button type="button" onClick={onToggle}>
          {isLogin ? "로그아웃" : "로그인"}
        </button>
        {isLogin ? <p>환영합니다</p> : <p>로그인이 필요합니다.</p>}
      </div>
    </div>
  );
}

export default App;
