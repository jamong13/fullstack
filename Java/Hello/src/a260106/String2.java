package a260106;

public class String2 {
    public static void main(String[] args) {
        String firstName = "홍";
        String lastName = "길동";
        String fullName = firstName + " " + lastName;
        System.out.println(fullName);

        // += 연산자
        String message = "Hello";
        message += " World"; // Hello world
        System.out.println(message);

        // concat() 메서드
        String str = "Hello";
        str = str.concat(" World");
        System.out.println(str);

        // 길이와 빈 문자열 확인
        String str1 = "Hello";
        // length
        int len = str.length();
        System.out.println("문자열 길이: " + len);
        // isEmpty() : 빈 문자열인지 확인
        boolean empty = str1.isEmpty(); // false
        String emptyStr = "";
        boolean isEmp = emptyStr.isEmpty(); // true
        System.out.println("비어있니? " + isEmp);

    }
}
