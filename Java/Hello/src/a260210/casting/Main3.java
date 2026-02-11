package a260210.casting;

public class Main3 {
    public static void main(String[] args) {
        Parent1 p = new Child1();
        p.method();
        // 부모 -> 자식 순서
        // Parent1 생성자
        // Childe1 생성자
        // 메서드 객체 기준
    }
}
class Parent1 {
    Parent1(){
        System.out.println("Parent1 생성자");
    }
    void method(){
        System.out.println("Parent1 Method");
    }
}
class Child1 extends Parent1{
    Child1(){
        System.out.println("Child1 생성자");
    }
    void method(){
        System.out.println("Child1 Method");
    }
    // 오버라이딩된 메서드 실제 객체(Child) 기준으로 결정
}

// 한 줄 암기
// 부모 타입 = 자식 객체 ○
// 자식 타입 = 부모 객체 X
// 메서드 실행 = 실제 객체 기준
// Parent p = new Child();   // 업캐스팅 (자동)
// Child c = (Child)p;      // 다운캐스팅 (명시)
