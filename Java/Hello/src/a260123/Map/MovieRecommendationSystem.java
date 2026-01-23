package a260123.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MovieRecommendationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // 영화 목록 초기화
        HashMap<String, Double> movies = new HashMap<>();
        movies.put("인터스텔라", 9.2);
        movies.put("어벤져스", 8.5);
        movies.put("기생충", 9.0);
        movies.put("겨울왕국", 8.7);
        movies.put("토이스토리", 9.1);
        movies.put("라라랜드", 8.8);
        movies.put("매트릭스", 8.9);
        
        HashMap<String, Double> watch = new HashMap<>();
        System.out.println("=== 영화 평점 입력 ===");
        System.out.println("영화를 보고 평점을 입력하세요 (종료: '종료')");
        System.out.println("==== 영화 목록 ====");
        for(Map.Entry<String, Double> entry : movies.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + "점");
        }
        while (true) {
            System.out.println("=== 영화 평점 입력 ===");
            System.out.println("평점을 입력할 영화명을 입력하세요 (종료: '종료'):");
            String watchMovie = scanner.nextLine();
            double userRating;
            if(watchMovie.equals("종료")){
                break;
            }
            if(movies.containsKey(watchMovie)){
                System.out.print("평점을 입력하세요 (0.0 ~ 10.0): ");
                userRating = scanner.nextDouble();
                scanner.nextLine();
                System.out.printf("%s에 %.1f점을 주셨습니다.\n", watchMovie, userRating);
                watch.put(watchMovie, userRating);
            }else{
                System.out.println("해당 영화가 없습니다. 다시 입력해 주세요.");
            }
    

            System.out.println("==== 영화 목록 ====");
            for(Map.Entry<String, Double> entry : movies.entrySet()){
                System.out.println(entry.getKey() + " : " + entry.getValue() + "점");
            }

        }
        System.out.println("==== 입력한 평점 ====");
        double sum = 0;
        int num = 0;
        for(Map.Entry<String, Double> entry : watch.entrySet()){
            System.out.println(entry.getKey()+" : " + entry.getValue() + "점");
            sum += entry.getValue();
            num++;
        }
        double avg = sum / num;
        System.out.printf("평균 평점: %.1f\n", avg);

        System.out.println("==== 추천 영화(9.0점 이상) ====");
        for(Map.Entry<String, Double> entry : watch.entrySet()){
            if(entry.getValue() >= 9){
                System.out.println(entry.getKey() + " : " + entry.getValue() + "점");
            }
        }
        scanner.close();
    }
}
