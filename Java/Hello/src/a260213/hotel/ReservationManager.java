package a260213.hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class ReservationManager {
    private ArrayList<Hotel> hotels;
    private ArrayList<User> users;
    private Scanner sc;
    private static ReservationTicket ticket;
    private int discountRate = 0;
    
    // TODO: 생성자 구현
    // hotels, users ArrayList 초기화, Scanner 초기화
    public ReservationManager() {
        this.hotels = new ArrayList<>(0);
        this.users = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }
    

    // TODO: addHotel(Hotel hotel) 구현
    // 호텔 목록에 추가
    public void addHotel(Hotel hotel){
        hotels.add(hotel);
    }

    // TODO: showHotels() 구현
    // 모든 호텔 정보 출력
    public void showHotels(){
        System.out.println("\n호텔 목록");
        for(Hotel hotel : hotels){
            System.out.println(hotel);
        }
    }

    // TODO: hotelReservation() 구현
    // 1. 호텔 이름과 사용자 이름 입력받기
    // 2. 호텔 찾기
    // 3. 방 목록 출력
    // 4. 방 번호 선택받기
    // 5. 예약 처리 및 할인율 적용하여 결제 금액 계산
    // 6. 사용자에게 결제 금액 누적
    public void hotelReservation(){
        System.out.print("호텔 이름: ");
        String hotelName = sc.nextLine();
        System.out.print("사용자 이름: ");
        String userName = sc.nextLine();
        Hotel hotel = getHotel(hotelName);

        if(hotel == null){
            System.out.println("해당 호텔이 존재하지 않습니다.");
            return;
        }

    }
    
    // TODO: bookRoom(String userName, String hotelName, int roomNumber) 구현
    // 실제 예약 처리 로직 (private 메서드)
    
    // TODO: getUser(String userName) 구현
    // 사용자 이름으로 사용자 찾기 (없으면 null 반환)
    
    // TODO: getHotel(String hotelName) 구현
    // 호텔 이름으로 호텔 찾기 (없으면 null 반환)
        private Hotel getHotel(String hotelName) {
            for(Hotel hotel : hotels){
                if(hotel.getName().equals(hotelName)){
                    return hotel;
                }
            }
            return null;
        }

    // TODO: checkReservation() 구현
    // 사용자 이름 입력받아 예약 내역 출력

    // TODO: cancelReservation() 구현
    // 예약 번호로 특정 예약 취소

    // TODO: cancelAllReservation() 구현
    // 사용자의 모든 예약 취소

    // TODO: printTicket() 구현
    // 예약 번호 입력받아 티켓 출력

    // TODO: getReservationDetails(int reservationNum) 구현
    // 예약 번호로 예약 정보 문자열 반환

    // TODO: deleteHotel(Scanner sc) 구현
    // 호텔 삭제 (해당 호텔의 모든 예약도 함께 취소)

    // TODO: modifyHotelInfo(Scanner sc) 구현
    // 호텔 정보 수정 (모든 예약 취소 후 수정)

    // TODO: setDiscountRate(Scanner sc) 구현
    // 할인율 설정

    // TODO: getDiscountRate() 구현
    // 할인율 반환
}
