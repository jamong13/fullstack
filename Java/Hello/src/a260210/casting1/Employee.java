package a260210.casting1;

// 직원 관리 시스템(부모, 추상클래스)
abstract class Employee {
    
    // abstract ?
    // 직원마다 급여 계산 방식 다르기 때문
    // 부모는 규칙만 정함
    // 추상 메서드는 자식에서 반드시 구현
    protected String name;
    protected int id;
    protected double baseSalary;

    // 추상 메서드 - 각 직원 타입 마다 다른 계산 방식
    abstract double calculateSalary();

    public Employee( String name, int id,double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // 공통 메서드
    void printInfo() {
        System.out.println("ID: " + id + ", 이름: " + name + 
                          ", 기본급: " + baseSalary + 
                          ", 실급여: " + calculateSalary());
    }
}
