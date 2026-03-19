import React from "react";
import { useState } from "react";

function InputSample() {
  const [inputs, setInputs] = useState({
    name: "",
    nickname: "",
    phone: "",
  });
  const { name, nickname, phone } = inputs; // 비구조화 할당을 통해 값 추출
  const onChange = (e) => {
    const { value, name } = e.target; // 우선 e.target에서 name, value 추출
    setInputs({
      ...inputs, // 기존 input 객체를 복사한 뒤
      [name]: value, // name 키를 가진 값을 value로 설정
    });
  };
  const onReset = () => {
    setInputs({
      name: "",
      nickname: "",
      phone: "",
    });
  };
  return (
    <div>
      <input name="name" onChange={onChange} value={name} placeholder="이름" />
      <input
        name="nickname"
        onChange={onChange}
        value={nickname}
        placeholder="닉네임"
      />
      <input
        name="phone"
        onChange={onChange}
        value={phone}
        placeholder="전화번호"
      />
      <button onClick={onReset}>초기화</button>
      <div>
        <b>값: </b>
        {name}({nickname}) {phone}
      </div>
    </div>
  );
}

export default InputSample;
