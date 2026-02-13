package a260213.hotel;

import java.util.ArrayList;

public class Room {
    private ArrayList<String> rooms;
    
    // TODO: 생성자 구현
    // roomCount만큼 방을 생성하고, 각 방 번호를 문자열로 저장
    // 예: 50개 방이면 "1", "2", "3", ..., "50"

    public Room(int roomCount) {
        rooms = new ArrayList<>();
        for(int i = 0; i < roomCount; i++){
            rooms.add((i + 1) + "");
        }
    }

    // TODO: getAvailableRooms() 구현
    // 예약되지 않은 방의 개수를 반환 ("X"가 아닌 방의 개수)
    public int getAvailableRooms(){
        int count = 0;
        for(String room : rooms){
            if(!room.equals("X")){
                count++;
            }
        }
        return count;
    }

    // TODO: displayRooms() 구현
    // 모든 방의 상태를 출력 (예약된 방은 "X", 예약 안 된 방은 방 번호)
    // 10개씩 줄바꿈하여 출력
    public void displayRooms(){
        System.out.println("\n예약 상태(예약된 방: X)");
        for(int i = 0; i < rooms.size(); i++){
            System.out.printf("%2s ", rooms.get(i));
            if((i + 1) % 10 == 0){
                System.out.println();
            }
        }
    }

    // TODO: reserveRoom(int roomNumber) 구현
    // 방을 예약 (해당 방 번호를 "X"로 변경)
    // 성공하면 true, 실패하면 false 반환
    public boolean reserveRoom(int roomNumber){
        if(roomNumber > 0 && roomNumber <= rooms.size() && !rooms.get(roomNumber - 1).equals("X")){
            rooms.set(roomNumber - 1, "X");
            return true;
        }
        return false;
    }


    // TODO: cancelRoom(int roomNumber) 구현
    // 방 예약 취소 (해당 방 번호를 원래 번호로 복원)
    public void cancelRoom(int roomNumber){
        if(roomNumber > 0 && roomNumber <= rooms.size() && rooms.get(roomNumber - 1).equals("X")){
            rooms.set(roomNumber - 1, String.valueOf(roomNumber));
        }
    }
}
