package a260120.string1;

public class IndexOf1 {
    public static void main(String[] args) {
        String str = new String("Oracle Java");
        System.out.println("원본 문자열 : " + str);
        
        System.out.println(str.indexOf('o')); // o가 포함되어 있지 않으면 -1
        System.out.println(str.indexOf('a')); // a가 포함되어 있으면 인덱스 번호 2 출력
        System.out.println(str.indexOf("Java")); // Java는 첫글자 기준 인덱스 번호 7 출력
        System.out.println("indexOf() 메소드 호출 후 원본 문자열 : " + str);
    }
}
