import React, { useState } from "react";

function App() {
  const [name, setName] = useState("");
  const [age, setAge] = useState("");

  const [result, setResult] = useState(null);

  const handleSubmit = () => {
    if (!name.trim() || !age.trim()) {
      setResult({ error: true });
      return;
    }
    setResult({ name: name.trim(), age: age.trim() });
  };
  return (
    <div className="app">
      <div className="container">
        <h2>1번 — 상태 관리 + 입력 폼</h2>
        <form>
          <div className="form-group">
            <label>이름 : </label>
            <input
              type="text"
              value={name}
              onChange={(e) => setName(e.target.value)}
              placeholder="이름"
            />
          </div>
          <div className="form-group">
            <label>나이 : </label>
            <input
              type="text"
              value={age}
              onChange={(e) => setAge(e.target.value)}
              placeholder="나이"
            />
          </div>
          <button type="button" onClick={handleSubmit}>
            확인
          </button>
        </form>
        <div className="result-box">
          {result && (
            <div>
              {result.error ? (
                <p>값을 입력하세요</p>
              ) : (
                <>
                  <p>이름: {result.name}</p>
                  <p>나이: {result.age}</p>
                </>
              )}
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default App;
