import React, { createContext, useContext, useState } from "react";

//Context 생성 - 전역 데이터 통로(빈 통로)
const AppContext = createContext();

// Provieder (데이터 공급자)
// Context에 값을 넣어주는 컴포넌트
// children - 감싸진 컴포넌트
export default function AppProvider({ children }) {
  // 컴포넌트
  const [count, setCount] = useState(0); // 카운터
  const [user, setUser] = useState({
    //user 사용자 정보
    name: "홍길동",
    age: 25,
  });

  const updateUserName = (name) => setUser({ ...user, name });
  //기존의 user를 펼쳐 놓고 name 변경
  const updateUserAge = (age) => setUser({ ...user, age });

  const incrementCount = () => setCount(count + 1);
  const decrementCount = () => setCount(count - 1);
  const resetCount = () => setCount(0);

  const value = {
    count,
    user,
    incrementCount,
    decrementCount,
    resetCount,
    updateUserName,
    updateUserAge,
    // 전역 데이터
  };

  return <AppContext.Provider value={value}>{children}</AppContext.Provider>;
  //   Provider로 감싸진 모든 컴포넌트에서 value 접근 가능
}

export function useAppContext() {
  const context = useContext(AppContext);
  if (!context) {
    throw new Error("useAppContext must be used within AppProvieder");
  }
  return context;
}
