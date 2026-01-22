#include <stdio.h>
#include <string.h>

int main(){
    char name[20];
    printf("이름을 입력하세요: ");
    fgets(name, 20, stdin); // scanf처럼 문자 입력
    // name[strlen(name) - 1] = '\0';
    // 입력 : abc + 엔터
    // index :  0   1   2    3    4   5
    // value : 'a' 'b' 'c' '\n' '\0'
    // name[strlen(name) - 1] = '\0'; -> '\n'(엔터)를 '\0'(끝)으로 대체함
    if (name[strlen(name) - 1] == '\n') {
        name[strlen(name) - 1] = '\0';
    }
    printf("입력한 이름: %s\n", name);
    
    return 0;
}