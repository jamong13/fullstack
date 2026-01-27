package a260127.bank_ex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccountManager {
    private ArrayList<Account> accounts;
    private String filename;

    public AccountManager(){
        this.accounts = new ArrayList<>();
        this.filename = "c:/Users/limeh/memo/account.txt";
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
        AccountManager manager = new AccountManager();

        while (true) {
            System.out.println("\n=== 은행 계좌 관리 시스템 ===");
            System.out.println("1. 계좌 생성");
            System.out.println("2. 입금");
            System.out.println("3. 출금");
            System.out.println("4. 계좌 조회");
            System.out.println("5. 전체 계좌 조회");
            System.out.println("6. 계좌 삭제");
            System.out.println("7. 파일 저장");
            System.out.println("8. 파일 불러오기");
            System.out.println("9. 종료");
            System.out.print("선택 > ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    // 계좌 생성
                    System.out.print("계좌번호 입력: ");
                    String accountNumber = sc.nextLine();
                    System.out.print("예금주명 입력: ");
                    String owerName = sc.nextLine();
                    System.out.print("초기 잔액 입력: ");
                    int balance = sc.nextInt();
                    sc.nextLine();
                    manager.addAccount(accountNumber, owerName, balance);
                    break;
                case 2:
                    // 입금
                    System.out.print("계좌번호 입력: ");
                    accountNumber = sc.nextLine();
                    System.out.print("입금할 금액 입력: ");
                    int deposit = sc.nextInt();
                    sc.nextLine();
                    manager.depositAccount(accountNumber, deposit);
                    break;
                case 3:
                    // 출금
                    System.out.print("계좌번호 입력: ");
                    accountNumber = sc.nextLine();
                    System.out.print("출금할 금액 입력: ");
                    int withdraw = sc.nextInt();
                    sc.nextLine();
                    manager.withdrawAccount(accountNumber, withdraw);
                    break;
                case 4:
                    // 계좌 조회
                    System.out.print("계좌번호 입력: ");
                    accountNumber = sc.nextLine();
                    Account account = manager.findAccount(accountNumber);
                    if(account != null){
                        System.out.println("=== 계좌 정보 ===");
                        System.out.println("계좌번호: " + accountNumber);
                        System.out.println("예금주명: " + account.getOwnerName());
                        System.out.println("잔액: " + account.getBalance());
                    }else{
                        System.out.println("계좌를 찾을 수 없습니다.");
                        break;
                    }
                    break;
                case 5:
                    // 전체 계좌 조회
                    manager.printAll();
                    break;
                case 6:
                    // 계좌 삭제
                    System.out.print("삭제할 계좌번호 입력: ");
                    String deleteAccountNumber= sc.nextLine();
                    manager.deleteAccount(deleteAccountNumber);
                    break;
                case 7:
                    // 파일 저장하기
                    manager.saveToFile();
                    break;
                case 8:
                    // 파일 불러오기
                    manager.loadToFile();
                    break;
                case 9:
                    // 종료
                    System.out.println("종료합니다.");
                    sc.close();
                    break;
            
                default:
                    System.out.println("잘못된 선택입니다.");
                    break;
            }
        }
    }

    // 8. 파일 불러오기
    private void loadToFile() {
        File file = new File(filename);
        if(!file.exists()){
            System.out.println("파일이 없습니다. 새로 시작합니다.");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if(!line.isEmpty()){
                    Account account = Account.fromFileString(line);
                    if(account != null){
                        accounts.add(account);
                    }
                }
            }
            System.out.println("파일 불러오기 완료!" + accounts.size() + "명");
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
    }

    // 6. 계좌 삭제
    private void deleteAccount(String deleteAccountNumber) {
        Account account = findAccount(deleteAccountNumber);
        if(account != null){
            accounts.remove(account);
            saveToFile();
        }else{
            System.out.println("계좌를 찾을 수 없습니다.");
        }
    }

    // 5. 전체 계좌 조회
    private void printAll() {
        if(accounts.isEmpty()){ 
        System.out.println("등록된 계좌가 없습니다.");
        return;
       }
       System.out.println("=== 전체 계좌 목록 ===");
       for(int i = 0; i < accounts.size(); i++){
        System.out.println((i + 1) + ". " + accounts.get(i));
       }
    }

    // 3. 출금
    private void withdrawAccount(String accountNumber, int withdraw) {
        Account account = findAccount(accountNumber);
        if(account != null){
            if(account.getBalance() >= withdraw){
                account.setBalance(account.getBalance() - withdraw);
                System.out.println("출금 완료! 현재 잔액: " + account.getBalance());
                saveToFile();
            }else{
                System.out.println("잔액이 부족합니다.");
            }
        }else{
            System.out.println("계좌를 찾을 수 없습니다.");
        }
    }

    // 7. 파일 저장하기
    private void saveToFile() {
        ensureDirectory();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(Account account : accounts){
                bw.write(account.toFileString());
                bw.newLine();//줄바꿈
            }
            System.out.println("파일 저장 완료: "+  filename);
        }catch (IOException e) {
           System.out.println("파일 저장 오류: "+  e.getMessage());
        }

    }


    // 2. 입금
    private void depositAccount(String accountNumber, int deposit) {
        Account account = findAccount(accountNumber);
        if(account != null){
            account.setBalance(account.getBalance() + deposit);
            System.out.println("입금 완료! 현재 잔액: " + account.getBalance());
            saveToFile();
        }else{
            System.out.println("계좌를 찾을 수 없습니다.");
        }
    }

    // 1. 계좌 생성
    private void addAccount(String accountNumber, String owerName, int balance) {
        Account account = findAccount(accountNumber);
        if(account == null){
            accounts.add(new Account(accountNumber, owerName, balance));
            System.out.println("계좌 생성이 완료되었습니다.");
            saveToFile();
        }else{
            System.out.println("이미 존재하는 계좌번호입니다.");
        }
    }

    // 4. 계좌 조회
    private Account findAccount(String accountNumber) {
        for(Account account : accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                return account;
            }
        }
        return null;
    }

}
