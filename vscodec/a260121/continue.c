#include <stdio.h>

int main(){
    int i;

    for(i=1; i <= 10; i++){
        if(i % 2 == 0){
            continue; // 짝수일 때는 아래 구문 실행 안 하고 건너뛰기
        }
        printf("%d ", i);
    }
    printf("\n");
    return 0;
}