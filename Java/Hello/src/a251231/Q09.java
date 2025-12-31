package a251231;

import java.util.Scanner;

public class Q09 {
    public static void main(String[] args) {
        // - 18세 이상이면서 면허를 보유한 경우: "운전 가능합니다"
        // - 18세 이상이지만 면허가 없는 경우: "면허가 필요합니다"
        // - 18세 미만인 경우: "미성년자는 운전할 수 없습니다"
        System.out.print("나이를 입력하세요: ");
        Scanner ageSc = new Scanner(System.in);
        int age = ageSc.nextInt();
        boolean hasLicense = true;
        if(age >= 18){
            if(hasLicense == true){
                System.out.println("운전 가능합니다.");
            }else{
                System.out.println("면허가 필요합니다.");
            }
        }else{
            System.out.println("미성년자는 운전할 수 없습니다.");
        }

        ageSc.close();
    }
}
