package a251231;

import java.util.Scanner; // 1. Import 문장

public class Scanner2 {
    public static void main(String[] args) {
        // 2. Scanner 객체 생성 sc (System.in) - 키보드 입력
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요: ");
        String name = sc.next(); // 문자열 입력(한 단어)
        // 한 줄 전체입력 (공백 포함) sc.nextLine();
        // char ch = sc.next().charAt(); -> 문자 1개 입력 받기

        System.out.print("나이를 입력하세요: ");
        int age = sc.nextInt();
        // double avg = sc.nextDouble(); -> 실수 입력

        System.out.println(name + "님의 나이는 " + age + "세 입니다.");

        // 3. 사용이 끝난 후에는 닫아주는 것이 좋습니다.
        sc.close();
    }
}
