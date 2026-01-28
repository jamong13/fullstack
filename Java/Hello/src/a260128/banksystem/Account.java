package a260128.banksystem;

public class Account {
    private String acccountNumber; // 계좌번호
    private String ownerName; // 예금주명
    private int balance; // 잔액
    public Account(String acccountNumber, String ownerName, int balance) {
        this.acccountNumber = acccountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // 파일 저장용 문자열
    public String toFileString(){
        return acccountNumber + "|" + ownerName + "|" + balance;
    }
    // 123-456|홍길동|10000

    public String getAcccountNumber() {
        return acccountNumber;
    }

    public void setAcccountNumber(String acccountNumber) {
        this.acccountNumber = acccountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "계좌번호: " + acccountNumber + ", 예금주명: " + ownerName + ", 잔액: " + balance + "원";
    }

    public void deposit(int depositAmount) {
        this.balance += depositAmount;
    }

    public boolean withdraw(int amount) {
        if(balance >= amount){
            this.balance -= amount;
            return true;
        }else{
            return false;
        }
    }

    public static Account fromFileString(String line) {
        try {
            String[] parts = line.split("\\|");
            if(parts.length == 3){
                String accountNumber = parts[0].trim();
                String ownerName = parts[1].trim();
                int balance = Integer.parseInt(parts[2].trim());
                return new Account(accountNumber, ownerName, balance);
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return null;
    }

    
}
