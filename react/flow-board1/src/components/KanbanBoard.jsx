import { useCallback, useMemo, useState } from "react";
import Column from "./Column";

function KanbanBoard({
  columns,
  cards,
  onAddCard,
  onMoveCard,
  onDeleteCard,
  onUpdateCard,
}) {
  const [draggedCard, setDraggedCard] = useState(null);
  const [dragOverColumn, setDragOverColumn] = useState(null);

  const columnCardMap = useMemo(() => {
    const map = {};
    columns.forEach((col) => {
      map[col.id] = [];
    });
    // map 초기화
    // {
    // ideas:[],
    // today:[],
    // progress:[],
    // done:[]
    // }
    cards.forEach((card) => {
      if (map[card.columnId]) {
        map[card.columnId].push(card);
      }
    });
    return map;
  }, [cards, columns]);
  // {
  // ideas : [카드1, 카드2]
  // today : [카드3]
  // ...
  // }
  // columnCardMap = {
  // ideas : [...]
  // today : [...]
  // }
  // filter 방식 : 컬럼 수 * 카드 수
  // 카드 수 한 번만 실행
  // Card 또는 columns 바뀔 때만 재계산
  const handleDragStart = useCallback((e, card) => {
    setDraggedCard(card);
    e.dataTransfer.effectAllowed = "move";
    e.dataTransfer.setData("text/plain", card.id);
    e.target.style.opacity = "0.5";
  }, []);
  // setData(format, data) 택배 상자에 물건을 넣는 과정
  //   .effectAllowed 어떤 동작이 가능한지 설정 move(이동), copy(복사), link(연결)
  //   e.dataTransfer 브라우저 표준 방식(안정적)

  //   draggedCard : 복잡한 객체 데이터 전체 다룰 때 id, 카드에 내용(content), 날짜 정보를 참조해서
  // 카드의 배경색 변경 - 실시간 피드백 주기 좋음
  const handleDragEnd = useCallback((e) => {
    e.target.style.opacity = "1";
    setDraggedCard(null);
    setDragOverColumn(null);
  }, []);

  const handleDragOver = useCallback((e, columnId) => {
    e.preventDefault();
    e.dataTransfer.dropEffect = "move";
    setDragOverColumn(columnId);
  }, []);

  const handleDragLeave = useCallback(() => {
    setDragOverColumn(null);
  }, []);

  const handleDrop = useCallback(
    (e, targetColumnId) => {
      e.preventDefault();
      const cardId = e.dataTransfer.getData("text/plain");
      if (cardId && draggedCard && draggedCard.columnId !== targetColumnId) {
        onMoveCard(cardId, targetColumnId);
      }
      // getData(format) 목적지에 도착해서 상자를 열어 물건을 꺼냄
      setDraggedCard(null);
      setDragOverColumn(null);
    },
    [draggedCard, onMoveCard],
  );

  return (
    <main className="board">
      {columns.map((column) => (
        <div
          key={column.id}
          className={`column-wrapper ${dragOverColumn === column.id ? "drag-over" : ""}`}
          onDragOver={(e) => handleDragOver(e, column.id)}
          onDragLeave={handleDragLeave}
          onDrop={(e) => handleDrop(e, column.id)}
        >
          <Column
            column={column}
            cards={columnCardMap[column.id] || []}
            // 컬럼 4개 -> filter 4번 실행, 렌더링 때마다 반복
            onAddCard={onAddCard}
            onDeleteCard={onDeleteCard}
            onUpdateCard={onUpdateCard}
            onDragStart={handleDragStart}
            onDragEnd={handleDragEnd}
            isDragging={draggedCard?.columnId === column.id}
          />
        </div>
      ))}
    </main>
  );
}

export default KanbanBoard;
