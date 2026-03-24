import React from "react";
import { useEffect } from "react";

const User = React.memo(function User({ user, onRemove, onToggle }) {
  useEffect(() => {
    console.log("user값이 설정됨");
    console.log(user);
    return () => {
      console.log("user가 바뀌기 전");
      console.log(user);
    };
  }, []);
  return (
    <div>
      <b
        style={{ cursor: "pointer", color: user.active ? "green" : "black" }}
        onClick={() => onToggle(user.id)}
      >
        &nbsp;
        {user.username}
      </b>
      <span>({user.email})</span>
      <button onClick={() => onRemove(user.id)}>삭제</button>
    </div>
  );
});

export default User;
// useEffect(()=>{실행할 코드},[]); 렌더링이 끝난 이후 실행되는 코드
// 1. useEffect(()=>{"실행 1번"}, []); : 컴포넌트가 생성될 때 한번 실행
// 2. useEffect(()=>{console.log("count 변경됨")}, []); : count 변경 시 실행
// 3. useEffect(()=>{"실행 1번"}, []); : 렌더링 될 때마다 실행
// useEffect(() => {
//   const id = setInterval(() => {
//     console.log("실행 중");
//   }, 1000);

//   return () => {
//     clearInterval(id);
//   };
// }, []);
// return -> unmount
// 컴포넌트 사라질 때나 다시 실행되기 직전 -> 실행
