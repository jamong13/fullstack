package a260105;

public class Array2 {
    public static void main(String[] args) {
        // 배열 {10, 20, 30, 40, 50}의 모든 값의 합계를 구하시오.

        int[] arr = {10, 20, 30, 40, 50};
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        System.out.println("arr의 합계: " + sum);
    }
}
