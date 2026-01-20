package a260120.ex03;

public class StringUtil {

    // public 어디서나 호출 가능
    // static 객체 생성 없이 StringUtil.countWords() 사용 가능
    // int 단어의 개수
    // String text1 검사(단어의 개수를 세어)할 문자열
    
    public static int countWords(String text1) {
        // 기초버전 : 2점
        // String[] words = text1.split(" "); // 공란을 기준으로 배열을 나눈다.
        // System.out.println(words[0]); // 안녕하세요
        // System.out.println(words[1]); // 자바입니다
        // return words.length;

        if(text1 == null || text1.trim().isEmpty()){
            return 0;
        }
        String[] words = text1.trim().split("\\s+"); // 공백 문자 s+ -> 공백 한개 이상
        return words.length;
    }

    public static String reverseString(String text2) {
        if(text2 == null) return null;

        // 기초버전 - 2점
        // String result = "";
        // for(int i = text2.length() - 1; i >= 0; i--){
        //     result += text2.charAt(i);
        // }
        // 스트링 불변객체
        // 기존 문자열 - 새로운 문자열 생성 - 새 문자열에 값 복사
        // 반복문 안에서 계속 발생 = 성능 매우 나쁨
        // return result;

        // 가장 좋은 방법이나 이번 시험에서는 점수 X
        // if (text2 == null) return null;
        // return new StringBuilder(text2).reverse().toString();
        
        StringBuilder sb = new StringBuilder();
        for (int i = text2.length() - 1; i >= 0; i--) {
            sb.append(text2.charAt(i)); // sb 하나로 관리, append 추가
        }
        return sb.toString();
    }

    public static int findMax(int[] arr) {
        if(arr == null || arr.length == 0) {
            return -1;
        }
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;

    }

    public static boolean contains(int[] arr, int value) {
        if(arr == null){
            return false;
        }
        for(int num : arr){
            if(num == value){
                return true;
            }
        }
        return false;
    }
    
}
