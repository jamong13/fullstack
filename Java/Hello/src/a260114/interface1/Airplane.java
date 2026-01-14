package a260114.interface1;

class Airplane implements Flyable {

    @Override
    public void fly() {
        System.out.println("비행기가 이륙합니다.");
    }
    
}
