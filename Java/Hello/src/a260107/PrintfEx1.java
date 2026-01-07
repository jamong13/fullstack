package a260107;

public class PrintfEx1 {
    public static void main(String[] args) {
        int age = 20;
        String female = "여성";
        System.out.println("당신의 나이는 " + age + "이고, 성별은 " + female + "입니다.");
        System.out.printf("당신의 나이는 %d이고, 성별은 %s입니다. \n", age, female);
        // %d 정수형(age)
        // %s 문자열(female)
        // \n 줄바꿈
    }
}
