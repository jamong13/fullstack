package a260213.hotel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ReservationTicket {
    private ReservationManager reservationManager;
    
    // TODO: 생성자 구현
    public ReservationTicket(ReservationManager reservationManager){
        this.reservationManager = reservationManager;
    }
    
    // TODO: printTicket(int reservationNum) 구현
    // 1. d:\\hotelReservation 폴더 생성 (없으면)
    // 2. ticket_{reservationNum}.txt 파일 생성
    // 3. 예약 정보를 파일에 저장
    // 4. 예외 처리 포함
    public void printTicket(int reservationNum) {
        try {
            File dir = new File("C:\\Users\\limeh\\HotelTicket");
            if(!dir.exists()){
                // 폴더가 없으면
                dir.mkdir(); // 생성
            }
            File file = new File(dir, "ticket_" + reservationNum + ".txt");
            boolean isNewFile = file.createNewFile(); // 파일이 없으면 생성

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
                if(file.canWrite()){
                    if(!isNewFile){
                        bufferedWriter.newLine(); // 기존 파일이면 개행(줄바꿈)
                    }
                    // 예매 정보를 가져와서 저장
                    String ticketInfo = reservationManager.getReservationDetails(reservationNum);
                    if(ticketInfo == null){
                        System.out.println("예매 정보를 찾을 수 없습니다.");
                        return;
                    }
                    bufferedWriter.write(ticketInfo);
                    bufferedWriter.flush();
                    System.out.println("티켓 출력 성공");
                }else{
                    System.out.println("티켓 출력 실패 : 권한 문제");
                }
            } 
        } catch (Exception e) {
            System.out.println("티켓 출력 실패: " + e.getMessage());
        }
    }

    // TODO: updateHotelList() 구현
    // 1. d:\\hotelReservation\\hotelList.txt 파일 읽기
    // 2. 각 줄을 "/"로 분리하여 파싱
    // 3. 형식: 호텔이름/위치/가격/방개수
    // 4. 중복 호텔 확인 후 추가
    // 5. 예외 처리 포함
    public void updateHotelList(){
        File file = new File("C:\\Users\\limeh\\HotelTicket\\hotelList.txt");

        if (!file.exists()) {
            System.out.println("hotelList.txt 파일이 존재하지 않습니다.");
            return;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))){
            String line;
            System.out.println("===============================");
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if(line.isEmpty()) continue;

                String[] hotels = line.split("/");
                if(hotels.length != 4){
                    System.out.println("잘못된 형식의 호텔 정보: " + line);
                }
                try {
                    String hotelName = hotels[0];
                    String location = hotels[1];
                    int rows = Integer.parseInt(hotels[2]);
                    int totalRooms = Integer.parseInt(hotels[3]);

                    if(reservationManager.getHotel(hotelName) != null){
                        System.out.println("중복된 호텔 [" + hotelName + "]은(는) 추가되지 않습니다.");
                        continue;
                    }
                    Hotel hotel = new Hotel(hotelName, location, rows, totalRooms);
                    reservationManager.addHotel(hotel);
                    System.out.println("호텔 추가됨: " + hotel.getName());
                } catch (NumberFormatException e) {
                    System.out.println("방 수 또는 행 수가 잘못된 숫자입니다.");
                }
            }
        } catch (Exception e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }
}