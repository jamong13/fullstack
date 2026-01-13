package a260113.book;

public class Book {
    private String title; // 책 제목
    private String author; // 책 저자
    private String ISBM; // 책 번호

    public Book(String title, String author, String iSBM) {
        this.title = title;
        this.author = author;
        ISBM = iSBM;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getISBM() {
        return ISBM;
    }
    public void setISBM(String iSBM) {
        ISBM = iSBM;
    }

    // 도서정보 출력 메서드
    public void displayInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBM:` " + ISBM);
    }
}
