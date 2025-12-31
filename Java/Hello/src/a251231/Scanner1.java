package a251231;

import java.util.Scanner;
// 1. Import : 외부클래스인 Scanner 불러 옵니다.

public class Scanner1 {
    public static void main(String[] args) {
        
        // 2. Scanner 객체를 생성, System.in은 키보드 입력
        Scanner sc = new Scanner(System.in);
        System.out.print("년도를 입력하세요.: ");
        int year = sc.nextInt();

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            System.out.println(year + "년은 윤년입니다.");
        }else{
            System.out.println(year + "년은 윤년이 아닙니다.");
        }
    }
}
