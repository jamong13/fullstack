package a251229;

public class Int1 {
    public static void main(String[] args) {
        int var1 = 10;
        System.out.println(var1);
        // int 2var = 20; 숫자로 시작하면 안됨
        int _var2 = 20;
        int $var3 = 30;
        System.out.println(_var2);
        System.out.println($var3);
        // int #var4 = 40; 특수문자 _ , $ 외에는 안됨
        // int var5 = 1000000000000; // int 범위 초과
        long var6 = 1000000000000L; // long 접미사 L or l
        System.out.println(var6);

        double doubleVar = 3.14159265358979323846; // double 접미사 생략 가능
        float floatVar = 3.14F; // float 접미사 F or f
        System.out.println(doubleVar);
        System.out.println(floatVar);

        byte byteVar = 127; // -128 ~ 127
        System.out.println(byteVar);

        short shortVar = 32767; // -32768 ~ 32767
        System.out.println(shortVar);

        // 문자형
        char charVar = 'A';
        System.out.println(charVar);
        char koreanChar = '가';
        System.out.println(koreanChar);
        char unicodeChar = '\u0041'; // 유니코드로 A 표현
        System.out.println(unicodeChar);

        // 논리형
        boolean isTrue = true;
        boolean isFalse = false;
        System.out.println(isTrue);
        System.out.println(isFalse);
        boolean result = (5 > 3);
        System.out.println(result);
    }
}
