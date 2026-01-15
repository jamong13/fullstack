package a260115;

import java.util.ArrayList;

public class ArrayList3 {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        // 삽입, 추가
        fruits.add("사과");
        fruits.add("바나나");
        fruits.add("오렌지");

        // 인덱스로 요소 읽기
        String fruits1 = fruits.get(0);
        String fruits2 = fruits.get(1);
        String fruits3 = fruits.get(2);

        System.out.println("첫번째 과일: " + fruits1);
        System.out.println("두번째 과일: " + fruits2);
        System.out.println("세번째 과일: " + fruits3);

        System.out.println();

        for(int i = 0; i < fruits.size(); i++){
            System.out.println((i+1) + "번째: " + fruits.get(i));
        }
        System.out.println();

        for(String fruit : fruits){
            System.out.println(fruit);
        }
        // 인덱스 1요소 바나나 -> 포도로 바꿔보기
        fruits.set(1, "포도");
        System.out.println("수정 후: " + fruits);
        // 출력: [사과, 포도, 오렌지]

        // 포도 삭제
        fruits.remove(1);
        // fruits.remove("포도"); rkqtdmfheh tkrwp rksmd
        // fruits.clear(); 전부 삭제
    }
}
