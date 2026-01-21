#include <stdio.h>
// 배열 합계 평균
int main(){
    int arr[5] = {10, 5, 20, 8, 15};
    int i, search, found =0;
    printf("검색할 값: ");
    scanf("%d", &search);
    for(i = 0; i < 5; i++){
        if(arr[i] == search){
            printf("%d는 %d번째 위치에 있습니다.", search, i);
        }
    }
    // if(found == 0)
    // 컴퓨터에서 0은 false
    if(!found){
        printf("%d를 찾을 수 없습니다.", search);
    }
    return 0;
}