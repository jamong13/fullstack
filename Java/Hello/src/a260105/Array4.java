package a260105;

import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        // 사용자로부터 정수 3개를 입력받아 출력하시오
        // for문 이용
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            // System.out.println(arr[i]);
            // 역순으로 출력하려면
        }
        for(int i = arr.length-1; i >= 0; i--){
            System.out.println(arr[i]);
        }

    }
}
