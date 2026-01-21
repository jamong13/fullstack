package a260121.ex04;

public class StringUtil {
    
    // 모음 개수 세기
    public static int countVowels(String text) {
        int count = 0;
        String lowerText = text.toLowerCase(); // 매개변수 text를 소문자 변환
        for(int i = 0; i < lowerText.length(); i++){
            char ch = lowerText.charAt(i); // charAt(0) 첫 글자 charAt(1) 두번째 글자
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                count++;
            }
        }
        return count;
    }

    // 대문자 변환
    public static String toUpperCase(String text) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(ch >= 'a' && ch <= 'z'){ // 소문자이면
                sb.append((char)ch - 32); // 대문자로 변환(ASC 코드 차이 : 32)
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static boolean containsWord(String text, String word) {
        if(text == null || word == null){
            return false;
        }
        return text.contains(word); // contains 단어 포함 여부
    }

    public static String replaceChar(String text, char oldChar, char newChar) {
        if(text == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            char ch = text.charAt(i);
            if(ch == oldChar){ 
                sb.append(newChar); 
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }


}
