import type { Todo, TodoFilter } from "../types/todo";

export function filterTodos(todos: Todo[], filter: TodoFilter) {
  // 화면용 데이터 - 지금 보여줄 목록
  switch (filter) {
    case "active":
      return todos.filter((t) => !t.done); // done이 false (아직 안 끝남)
    case "completed":
      return todos.filter((t) => t.done); // done이 true (완료된 것)
    default:
      return todos; // all 전체 반환
  }
}
// filter 값에 따라 보여줄 Todo 목록만 골라서 반환
// todos 전체 할 일 목록
// filter 현재 필터 상태('all', 'active', 'completed')

// 완료 / 미완료 개수
export function countByDone(todos: Todo[]) {
  return todos.reduce(
    // reduce 개수 집계 - 통계함수 : 배열 한번 돌면서 집계
    (acc, t) => {
      // acc는 누적값, t 현재 todo 초기값(active: 0, completed: 0)
      if (t.done) acc.completed += 1;
      else acc.active += 1;
      return acc;
    },
    { active: 0, completed: 0 },
  );
}
