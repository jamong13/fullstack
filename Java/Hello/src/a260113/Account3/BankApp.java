package a260113.Account3;

import java.util.Scanner;

public class BankApp {
    // Account acc = new Account("123-123", "이순신", 10000);
    // 객체를 하나만 만든다.

    // Account 객체를 100개 관리하고 싶다.
    private static Account[] accountsArray = new Account[100];
    // Account 객체 100을 관리하는 배열을 만든다.

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("1. 계좌생성 | 2. 계좌목록 | 3. 예금 | 4. 출금 | 5. 계좌이체 | 6. 종료");
            System.out.println("------------------------------------------------------------------");
            System.out.print("선택> ");
            int selNum = 0;
            try{
                selNum = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){

            }
            // a라고 문자를 입력해도
            // 예외 처리 = 에러 발생해도 프로그램 계쏙 실행 - while

            switch (selNum) {
                case 1:
                    createAccount();
                    break;
                
                case 2:
                    accountList();
                    break;

                case 3:
                    deposit();
                    break;

                case 4:
                    withdraw();
                    break;
                    
                case 5:
                    transfer();
                    break;
                    
                case 6:
                    System.out.println("프로그램 종료");
                    run = false;
                    break;

                default:
                    break;
            }
        }
    }
    private static void createAccount() { // 계좌 생성
        System.out.println("---------------------");
        System.out.println("계좌생성");
        System.out.println("---------------------");
        System.out.print("계좌 입력: ");
        String ano = scanner.nextLine();
        if(findAccount(ano) != null){
            System.out.println("이미 존재하는 계좌번호입니다.");
            return;
        }
        System.out.print("계좌주: ");
        String owner = scanner.nextLine();
        System.out.print("초기입금액: ");
        int balance = 0; // 잔액 0으로 초기화
        try {
            balance = Integer.parseInt(scanner.nextLine());
            if(balance < 0){
                System.out.println("초기입금액은 0원 이상이어야 합니다.");
            }
            Account newAccount = new Account(ano, owner, balance);
            for(int i = 0; i < accountsArray.length; i++){
                if(accountsArray[i] == null){
                    accountsArray[i] = newAccount;
                    System.out.println("결과: 계좌가 생성되었습니다.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력하세요.");
        }
    }
    private static Account findAccount(String ano) {
        Account account = null;
        // 반환될 값 초기화
        for(int k = 0; k < accountsArray.length; k++){
            if(accountsArray[k] != null){
                String dbAno = accountsArray[k].getAno();
                if(dbAno.equals(ano)){
                    account = accountsArray[k];
                    break;
                }
            }
        }
        return account;
    }
    private static void accountList() { // 2. 계좌목록
        System.out.println("---------------------");
        System.out.println("계좌목록");
        System.out.println("---------------------");
        for(int j = 0; j < accountsArray.length; j++){
            if(accountsArray[j] != null){
                System.out.printf("%s %4s %d\n", accountsArray[j].getAno(), accountsArray[j].getOwner(), accountsArray[j].getBalance());
            }
        }
    }
    private static void deposit() { // 3. 예금
        System.out.println("-----------");
        System.out.println("예금");
        System.out.println("-----------");
        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();
        Account account = findAccount(ano);
        if(account == null){
            System.out.println("결과 : 계좌가 없습니다.");
            return;
        }
        System.out.print("예금액: ");
        try {
            int money = Integer.parseInt(scanner.nextLine());
            if(money <= 0){
                System.out.println("예금액은 1원 이상이어야 합니다.");
                return;
            }
            account.setBalance(account.getBalance() + money);
        } catch (NumberFormatException e) {
            // 숫자 에러(문자가 들어왔을 때)일 때 예외
            System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
        }
        
    }
    private static void withdraw() { // 4. 출금
        System.out.println("-----------");
        System.out.println("출금");
        System.out.println("-----------");
        System.out.print("계좌번호: ");
        String ano = scanner.nextLine();
        Account account = findAccount(ano);
        if(account == null){
            System.out.println("결과 : 계좌가 없습니다.");
            return;
        }
        System.out.print("출금액: ");
        try {
            int money = Integer.parseInt(scanner.nextLine());
            if(money <= 0){
                System.out.println("출금액은 1원 이상이어야 합니다.");
                return;
            }
            if(account.getBalance() <= money){
                // 잔액보다 찾는 금액이 많으면 잔액 부족
                System.out.println("잔액 부족입니다.");
                return;
            }
            account.setBalance(account.getBalance() - money);
            System.out.println("결과 : 출금 완료. 현재 잔액 : " + account.getBalance() + "원");
        } catch (NumberFormatException e) {
            // 숫자 에러(문자가 들어왔을 때)일 때 예외
            System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
        }
    }
    private static void transfer() { // 5. 계좌 이체
        System.out.println("-----------");
        System.out.println("계좌 이체");
        System.out.println("-----------");
        System.out.print("출금 계좌번호: ");
        String ano = scanner.nextLine();
        System.out.print("입금 계좌번호: ");
        String send = scanner.nextLine();

        Account account = findAccount(ano);
        Account sendAccount = findAccount(send);
        if(account == null || sendAccount == null){
            System.out.println("결과 : 계좌가 없습니다.");
            return;
        }
        System.out.println("이체 금액: ");
        int money = 0;
        try {
            money = Integer.parseInt(scanner.nextLine());
            if(money <= 0){
                System.out.println("이체 금액은 1원 이상이어야 합니다.");
                return;
            }
            if(account.getBalance() <= money){
                // 잔액보다 찾는 금액이 많으면 잔액 부족
                System.out.println("잔액 부족입니다.");
                return;
            }
            account.setBalance(account.getBalance() - money); // 보낸 사람 객체에서 잔액 - 이체 금액
            sendAccount.setBalance(sendAccount.getBalance() + money); // 받는 사람 객체에서 잔액 + 이체 금액
            System.out.println("결과 : 이체 완료. 현재 잔액 : " + account.getBalance() + "원");
        } catch (NumberFormatException e) {
            // 숫자 에러(문자가 들어왔을 때)일 때 예외
            System.out.println("잘못된 입력입니다. 숫자를 입력해 주세요.");
        }
    }
}
