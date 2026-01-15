package a260115;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayList1 {
    public static void main(String[] args) {
        // 컬렉션
        // <데이터형식> -> 제네릭
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        // add() 메서드를 이용한 요소 저장
        arrList.add(40);
        arrList.add(30);
        arrList.add(20);
        arrList.add(10);

        // for문과 get() 메서드 이용해서 요소의 출력
        // 배열 arrList.length -> 리스트에서는 arrList.size() 개수
        for(int i = 0; i < arrList.size(); i++){
            System.out.println(arrList.get(i) + " ");
        }
        System.out.println();
        // remove() 메서드를 이용한 요소 제거
        arrList.remove(1); // 0, 1, 2, 3 실제로 2번째 데이터가 삭제됨
        
        // Enhanced for문
        for(int e : arrList){
            System.out.print(e + " ");
        }
        System.out.println();

        // 컬렉션 정렬 제공
        Collections.sort(arrList);

        // iterator() 메소드와 get() 메소드를 이용한 요소의 출력
        Iterator<Integer> iter = arrList.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        // arrayList 수정 가능
        // set() 메소드를 이용한 요소의 변경(수정)
        arrList.set(0, 20);

        // Enhanced for문
        for(int e : arrList){
            System.out.println(e + " ");
        }
        System.out.println();
        
        // size()메서드 이용한 요소의 총 개수
        System.out.println("리스트의 크기 : " + arrList.size());
    }
}
