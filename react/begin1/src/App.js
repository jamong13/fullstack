import React from "react";
import Hello from "./Hello";
import React1 from "./React1";
import "./App.css";
import Wrapper from "./Wrapper";

function App() {
  const name = "react";
  const style = {
    backgroundColor: "black",
    color: "aqua",
    fontSize: 24, // 기본 단위 px
    padding: "1rem", // 다른 단위 사용 시 문자열 처리
  };

  return (
    <Wrapper>
      {/* 주석은 화면에 보이지 않습니다. 중괄호로 감싸지 않으면 화면에 보입니다.*/}
      <div>
        <Hello name="react" color="red" isSpecial />
        <Hello color="pink" />
      </div>
    </Wrapper>
  );
}

export default App;
