package a260102;

public class Ex02 {
    public static void main(String[] args) {
        // 1부터 100까지의 수 중 짝수와 홀수의 값을 각각 구하시오.
        
        int everSum = 0;
        int oddSum = 0;

        // for문을 이용하여 반복 합계 연산
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0){
                everSum += i;
            }else{
                oddSum += i;
            }
        }
        System.out.println("짝수의 합계는 " + everSum);
        System.out.println("홀수의 합계는 " + oddSum);
    }
}
