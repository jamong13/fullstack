#include <stdio.h>

int main (){
    //8개의 정수를 입력받아 배열에 저장한 후, 짝수와 홀수를 분리하여 각각 출력하는 프로그램을 작성하세요. 
    // 짝수는 먼저 출력하고, 그 다음 홀수를 출력합니다.
    // 1 2 3 4 5 6 7 8
    // 1 3 5 7 9 11 13 15
    int i;
    int list[8];
    int odd[8], even[8];
    int oddCount = 0, evenCount = 0;

    for(i = 0; i < 8; i++){
        scanf("%d", &list[i]);
    }
    for(i = 0; i < 8; i++){
        if(list[i] % 2 == 0){
            even[evenCount] = list[i];
            evenCount++;
        }else{
            odd[oddCount] = list[i];
            oddCount++;
        }
    }
    printf("짝수: ");
    if(evenCount == 0){
        printf("없음");
    }else{
        for(i = 0; i < evenCount; i++){
            printf("%d", even[i]);
            if(i < evenCount - 1){
                printf(" ");
            }
        }
    }
    printf("\n");
    printf("홀수: ");
    if(oddCount == 0){
        printf("없음");
    }else{
        for(i = 0; i < oddCount; i++){
            printf("%d", odd[i]);
            if(i < oddCount - 1){
                printf(" ");
            }
        }
    }
    
    return 0;
    
}