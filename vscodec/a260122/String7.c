#include <stdio.h>
#include <string.h>

int main(){
    char str1[20] = "Hello";
    char str2[20] = "Hello";
    char str3[20] = "World";

    if(strcmp(str1, str2) == 0){
        printf("str1과 str2는 같습니다\n");
    }
    if(strcmp(str1, str3) != 0){
        printf("str1과 str3은 다릅니다.\n");
    }
    
    return 0;
    // strcmp 반환값:
    // 같으면 0
    // str1이 크면 양수
    // str1이 작으면 음수
}