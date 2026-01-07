package a260107;

public class Pork {
    public static void main(String[] args) {
        int per = 3;
        double kcal = calc(per);
        System.out.printf("삼겹살 %d인분의 칼로리: %.2f kcal", per, kcal);
    }

    private static double calc(int per) {
        int totalGram = per * 180; //1인분 당 180
        double totalKcal = totalGram * 5.179;
        return totalKcal;
    }
}
