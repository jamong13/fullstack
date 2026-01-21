package a260121.ex01;

import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("-------------------");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 검색");
            System.out.println("3. 도서 수정");
            System.out.println("4. 도서 삭제");
            System.out.println("5. 전체 출력");
            System.out.println("6. 종료");
            System.out.print("선택 > ");

            int menu;
            try {
                menu = Integer.parseInt(sc.nextLine()); // 숫자를 문자처럼 입력 받아 다시 숫자로 변환
            } catch (Exception e) { // a, b, c, d처럼 문자가 들어오면 예외 처리
                System.out.println("숫자만 입력하세요.");
                // break; -> while문 즉시 종료 -> 프로그램 끝나버림
                continue; // 현재 반복만 건너 뜀 -> while문 처음으로 이동 -> 메뉴 다시 출력
            }

            switch (menu) {
                case 1:
                    // 도서 등록
                    System.out.print("제목 입력: ");
                    String title = sc.nextLine();
                    System.out.print("저자 입력: ");
                    String author = sc.nextLine();
                    list.add(new Book(title, author));
                    System.out.println("도서 등록 완료");
                    break;
                
                case 2:
                    // 도서 검색
                    System.out.print("검색할 제목 입력: ");
                    title = sc.nextLine();
                    Book b = findBook(list, title);
                    if(b != null){
                        System.out.println(b);
                    }else{
                        System.out.println("도서가 없습니다.");
                    }
                    break;

                case 3:
                    // 도서 수정
                    System.out.print("수정할 제목 입력: ");
                    title = sc.nextLine();
                    System.out.print("새 저자 입력: ");
                    author = sc.nextLine();
                    if(updateBook(list, title, author)){
                        System.out.println("수정 완료");
                    }else{
                        System.out.println("해당 도서가 없습니다.");
                    }
                    break;

                case 4:
                    // 도서 삭제
                    System.out.print("삭제할 제목 입력: ");
                    title = sc.nextLine();
                    if(deleteBook(list, title)){
                        System.out.println("삭제 완료");
                    }else{
                        System.out.println("삭제할 도서가 없습니다.");
                    }
                    break;

                case 5:
                    // 전체 출력
                    if(list.isEmpty()){
                        System.out.println("등록된 도서가 없습니다.");
                    }else{
                        for(Book book : list){
                            System.out.println(book);
                        }
                    }
                    break;

                case 6:
                    // 종료
                    run = false;
                    break;
                
                default:
                    System.out.println("1~6번을 선택하세요.");
                    break;
            }
        }
        sc.close();
    }

    private static boolean deleteBook(ArrayList<Book> list, String title) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).title.equals(title)){
                list.remove(i); // 인덱스 번호 삭제
                return true;
            }
        }
        return false;
    }

    private static boolean updateBook(ArrayList<Book> list, String title, String newAuthor) {
        for(Book b : list){
            if(b.title.equals(title)){
                b.author = newAuthor;
                return true; // Book 객체
            }
        }
        return false;
    }

    private static Book findBook(ArrayList<Book> list, String title) {
        for(Book b : list){
            if(b.title.equals(title)){
                return b; // Book 객체
            }
        }
        return null;
    }
}
