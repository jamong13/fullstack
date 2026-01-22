package a260122.ex04;

public class StringUtil {

    public static int countChar(String string, char c) {
        int count = 0;
        String n = string.toLowerCase();
        for(int i = 0; i < n.length(); i++){
            char ch = n.charAt(i);
            if(ch == c){
                count++;
            }
        }

        return count;
    }

    public static String reverseString(String string) {
        StringBuilder sb = new StringBuilder();
        for(int i = string.length()-1; i >=0; i--){
            char ch = string.charAt(i);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static String toUpperCase(String string) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            char ch = string.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                sb.append((char)(ch - 32)); 
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String removeSpaces(String string) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < string.length(); i++){
            char ch = string.charAt(i);
            if(ch != ' '){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    
}
