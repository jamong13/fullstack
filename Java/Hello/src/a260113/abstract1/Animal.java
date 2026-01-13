package a260113.abstract1;

// 추상 클래스
// 미완성 설계도
// 객체 생성이 불가
// 상속해서 완성해야 사용 가능
// 일반 메서드 + 추상 메서드 둘 다 가질 수 있음
abstract class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }
    // 추상 메서드 - 몸체가 없는 메서드
    // 선언만 있고 구현 없음
    // 자식 클래스에서 오버라이딩 해야 함 - 책의 차례와 비슷
    abstract void makeSound();
    abstract void eat();
}
