import React from "react";
function Welcome1({ name, color }) {
  // 비구조화 할당(요즘 많이 사용하는 방식)
  return <h1 style={{ color }}>안녕하세요, {name}</h1>;
}

export default Welcome1;
