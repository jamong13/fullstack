package a260213.hotel;

import java.util.Scanner;

public class HotelReservationMain {
    public static void main(String[] args) {
        // TODO: Scanner, ReservationManager, ReservationTicket 초기화
        Scanner sc = new Scanner(System.in);
        ReservationManager manager = new ReservationManager();
        ReservationTicket ticket = new ReservationTicket(manager);

        // TODO: 초기 호텔 2개 추가
        // 예: new Hotel("그랜드 호텔", "서울 강남구", 150000, 50)
        manager.addHotel(new Hotel("그랜드호텔", "서울 강남구", 150000, 50));
        manager.addHotel(new Hotel("시그니엘 서울", "서울 송파구", 580800, 100));

        // TODO: 무한 루프로 메인 메뉴 구현
        // 1. 사용자 로그인
        // 2. 운영자 로그인
        // 0. 종료
        while (true) {
            System.out.println("\n=== 호텔 예약 시스템 ===");
            System.out.println("1. 사용자 로그인");
            System.out.println("2. 운영자 로그인");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    userMenu(manager, sc);
                    break;
                case "2":
                    adminLogin(manager, ticket, sc);
                    break;
                case "0":
                    System.out.println("시스템을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }

    }
    
    // TODO: userMenu() 메서드 구현
    // 1. 예약 가능한 호텔 정보
    // 2. 호텔 예약
    // 3. 예약 조회
    // 4. 예약 취소
    // 5. 예약 일괄 취소
    // 6. 예약 티켓 출력
    // 0. 뒤로가기
    private static void userMenu(ReservationManager manager, Scanner sc) {
        End:while (true) {
            System.out.println("\n=== 호텔 방 예약 시스템 ===");
            System.out.println("1. 예약 가능한 호텔 정보");
            System.out.println("2. 호텔 예약");
            System.out.println("3. 예약 조회");
            System.out.println("4. 예약 취소");
            System.out.println("5. 예약 일괄 취소");
            System.out.println("6. 예약 티켓 출력");
            System.out.println("0. 뒤로가기");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manager.showHotels();
                    break;
                case 2:
                    manager.showHotels();
                    manager.hotelReservation();
                    break;
                case 3:
                    manager.checkReservation();
                    break;
                case 4:
                    manager.cancelReservation();
                    break;
                case 5:
                    manager.cancelAllReservation();
                    break;
                case 6:
                    manager.printTicket();
                    break;
                case 0:
                    break End;
            
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                    break;
            }
        }
    }
    // TODO: adminLogin() 메서드 구현
    // 비밀번호 확인 후 운영자 메뉴
    // 1. 호텔 삭제
    // 2. 호텔 목록 갱신
    // 3. 호텔 정보 수정
    // 4. 호텔 추가
    // 5. 할인율 설정
    // 0. 뒤로가기
    private static void adminLogin(ReservationManager reservationManager, ReservationTicket ticket, Scanner sc) {
        System.out.println("운영자 비밀번호를 입력하세요: ");
        String password = sc.nextLine();
        if(!password.equals("admin123")){
            System.out.println("비밀번호가 틀렸습니다.");
            return;
        }
        while (true) {
            System.out.println("\n=== 운영자 메뉴===");
            System.out.println("1. 호텔 삭제");
            System.out.println("2. 호텔 목록 갱신");
            System.out.println("3. 호텔 정보 수정");
            System.out.println("4. 호텔 추가");
            System.out.println("5. 할인율 설정");
            System.out.println("0. 뒤로가기");
            System.out.print("선택: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    reservationManager.showHotels();
                    reservationManager.deleteHotel(sc);
                    break;
                case "2":
                    ticket.updateHotelList();
                    System.out.println("호텔 목록이 갱신되었습니다.");
                    break;
                case "3":
                    reservationManager.showHotels();
                    reservationManager.modifyHotelInfo(sc);;
                    break;
                case "4":
                    addHotel(reservationManager, sc);
                    break;
                case "5":
                    reservationManager.setDiscountRate(sc);
                    break;
                case "0":
                    return;
            
                default:
                    break;
            }
        }
    }
    // TODO: addHotel() 메서드 구현
    // 운영자가 직접 호텔 추가하는 기능
    private static void addHotel(ReservationManager manager, Scanner sc) {
        System.out.println("\n=== 직접 호텔 정보 입력 ===");
        
        System.out.print("호텔 이름: ");
        String hotelName = sc.nextLine();
        
        System.out.print("위치: ");
        String location = sc.nextLine();
        
        System.out.print("가격: ");
        int price;
        try {
            price = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return;
        }
        
        System.out.print("방 수: ");
        int roomCount;
        try {
            roomCount = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요.");
            return;
        }
        
        manager.addHotel(new Hotel(hotelName, location, price, roomCount));
        System.out.println("[" + hotelName + "] 호텔이 추가되었습니다.");
    }
}