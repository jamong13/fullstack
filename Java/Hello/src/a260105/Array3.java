package a260105;

public class Array3 {
    public static void main(String[] args) {
        // 문제
        int[] arr = {5, 8, 3, 10, 2};
        int max = arr[0];
        // 배열에 들어있는 5개 수중에 가장 큰 수를 출력해보세요.
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        System.out.println("가장 큰 수: " + max);
    }
}
