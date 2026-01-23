package a260123.List;

import java.util.TreeSet;

public class Set2 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(5);
        set.add(2);
        set.add(8);
        set.add(1);

        // 정렬된 순서로 출력: 1, 2, 5, 8
        for (Integer num : set) {
            System.out.println(num);
}
    }
}
