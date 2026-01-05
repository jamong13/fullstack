package a260105;

public class Array5 {
    public static void main(String[] args) {
        // 배열 {70, 85, 90, 66, 75}
        // 평균을 구하고, 평균 점수 이상인 점수만 구하시오.
        int[] score = {70, 85, 90, 66, 75};
        int sum = 0;

        for(int i = 0; i < score.length; i++){
            sum += score[i];
        }
        System.out.println(sum);
        double avg = (double) sum / score.length;
        // 계산을 실수로 하려면 (double) 형 변환, 캐스팅
        System.out.println(avg);
        for(int i = 0; i < score.length; i++){
            if(avg <= score[i]){
                System.out.println("평균보다 큰 값 " + i + " " + score[i]);
            }
        }
    }
}
