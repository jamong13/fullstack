package a260202.book_ex;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BookService {
    private boolean reRental = false;
    private int memberAccount = 1;
    Map<String, Integer> rentalList;

    public BookService(){
        rentalList = new LinkedHashMap<>();
    }

    Book book = Book.getInstance();
    Member member;
    Thread t = new Thread();
    Scanner sc = new Scanner(System.in);

    public void start(){
        System.out.println("\n어서오세요. 더조은도서관입니다.");
        member = new Member(memberAccount);
        book.getList();
        rental();
        totalRental(member);
        try {
            System.out.println("기다려 주시면 대여하신 도서를 준비하겠습니다.");
            t.sleep(2000);
            // 2초 후 다음 문장 실행
            end();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void end() {
        int s = 1;
        StringBuffer message = new StringBuffer();
        message.append("\n\n ")
                .append("+----------------------------------------------------+\n ")
                .append("|                                                    | \n ")
                .append("|  " + member.getAccont() + " 회원님 대여하신 도서 준비되었습니다.   | " + "\n");
        System.out.print(message);
        for(Map.Entry<String, Integer> rental : member.getRentalBook().entrySet()){
            System.out.printf(" | [%d] %-20s : %2d일  %7s |\n", s, rental.getKey(), rental.getValue(), "");
            s++;
        }
        System.out.println(" |                                                    |");
        System.out.println(" +----------------------------------------------------+");
    }

    private void totalRental(Member member2) {
        int s = 1;
        int totalMoney = 0;
        int rentalPrice = 0;
        DecimalFormat f = new DecimalFormat("###,000원");
        String name = member.getAccont() + "번";
        StringBuffer message = new StringBuffer();
        message.append("\n\n")
            .append("+----------------------------------------------------+\n")
            .append("|                                                    | \n")
            .append("|             " + name + " 회원님 의 주문 내역 입니다         | " + "\n");

        for(Map.Entry<String, Integer> rental : member.getRentalBook().entrySet()){
            String bookTitle = rental.getKey();
            int rentalDays = rental.getValue();
            int rentalUnitPrice = book.books.get(bookTitle);

            rentalPrice = rentalUnitPrice * rentalDays;
            totalMoney += rentalPrice;
            String pay = f.format(rentalPrice);
            message.append(String.format("|  [%d] %-20s : %2d일  %7s  |\n", s, bookTitle, rentalDays, pay));
            s++;
        }
        message.append("|                                                    |\n")
            .append("+----------------------------------------------------+ \n")
            .append("============ 총 결제 금액은 " + f.format(totalMoney) + "입니다 ========== \n");
            System.out.println(message);
            payment(totalMoney);
    }

    private void payment(int totalMoney) {
        System.out.println("\n결제를 도와 드리겠습니다. 카드를 넣어주세요.");
        int payResult = member.getMoney() - totalMoney; // 고객 잔고 - 결재 총 금액
        try {
            System.out.println("\n결제 중입니다.");
            t.sleep(2000); // 2초 후 실행
            if(payResult < 0){
                System.out.println("잔액 부족, 주문 다시 해주세요.");
            }else{
                member.setMoney(payResult); // 결제 후 잔액을 고객 잔고에 넣어 놓기
                System.out.println("결제 완료되었습니다.");
                System.out.println("이용해 주셔서 감사합니다.");
                memberAccount++; // 고객 번호 증가
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }// 예외 발생 메세지 자바가 알아서 출력
    }

    private void rental() {
        System.out.println("\n취소를 원하시면 0번을 눌러주세요");
        end:while (true) {
            try {
                System.out.print("원하는 도서의 번호를 선택해주세요 :");
                String choice = sc.next();
                int choiceNum = Integer.parseInt(choice.substring(0, 1));

                if(choiceNum == 0){
                    System.out.println("대여를 취소합니다.");
                    System.exit(0);
                }
                sc.nextLine();

                String bookTitle = book.bookList.get(choiceNum -1);
                System.out.print("선택 하신 도서는 " + bookTitle + "입니다. 며칠 대여하시겠습니까?");
                int rentalDays = sc.nextInt();
                sc.nextLine();

                if(reRental){
                    for(String b : rentalList.keySet()){
                        if(b.equals(bookTitle)){
                            int addDays = rentalList.get(b).intValue() + rentalDays;
                            rentalList.replace(bookTitle, addDays);
                        }else{
                            rentalList.put(bookTitle, rentalDays);
                            break;
                        }
                    }
                }else{
                    rentalList.put(bookTitle, rentalDays);
                }
                member.setRentalBook(rentalList);
                addRental();
                break end;
            } catch (Exception e) {
                System.out.println("잘못된 선택입니다.");
            }
        }
    }

    private void addRental() {
        reRental = false;
        System.out.println("\n대여를 계속 하시겠습니까?");
        System.out.println("예(Y) / 아니오(N)");
        String yesOrNo = sc.nextLine();
        if(yesOrNo.equals("예") || yesOrNo.equalsIgnoreCase("y")){
            book.getList();
            reRental = true;
            rental();
        }else if(yesOrNo.equals("아니요") || yesOrNo.equalsIgnoreCase("n")){
            return;
        }
    }

}
