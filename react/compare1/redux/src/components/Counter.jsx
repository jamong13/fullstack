import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { decrement, increment, reset } from "../store/counterSlice";

export default function Counter() {
  const count = useSelector((state) => state.counter.value);
  const dispatch = useDispatch();
  // redux의 상태를 변경하는 함수
  return (
    <div className="counter">
      <div className="counter-display">{count}</div>
      <div className="button-group">
        <button onClick={() => dispatch(decrement())}>-</button>
        <button onClick={() => dispatch(reset())}>Reset</button>
        <button onClick={() => dispatch(increment())}>+</button>
      </div>
    </div>
  );
}
