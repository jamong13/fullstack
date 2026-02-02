package a260202.book_ex;

import java.util.Map;

public class Member {
    private int memberAccount;
    private int money;
    private Map<String, Integer> rentalBook;

    
    public Member(int memberAccount) {
        this.memberAccount = memberAccount;
        this.money = 30000;
    }


    public Member(int memberAccount, int money) {
        this.memberAccount = memberAccount;
        this.money = money;
    }


    public int getmemberAccount() {
        return memberAccount;
    }


    public void setmemberAccount(int memberAccount) {
        this.memberAccount = memberAccount;
    }


    public int getMoney() {
        return money;
    }


    public void setMoney(int money) {
        this.money = money;
    }


    public Map<String, Integer> getRentalBook() {
        return rentalBook;
    }


    public void setRentalBook(Map<String, Integer> rentalBook) {
        this.rentalBook = rentalBook;
    }

    public String getAccont(){
        return "회원" + memberAccount;
    }
    
}
