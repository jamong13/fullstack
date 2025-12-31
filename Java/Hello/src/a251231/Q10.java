package a251231;

public class Q10 {
    public static void main(String[] args) {
        // - 65세 이상: 무료
        // - 학생(초등학생~대학생): 50% 할인 (기본 요금 10,000원)
        // - 일반 성인: 10,000원
        // - 7세 미만: 무료

        int age = 20;
        boolean isStudent = true;
        int price;

        if(age >= 65){
            price = 0;
        }else if(age >= 8){
            if(isStudent == true){
                price = 10000 / 2;
            }else{
                price = 10000;
            }
        }else{
            price = 0;
        }

        System.out.println("가격이 " + price + "원입니다.");
    }
}
