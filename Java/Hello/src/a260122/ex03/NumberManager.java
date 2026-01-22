package a260122.ex03;

import java.util.ArrayList;

public class NumberManager {

    public static void addNumber(ArrayList<Integer> list, int i) {
        list.add(i);
    }

    public static int findMax(ArrayList<Integer> list) {
        if(list.isEmpty()){
            return -1;
        }
        int max = list.get(0);
        for(int i = 0; i < list.size(); i++){
            if(max < list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }

    public static int findMin(ArrayList<Integer> list) {
        if(list.isEmpty()){
            return -1;
        }
        int min = list.get(0);
        for(int i = 0; i < list.size(); i++){
            if(min > list.get(i)){
                min = list.get(i);
            }
        }
        return min;
    }

    public static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            sum += list.get(i);
        }
        return sum;
    }
    
}
