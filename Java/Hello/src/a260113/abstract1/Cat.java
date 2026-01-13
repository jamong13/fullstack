package a260113.abstract1;

public class Cat extends Animal{

    public Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + "이(가) 야옹 웁니다.");
    }

    @Override
    void eat() {
        System.out.println(name + "이(가) 먹습니다.");
        
    }
    
}
