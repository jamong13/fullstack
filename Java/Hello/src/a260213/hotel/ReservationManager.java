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
        hotel.getRoom().displayRooms();
        System.out.print("방 번호 입력: ");
        int roomNumber = Integer.parseInt(sc.nextLine());

        if(bookRoom(userName, hotelName, roomNumber)){
            int price = hotel.getPrice();
            int discount = (price * discountRate) / 100;
            int finalPrice = price - discount;
            System.out.println("예약이 완료되었습니다.");
            System.out.println("원가: " + price + "원");
            System.out.println("할인율: " + discountRate + "%");
            System.out.println("할인된 금액: " + discount + "원");
            System.out.println("결제 금액: " + finalPrice + "원");

            User user = getUser(userName);
            if(user != null){
                user.addTotalPaid(finalPrice);
            }
        }else{
            System.out.println("이미 예약된 방입니다.");
        }

    }
    
    // TODO: bookRoom(String userName, String hotelName, int roomNumber) 구현
    // 실제 예약 처리 로직 (private 메서드)
    public boolean bookRoom(String userName, String hotelName, int roomNumber) {
        Hotel hotel = getHotel(hotelName);
        if(hotel == null){
            System.out.println("해당 호텔이 없습니다.");
            return false;
        }
        if(!hotel.getRoom().reserveRoom(roomNumber)){
            System.out.println("이미 예약된 방이거나 잘못 입력하셨습니다.");
            return false;
        }
        User user = getUser(userName);
        if(user == null){
            user = new User(userName);
            users.add(user);
        }
        user.addReservation(hotelName, roomNumber);
        return true;
    }
    
    // TODO: getUser(String userName) 구현
    // 사용자 이름으로 사용자 찾기 (없으면 null 반환)
    public User getUser(String userName) {
        for(User user : users){
            if(user.getName().equals(userName)){
                return user;
            }
        }
        return null;
    }


    // TODO: getHotel(String hotelName) 구현
    // 호텔 이름으로 호텔 찾기 (없으면 null 반환)
    public Hotel getHotel(String hotelName) {
        for(Hotel hotel : hotels){
            if(hotel.getName().equals(hotelName)){
                return hotel;
            }
        }
        return null;
    }

    // TODO: checkReservation() 구현
    // 사용자 이름 입력받아 예약 내역 출력
    public void checkReservation(){
        System.out.print("사용자 이름 입력: ");
        String userName = sc.nextLine();
        User user = getUser(userName);
        if(user != null && !user.getReservedHotels().isEmpty()){
            for(int i = 0; i < user.getReservedHotels().size(); i++){
                System.out.println("예약 번호: " + user.getReservationNumbers().get(i)
                    + " | 호텔 : " + user.getReservedHotels().get(i)
                    + " | 방 : " + user.getReservedRooms().get(i));
            }
            System.out.println("총 결제 금액: " + user.getTotalPaid());
        }else{
            System.out.println("예약된 내역이 없습니다.");
        }
    }

    // TODO: cancelReservation() 구현
    // 예약 번호로 특정 예약 취소
    public void cancelReservation(){
        System.out.print("사용자 이름 입력: ");
        String userName = sc.nextLine();
        User user = getUser(userName);

        if(user == null || user.getReservedHotels().isEmpty()){
            System.out.println(userName + "님은 예약된 내역이 없습니다.");
            return;
        }
        user.showReservations();
        System.out.println("취소할 예약 번호를 입력해 주세요.");
        int reservationNumber = sc.nextInt();
        sc.nextLine();
        int index = user.getReservationNumbers().indexOf(reservationNumber);
        if(index == -1){
            System.out.println("해당 예약 번호의 예약이 없습니다.");
            return;
        }
        String hotelName = user.getReservedHotels().get(index);
        int roomNumber = user.getReservedRooms().get(index);

        Hotel hotel = getHotel(hotelName);
        if(hotel != null){
            hotel.getRoom().cancelRoom(roomNumber);
            System.out.println("호텔 [" + hotelName + "] 방 [" + roomNumber + "]호의 예약이 취소되었습니다.");
        }
        user.cancelReservation(hotelName, roomNumber);
    }

    // TODO: cancelAllReservation() 구현
    // 사용자의 모든 예약 취소
    public void cancelAllReservation(){
        System.out.print("사용자 이름 입력: ");
        String userName = sc.nextLine();
        User user = getUser(userName);
        if(user == null || user.getReservedHotels().isEmpty()){
            System.out.println(userName + "님은 예약된 내역이 없습니다.");
            return;
        }
        ArrayList<String> hotels = new ArrayList<>(user.getReservedHotels());
        ArrayList<Integer> rooms = new ArrayList<>(user.getReservedRooms());
        ArrayList<Integer> numbers = new ArrayList<>(user.getReservationNumbers());

        for(int i = 0; i < hotels.size(); i++){
            String hotelName = hotels.get(i);
            int roomNumber = rooms.get(i);
            int reservationNumber = numbers.get(i);
            Hotel hotel = getHotel(hotelName);

            if(hotel != null){
                hotel.getRoom().cancelRoom(roomNumber);
                System.out.println("호텔 [" + hotelName + "] 방 [" + roomNumber + "]호의 예약이 취소되었습니다.");
            }
        }
        user.clearReservations();
        System.out.println("\n"+ userName + "님의 모든 예약이 취소되었습니다.");
    }

    // TODO: printTicket() 구현
    // 예약 번호 입력받아 티켓 출력
    public void printTicket() {
        System.out.println("\n=== 티켓 출력 ===");
         boolean hasReservation = false;
        for (User user : users) {
            if (!user.getReservationNumbers().isEmpty()) {
                user.showReservations();
                hasReservation = true;
            }
        }
        
    if (!hasReservation) {
        System.out.println("예약된 내역이 없습니다.");
        return;
    }
        System.out.print("예약 번호를 입력하세요: ");
        int reservationNum = -1;

        try {
            reservationNum = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("숫자를 입력하세요.");
        }

        if(reservationNum != -1){
            if(ticket == null){
                ticket = new ReservationTicket(this);
            }
            ticket.printTicket(reservationNum);
        }
    }

    // TODO: getReservationDetails(int reservationNum) 구현
    // 예약 번호로 예약 정보 문자열 반환
    public String getReservationDetails(int reservationNum){
        for(User user : users){
            if(user.getReservationNumbers().contains((reservationNum))){
                int index = user.getReservationNumbers().indexOf(reservationNum);
                return "예약 번호: " + user.getReservationNumbers().get(index) +
                       " | 호텔: " + user.getReservedHotels().get(index) +
                       " | 방: " + user.getReservedRooms().get(index);
            }
        }
        return null;
    }

    // TODO: deleteHotel(Scanner sc) 구현
    // 호텔 삭제 (해당 호텔의 모든 예약도 함께 취소)
    public void deleteHotel(Scanner sc){
        System.out.print("삭제할 호텔을 입력하세요: ");
        String hotelName = sc.nextLine();
        Hotel hotel = getHotel(hotelName);
        if(hotel != null){
            for(User user : users){
                ArrayList<String> reservedHotels = user.getReservedHotels();
                if(reservedHotels.contains(hotelName)){
                    ArrayList<Integer> reservationNumbers = new ArrayList<>(user.getReservationNumbers());
                    for(int i = 0; i < reservationNumbers.size(); i++){
                        if(user.getReservedHotels().get(i).equals(hotelName)){
                            int roomNumber = user.getReservedRooms().get(i);
                            hotel.getRoom().cancelRoom(roomNumber);
                            System.out.println("[" + reservationNumbers.get(i) + "] 예매도 함께 취소되었습니다.");
                        }
                    }
                    user.removeReservationsByHotel(hotelName);
                }
            }
            hotels.remove(hotel);
            System.out.println("[" + hotelName + "] 호텔이 삭제되었습니다.");
        }else{
            System.out.println("해당 호텔이 존재하지 않습니다.");
        }
    }

    // TODO: modifyHotelInfo(Scanner sc) 구현
    // 호텔 정보 수정 (모든 예약 취소 후 수정)
    public void modifyHotelInfo(Scanner sc){
        System.out.print("수정할 호텔 이름을 입력하세요: ");
        String hotelName = sc.nextLine();
        Hotel hotel = getHotel(hotelName);
        if(hotel == null){
            System.out.println("해당 호텔이 없습니다.");
            return;
        }
        System.out.println("현재 정보: " + hotel.getName() + ", " + hotel.getLocation() + ", " + hotel.getPrice() + "원");
        System.out.println("수정할 정보를 입력하세요. #미 입력 시 기존 정보 유지됩니다. 또한 모든 예약은 취소 됩니다.");

        for(User user : users){
            ArrayList<String> reservedHotels = user.getReservedHotels();
            if(reservedHotels.contains(hotelName)){
                ArrayList<Integer> reservationNumbers = new ArrayList<>(user.getReservationNumbers());
                for(int i = 0; i < reservationNumbers.size(); i++){
                    if(user.getReservedHotels().get(i).equals(hotelName)){
                        int roomNumber = user.getReservedRooms().get(i);
                        hotel.getRoom().cancelRoom(roomNumber);
                        System.out.println("[" + reservationNumbers.get(i) + "] 예약도 취소되었습니다.");
                    }
                }
                user.removeReservationsByHotel(hotelName);
            }
        }
        System.out.print("새 이름: ");
        String newHotel = sc.nextLine();
        if(newHotel.isEmpty()){
            newHotel = hotel.getName();
        }
        System.out.print("새 위치: ");
        String newLocation = sc.nextLine();
        if(newLocation.isEmpty()){
            newLocation = hotel.getLocation();
        }
        System.out.print("새 가격: ");
        String priceInput = sc.nextLine();
        int newPrice = 0;
        try {
            if(priceInput.trim().isEmpty()){
                // 공란을 입력 시 기존 가격 유지
                newPrice = hotel.getPrice();
            }else{
                newPrice = Integer.parseInt(priceInput);
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }

        System.out.print("새 방 수: ");
        String roomInput = sc.nextLine();
        int newRooms = 0;
        try {
            if(roomInput.trim().isEmpty()){
                newRooms = hotel.getRoom().getAvailableRooms();
            }else{
                newRooms = Integer.parseInt(roomInput);
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 방 수는 숫자여야 합니다.");
            return;
        }
        Hotel updateHotel = new Hotel(newHotel, newLocation, newPrice, newRooms);
        hotels.remove(hotel);
        hotels.add(updateHotel);
        System.out.println("호텔 정보가 수정되었습니다.");
    }

    // TODO: setDiscountRate(Scanner sc) 구현
    // 할인율 설정
    public void setDiscountRate(Scanner sc){
        System.out.println("현재 할인율" + discountRate + "%");
        System.out.print("할인율(%)을 입력하세요: ");
        try {
            discountRate = Integer.parseInt(sc.nextLine());
            System.out.println("할인율이 " + discountRate + "%로 설정되었습니다.");
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
        }
    }

    // TODO: getDiscountRate() 구현
    // 할인율 반환
    public int getDiscountRate(){
        return discountRate;
    }
}
