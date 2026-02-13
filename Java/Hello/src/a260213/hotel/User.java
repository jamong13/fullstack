package a260213.hotel;

import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Integer> reservationNumbers;  // 예약번호 저장
    private ArrayList<String> reservedHotels;        // 예약한 호텔 이름 저장
    private ArrayList<Integer> reservedRooms;         // 예약한 방 번호 저장
    private static int reservationCounter = 1;       // 모든 사용자가 공유하는 예약번호
    private int totalPaid = 0;                       // 누적 결제 금액
    
    // TODO: 생성자 구현
    // name을 받아서 초기화하고, 모든 ArrayList를 초기화
    public User(String name) {
        this.name = name;
        this.reservationNumbers = new ArrayList<>();
        this.reservedHotels = new ArrayList<>();
        this.reservedRooms = new ArrayList<>();
    }
    
    // TODO: getter 메서드들 구현
    public String getName() {
        return name;
    }

    public ArrayList<Integer> getReservationNumbers() {
        return reservationNumbers;
    }

    public ArrayList<String> getReservedHotels() {
        return reservedHotels;
    }

    public ArrayList<Integer> getReservedRooms() {
        return reservedRooms;
    }

    public static int getReservationCounter() {
        return reservationCounter;
    }

    public int getTotalPaid() {
        return totalPaid;
    }

    // TODO: addReservation(String hotelName, int roomNumber) 구현
    // 예약 정보를 추가하고, 예약번호를 부여한 후 reservationCounter 증가
    public void addReservation(String hotelName, int roomNumber){
        reservedHotels.add(hotelName);
        reservedRooms.add(roomNumber);
        reservationNumbers.add(reservationCounter++);
    }

    // TODO: addTotalPaid(int amount) 구현
    // 총 결제 금액에 amount 추가
    public void addTotalPaid(int amount){
        totalPaid += amount;
    }

    // TODO: showReservations() 구현
    // 모든 예약 내역을 출력
    public void showReservations(){
        System.out.println("\n예약 내역 출력");
        for(int i = 0; i < reservedRooms.size(); i++){
            System.out.println("예약번호: " + reservationNumbers.get(i) 
                + " | 예약한 호텔: " + reservedHotels.get(i) 
                + " | 예약한 방 번호: " + reservedRooms.get(i));
        }
    }

    // TODO: cancelReservation(String hotelName, int roomNumber) 구현
    // 특정 호텔의 특정 방 예약 취소
    public void cancelReservation(String hotelName, int roomNumber){
        int index = reservedHotels.indexOf(hotelName);
        if(index != -1 && reservedRooms.get(index) == roomNumber){
            reservedHotels.remove(index);
            reservedRooms.remove(index);
            reservationNumbers.remove(index);
        }
    }

    // TODO: clearReservations() 구현
    // 모든 예약 내역 초기화
    public void clearReservations(){
        reservedHotels.clear();
        reservedRooms.clear();
        reservationNumbers.clear();
    }

    // TODO: removeReservationsByHotel(String hotelName) 구현
    // 특정 호텔의 모든 예약 취소
    // 주의: 뒤에서부터 삭제해야 인덱스 오류 방지
    public void removeReservationsByHotel(String hotelName){
        for(int i = reservedHotels.size() - 1; i >= 0; i--){
            if(reservedHotels.get(i).equals(hotelName)){
                reservedHotels.remove(i);
                reservedRooms.remove(i);
                reservationNumbers.remove(i);
            }
        }
    }
}
