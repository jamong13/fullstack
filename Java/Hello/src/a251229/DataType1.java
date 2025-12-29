package a251229;

public class DataType1 {
    public static void main(String[] args) {
        // 정수형
        int age = 25;
        age = 26;
        long population = 7800000000L;

        // 실수형
        double height = 175.5;
        float weight = 70.5F;

        // 문자형
        char grade = 'A';

        // 논리형
        boolean isStudent = true;

        // 참조 자료형(String)
        String name = "홍길동";

        // 상수
        final double PI = 3.14159;
        final int MAX_SCORE = 100;
        // PI = 3.14; // 오류: 상수는 값을 변경할 수 없음

        // 출력
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("키: " + height + "cm");
        System.out.println("학생 여부: " + isStudent);
        System.out.println("원주율: " + PI);
    }
}
