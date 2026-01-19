package a260119.book1;

import java.util.ArrayList;
import java.util.Scanner;

public class BookApp {
    public static void main(String[] args) {
        ArrayList<Book> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("---------------");
            System.out.println("1. 도서 등록");
            System.out.println("2. 도서 검색");
            System.out.println("3. 도서 수정");
            System.out.println("4. 도서 삭제");
            System.out.println("5. 전체 출력");
            System.out.println("6. 종료");
            System.out.print("선택 > ");
            int menu;
            try {
                menu = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("숫자를 입력해주세요.");
                continue;
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
                    System.out.print("검색할 제목: ");
                    String stitle = sc.nextLine();
                    Book book = findBook(list, stitle);
                    if(book != null){
                        System.out.println(book);
                    }else{
                        System.out.println("도서가 없습니다.");
                    }
                    break;
                case 3:
                    // 도서 수정
                    System.out.print("수정할 제목: ");
                    title = sc.nextLine();
                    
                    System.out.print("새 저자 입력: ");
                    String newAuthor = sc.nextLine();
                    if(updateBook(list, title, newAuthor)){
                        System.out.println("수정 완료");
                    }else{
                        System.out.println("해당 도서가 없습니다.");
                    }
                    break;
                case 4:
                    // 도서 삭제
                    System.out.print("삭제할 제목: ");
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
                        for(Book b : list){
                            System.out.println(b);
                        }
                    }
                    break;
                case 6:
                    // 종료
                    run = false;
                    break;
            
                default:
                    System.out.println("번호를 다시 입력하세요.");
                    break;
            }
        }
    }

    private static boolean deleteBook(ArrayList<Book> list, String title) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).title.equals(title)){
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    private static boolean updateBook(ArrayList<Book> list, String title, String newAuthor) {
        for(Book b : list){
            if(b.title.equals(title)){
                b.author = newAuthor;
                return true;
            }
        }
        return false;
    }

    private static Book findBook(ArrayList<Book> list, String stitle) {
        for(Book b : list){
            if(b.title.equals(stitle)){
                return b;
            }
        }
        return null;
    }
}
