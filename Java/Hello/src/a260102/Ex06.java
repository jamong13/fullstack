package a260102;

public class Ex06 {
    public static void main(String[] args) {
        for(int i = 1; i <= 5; i++){
            for(int y = 4; y >= i; y--){
                System.out.print(" ");
            }
            for(int z = 1; z <= i; z++){
                System.out.print("*");
            }
            for(int a = 2; a <= i; a++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
