package a260128.book_ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManager {
    private ArrayList<Book> books;
    private String filename;
    private int idCount = 0;

    public BookManager(){
        this.books = new ArrayList<>();
        this.filename = "c:/Users/limeh/memo/book.txt";
    }

    //출력 디렉토리(폴더) 확인 및 생성
    private void ensureDirectory(){
        File file = new File(filename);
        File parentDir = file.getParentFile();
        if(parentDir != null && !parentDir.exists()){
            parentDir.mkdir();
            System.out.println("디렉토리가 생성되었습니다." + parentDir.getPath());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookManager manager = new BookManager();
        
        while (true) {
            System.out.println("\n=== 도서 관리 시스템 ===");
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 삭제");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 수정");
            System.out.println("5. 도서 목록 보기");
            System.out.println("6. 파일로 저장");
            System.out.println("7. 파일에서 불러오기");
            System.out.println("0. 종료");
            System.out.print("선택 > ");
            
            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // 버퍼 비우기
            } catch (Exception e) {
                System.out.println("숫자만 입력하세요.");
                sc.nextLine(); // 잘못된 입력 제거
                continue;
            }

            switch (choice) {
                case 1:
                    // 도서 추가
                    System.out.println("도서 추가");
                    System.out.print("책 제목: ");
                    String title = sc.nextLine();
                    System.out.print("저자: ");
                    String author = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    try {
                        System.out.print("가격: ");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        manager.addBook(title, author, isbn, price);
                    } catch (Exception e) {
                        System.out.println("가격은 숫자만 입력하세요");
                        sc.nextLine();
                    }
                    break;
                
                case 2:
                    // 도서 삭제
                    System.out.println("도서 삭제");
                    System.out.print("책 이름을 입력: ");
                    String deleteTitle = sc.nextLine();
                    manager.deleteBook(deleteTitle);
                    break;
                
                case 3:
                    // 도서 검색
                    System.out.println("도서 검색");
                    System.out.print("책 이름을 입력: ");
                    String searchBook = sc.nextLine();
                    manager.findBook(searchBook);
                    break;
                
                case 4:
                    // 도서 수정
                    System.out.println("도서 수정");
                    System.out.print("책 이름을 입력: ");
                    title = sc.nextLine();
                    System.out.print("책 제목: ");
                    String updateTitle = sc.nextLine();
                    System.out.print("저자: ");
                    String updateAuthor = sc.nextLine();
                    System.out.print("isbn: ");
                    String updateIsbn = sc.nextLine();
                    System.out.print("가격: ");
                    try {
                        double updatePrice = sc.nextDouble();
                        sc.nextLine();
                        manager.updateBook(title, updateTitle, updateAuthor, updateIsbn, updatePrice);
                    } catch (Exception e) {
                        System.out.println("가격은 숫자로 입력하세요.");
                        sc.nextLine();
                    }
                    break;
                
                case 5:
                    // 도서 목록 보기
                    manager.printAll();
                    break;
                
                case 6:
                    // 파일로 저장
                    manager.saveToFile();
                    break;
                
                case 7:
                    // 파일에서 불러오기
                    manager.loadFromFile();
                    break;
                
                case 0:
                    // 종료
                    System.out.println("종료합니다.");
                    sc.close();
                    break;
                
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        } 
    }


    // 도서 존재 여부
    private Book findBookByTitle(String title){
        for(Book book : books){
            if(book.getTitle().equals(title)){
                return book;
            }
        }
        return null;
    }
    // 1. 도서 추가
    private void addBook(String title, String author, String isbn, double price) {
        if(findBookByTitle(title) != null){
            System.out.println("이미 존재하는 책입니다.");
            return;
        }
        Book book = new Book(title, author, isbn, price);
        book.setId(idCount++);
        books.add(book);
        saveToFile();
        System.out.println("도서가 추가되었습니다.");
    }
    // 2. 도서 삭제
    private void deleteBook(String deleteTitle) {
        Book book = findBookByTitle(deleteTitle);
        if(book != null){
            books.remove(book);
            saveToFile();
            System.out.println(deleteTitle + "를 제거하였습니다.");
        }else{
            System.out.println("찾는 도서가 없습니다.");
        }
    }
    // 3. 도서 검색
    private void findBook(String searchBook) {
        Book book = findBookByTitle(searchBook);
        if(book !=null){
            System.out.println(book);
        }else{
            System.out.println("계좌를 찾을 수 없습니다.");
        }
    }
    // 4. 도서 수정
    private void updateBook(String title, String updateTitle, String updateAuthor, String updateIsbn, double updatePrice) {
        Book book = findBookByTitle(title);
        if(book != null){
            book.setTitle(updateTitle);
            book.setAuthor(updateAuthor);
            book.setIsbn(updateIsbn);
            book.setPrice(updatePrice);
            saveToFile();
            System.out.println("도서 정보가 수정되었습니다.");
        }else{
            System.out.println("찾는 도서가 없습니다.");
        }
    }
    // 5. 도서 전체 출력
    private void printAll() {
        if(books.isEmpty()){
            System.out.println("등록된 도서가 없습니다.");
            return;
        }
        for(int i = 0; i < books.size(); i++){
            System.out.println(books.get(i));
        }
    }
    // 6. 파일에 저장
    private void saveToFile() {
        ensureDirectory();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(Book book : books){
                bw.write(book.toFileString());
                bw.newLine();//줄바꿈
            }
            System.out.println("파일 저장 완료: "+  filename);
        }catch (IOException e) {
           System.out.println("파일 저장 오류: "+  e.getMessage());
        }
    }
    // 7. 파일로부터 불러오기
    private void loadFromFile() {
        File file = new File(filename);
        if(!file.exists()){
            System.out.println("파일이 없습니다. 새로 시작합니다.");
            return;
        }
        books.clear(); 
        int maxId = -1;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if(!line.isEmpty()){
                    Book book = Book.fromFileString(line);
                    if(book != null){
                        books.add(book);
                        if (book.getId() > maxId) {
                            maxId = book.getId();
                        }
                    }
                }
            }
            idCount = maxId + 1;
            System.out.println("파일 불러오기 완료!" + books.size() + "권");
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }

}
