package a260107;

public class VariableScope {
    public static void main(String[] args) {
        int x = 5;
        System.out.println("x = " + x);
        print(x);
        System.out.println("x = " + x);

    }

    private static void print(int x) {
        System.out.println("x = " + x);
        x = x + 10;
        System.out.println("x = " + x);
    }
}
