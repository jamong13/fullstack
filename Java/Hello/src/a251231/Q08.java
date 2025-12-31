package a251231;

public class Q08 {
    public static void main(String[] args) {
        // 아이디가 "admin"이고 비밀번호가 "1234"인 경우에만 로그인 성공
        // "로그인 성공" 또는 "로그인 실패" 출력

        String userID = "admin";
        String userPW = "1234";

        if(userID.equals("admin") && userPW.equals("1234")){
            System.out.println("로그인 성공");
        }else{
            System.out.println("로그인 실패");
        }
    }
}
