package a260202.book_ex;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Book {
    private static Book instance;
    private Book(){};

    public static Book getInstance(){
        if(instance == null){
            instance = new Book();
        }
        return instance;
    };
    ArrayList<String> bookList;
    ArrayList<Integer> rentalPrice;
    Map<String, Integer> books;

    public void getList(){
        books = new LinkedHashMap<String, Integer>();
        bookList = new ArrayList<>();
        rentalPrice = new ArrayList<>();

        bookList.add("자바의 정석");
        bookList.add("이것이 자바다");
        bookList.add("Do it! 자바 프로그래밍");
        bookList.add("Head First Java");
        bookList.add("Effective Java");
        bookList.add("Clean Code");

        rentalPrice.add(1000);
        rentalPrice.add(1200);
        rentalPrice.add(1000);
        rentalPrice.add(1500);
        rentalPrice.add(1800);
        rentalPrice.add(1300);

        for(int i = 0; i < bookList.size(); i++){
            books.put(bookList.get(i), rentalPrice.get(i));
        }

        DecimalFormat f = new DecimalFormat("0,000원");
        StringBuffer st = new StringBuffer();
        st.append("\n\n")
            .append("+---------------------------------------------------+\n")
            .append("+------------------------도서목록---------------------+\n")
            .append("|            Book                   price           |\n");
        System.out.println(st.toString());

        int s = 1;
        for(Entry<String, Integer> get : books.entrySet()){
            System.out.printf(": [%d] %-20s\t %s          :\n"
            ,s,get.getKey(),f.format(get.getValue()));
            s++;
        }
        System.out.println("+----------------------------------------------------+\n");
    }

}
