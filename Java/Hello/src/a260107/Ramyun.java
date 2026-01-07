package a260107;

public class Ramyun {
    public static void main(String[] args) {
        buy();
        boil();
        put();
        eat();
    }

    private static void eat() {
        System.out.println("라면을 먹는다.");
        // static 객체 만들 필요없이 호출 가능
        // void 반환값이 없을 때
    }

    private static void put() {
        System.out.println("라면을 넣는다.");
    }

    private static void boil() {
        System.out.println("라면을 끓인다.");
    }

    private static void buy() {
        System.out.println("라면을 사온다.");
    }
}
