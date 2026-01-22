#include <stdio.h>

int main(){
    // ### 5개의 정수를 입력받아 배열에 저장한 후, 최댓값과 최솟값을 찾아 출력하는 프로그램을 작성하세요.

    int list[5];
    int i;
    int max, min;
    for(i = 0; i < 5; i++){
        scanf("%d", &list[i]);
    }
    max = list[0];
    min = list[0];
    for(i = 0; i < 5; i++){
        if(max < list[i]){
            max = list[i];
        }
        if(min > list[i]){
            min = list[i];
        }
    }
    printf("최댓값: %d\n", max);
    printf("최솟값: %d\n", min);

    return 0;
}