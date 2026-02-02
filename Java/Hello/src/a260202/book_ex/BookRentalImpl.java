package a260202.book_ex;


public class BookRentalImpl {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        bookService.start();
    }
}
