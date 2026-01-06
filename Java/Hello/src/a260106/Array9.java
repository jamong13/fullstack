package a260106;

public class Array9 {
    public static void main(String[] args) {
        int[][] scores = {
            {90, 80, 80},
            {85, 95, 88}
        };
        for(int i =0; i < scores.length; i++){
            int sum = 0; // 행마다 새로 0으로 초기화
            for(int j = 0; j < scores[i].length; j++){
                sum += scores[i][j];
            }
            System.out.println("점수 합: " + sum);
        }
    }
}
