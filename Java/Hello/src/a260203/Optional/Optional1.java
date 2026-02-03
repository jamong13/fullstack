package a260203.Optional;

import java.util.Optional;

import javax.management.RuntimeErrorException;

public class Optional1 {
    public static void main(String[] args) {
        MemberService service = new MemberService();
        // Optional<String> name = service.findNameById(2); // 없는 회원
        // System.out.println(name.length()); null 에러
        // 전통방식
        // if(name != null){
        //     System.out.println(name.length());
        // }else{
        //     System.out.println("회원이 존재하지 않습니다.");
        // }
        // 1번 name.ifPresent(n -> System.out.println(n.length()));
        // 2번
        // 3번 예외를 직접 던지고 싶을 때

        String name = service.findNameById(2)
            .orElseThrow(() -> new RuntimeException("회원이 없습니다."));
        System.out.println(name.length());
        System.out.println("프로그램 정상 종료");
    }
}
class MemberService{
    public Optional<String> findNameById(int id){
        if(id == 1){
            return Optional.of("홍길동");
        }
        return Optional.empty();
    }
}
