package a260102;

public class Do_while {
    public static void main(String[] args) {
        System.out.println("\n=== do~while문 ===");

        int k = 10;
        do{
            System.out.println("Hello World" + k);
            k++;
        }while(k <= 5);
        // 조건을 나중에 검사하기 때문에 조건에 위배되더라도 무조건 한 번은 출력됨
    }
}
