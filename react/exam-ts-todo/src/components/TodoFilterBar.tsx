import type { TodoFilter } from "../types/todo";

export interface TodoFilterBarProps {
  filter: TodoFilter;
  onChange: (filter: TodoFilter) => void;
  activeCount: number;
  completedCount: number;
}
const FILTERS: { value: TodoFilter; label: string }[] = [
  // 버튼 정보로 데이터 관리
  { value: "all", label: "전체" },
  { value: "active", label: "할 일" },
  { value: "completed", label: "완료" },
];

function TodoFilterBar({
  filter,
  onChange,
  activeCount,
  completedCount,
}: TodoFilterBarProps) {
  // filter -> 현재 선택된 필터
  // onChange -> 필터 변경 함수
  // activeCount -> 미완료 개수
  // completedCount -> 완료 개수
  return (
    <div className="filter-bar">
      {FILTERS.map(
        // 배열 돌면서 버튼 생성 -> 전체 할일, 완료
        ({ value, label }) => (
          <button
            key={value}
            type="button"
            className={filter === value ? "filter active" : "filter"}
            onClick={() => onChange(value)}
          >
            {label}
            {value === "active" ? `(${activeCount})` : null}
            {value === "completed" ? `(${completedCount})` : null}
          </button>
        ),
      )}
    </div>
  );
}

export default TodoFilterBar;
// 상태 흐름
// 버튼 클릭 -> onChange(value) -> 부모 setFilter(value) -> filter 상태를 변경
// TodoFilterBar 다시 렌더링 -> 선택된 버튼 스타일 변경(active) -> filterTodos 실행 -> 리스트 변경
