import React from "react";
import { useState } from "react";

function App() {
  const [todos, setTodos] = useState([]);
  const [input, setInput] = useState("");

  const handleAdd = () => {
    if (!input.trim()) return;

    const newTodo = {
      id: Date.now(),
      text: input.trim(),
    };

    setTodos([...todos, newTodo]);
    setInput("");
  };

  const handleDelete = (id) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };
  return (
    <div className="app">
      <div className="container">
        <h2>2번 — 리스트 렌더링 + 삭제</h2>
        <form>
          <input
            type="text"
            value={input}
            onChange={(e) => setInput(e.target.value)}
            placeholder="할 일"
          />
          <button type="button" onClick={handleAdd}>
            추가
          </button>
        </form>
        <ul>
          {todos.map((todo) => (
            <li key={todo.id}>
              {todo.text}
              <button onClick={() => handleDelete(todo.id)}>삭제</button>
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

export default App;
