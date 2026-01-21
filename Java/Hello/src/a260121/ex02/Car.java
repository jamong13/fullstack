package a260121.ex02;

public class Car {
    String brand; // 자동차 브랜드
    String model; // 자동차 모델
    int year; // 제조년도
    public Car() {
    }
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    @Override
    public String toString() {
        return "브랜드: " + brand + ", 모델: " + model + ", 제조년도: " + year + "]";
    }
    public int getAge(int currentYear) {
        return currentYear - year;
    }

    
}
