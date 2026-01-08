package a260108.member;

public class Main {
    public static void main(String[] args) {
        // 회원가입 객체 생성
        Member m1 = new Member("hong123", "12341", "홍길동");
        Member m2 = new Member("kim123", "12341", "김기민");
        Member m3 = new Member("her123", "12341", "허준석");
        
        System.out.println("=== 회원가입 완료 ===");
        m1.showInfo();
        m2.showInfo();
        m3.showInfo();
    }
}
