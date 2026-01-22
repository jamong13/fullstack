#include <stdio.h>

int main(){
    // 10개의 정수를 입력받아 배열에 저장한 후, 평균을 계산하고 평균 이상인 값의 개수를 출력하는 프로그램을 작성하세요.
    // 85 90 75 60 95 80 70 65 88 92
    int list[10];
    int i;
    int sum = 0;
    float avg;
    int count = 0;

    for(i = 0; i < 10; i++){
        scanf("%d", &list[i]);
    }
    for(i = 0; i < 10; i++){
        sum += list[i];
    }
    avg = (float)sum / 10;

    for(i = 0; i < 10; i++){
        if(avg <= list[i]){
            count++;
        }
    }
    printf("평균: %.2f\n", avg);
    printf("평균 이상인 값의 개수: %d\n", count);

    return 0;

}