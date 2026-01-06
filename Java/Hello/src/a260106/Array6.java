package a260106;

public class Array6 {
    public static void main(String[] args) {
        // int[] arr6 = {1, 2, 3, 4, 5};
        // 배열 안에 배열이 들어있는 구조
        // {[}{1, 2, 3}, {3, 4, 5}, {6, 7, 8}}
        // 표, 엑셀시트, 좌석 배치, 성적표
        // int[][] arr = new int[3][4];
        // 값 직접 넣기
        int [][] arr1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        // int [][] arr2 = {
        //     {10, 20, 30},
        //     {40, 50, 60}
        // };
        // 값을 하나씩 넣기
        int [][] arr2 = new int[2][3];
        arr2[0][0] = 10;
        arr2[0][1] = 20;
        arr2[0][2] = 30;

        arr2[1][0] = 40;
        arr2[1][1] = 50;
        arr2[1][2] = 60;

        System.out.println(arr2[0][0]);
        System.out.println(arr2[0][1]);
        System.out.println(arr2[0][2]);
        System.out.println(arr2[1][0]);
        System.out.println(arr2[1][1]);
        System.out.println(arr2[1][2]);

        // 이중 for문
        for(int i = 0; i < arr2.length; i++){
            // arr2.length : 행
            for(int j = 0; j < arr2[i].length; j++){
                // arr2[i].length : 열
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println(); // 줄바꿈
        }
    }
}
