package a260102;

public class Ex01 {
    public static void main(String[] args) {
        // 1부터 100까지 5의 배수의 합계 출력

        int sum = 0;
        for(int i = 1; i <= 100; i++){
            if(i % 5 ==0){
                sum += i;
            }
        }
        System.out.println("5의 배수의 합계는 " + sum);
    }
}
