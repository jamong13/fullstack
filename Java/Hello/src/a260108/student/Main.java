package a260108.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[3];
        for(int i = 0; i < students.length; i++){
            System.out.println("=== 학생 점수 입력 " + (i + 1) + "번 ===");
            System.out.print("이름: ");
            String name = sc.nextLine();
            System.out.print("국어 점수: ");
            int kor = sc.nextInt();
            System.out.print("영어 점수: ");
            int eng = sc.nextInt();
            System.out.print("수학 점수: ");
            int math = sc.nextInt();
            sc.nextLine(); // 숫자 입력 끝나고 엔터 제거용
            students[i] = new Student(name, kor, eng, math);

            // 또는
            // int eng = Integer.parseInt(sc.nextLine());
        }
        System.out.println("=== 학생 정보 출력 ===");
        for(int i = 0; i < students.length; i++){
            students[i].showInfo();
        }
        sc.close();
    }
}
