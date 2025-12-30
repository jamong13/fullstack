package a251230;

public class Ex02 {
    public static void main(String[] args) {
        System.out.println("\n--- 복합 연산 예제 ---");
        int score1 = 85;
        int score2 = 90;
        int score3 = 78;

        // 1. 각 점수를 인쇄하시오.
        System.out.println("점수: " + score1 + "," + score2 + "," + score3);

        // 2. 총점과 평균을 구해서 인쇄하시오.
        int sum = score1 + score2 + score3;
        double avg = (double) sum /3;
        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);
        // 3. 평균 60점 이상이면 합격(true)
        boolean isPass = avg >= 60;
        System.out.println("합격 여부(>=60): " + isPass);
        // if(avg >= 60){
        //     System.out.println("합격입니다.");
        // }else{
        //     System.out.println("불합격입니다.");
        // }
        // 4. 평균 90 이상이면 우수(true)
        boolean isExcellent = avg >= 90;
        System.out.println("우수 여부(>=90): " + isExcellent);
        // if(avg >= 90){
        //     System.out.println("우수한 성적입니다.");
        // }
    }
}
