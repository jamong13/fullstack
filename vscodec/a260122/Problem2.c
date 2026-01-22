#include <stdio.h>

// 평균 이상인 값의 개수 정답
int main(){
    int arr[8];
    int i;
    int sum = 0;
    float average;
    int count = 0; // 평균 이상이 저장

    //72 88 65 90 78 85 70 95
    for(i = 0; i < 8; i++){
        scanf("%d", &arr[i]);
    }

    for(i = 0; i < 8; i++){
        sum += arr[i];
    }
    // 평균
    average = (float) sum / 8;

    // 평균 이상인 값의 개수 세기
    for(i = 0; i < 8; i++){
        if(average <= arr[i]){
            count++;
        }
    }
    printf("평균: %.2f\n", average);
    printf("평균 이상인 값의 개수: %d\n", count);

    return 0;
}