#include <stdio.h>
#include <string.h>

int main(){
    char str[101];
    char ch;
    int i;
    int count = 0;
    int len;

    fgets(str, 101, stdin);
    len = strlen(str);
    if(len > 0 && str[len-1] == '\n'){
        str[len-1] = '\0';
        len--;
    }

    scanf(" %c", &ch);

    for(i = 0; i < len; i++){
        if(str[i] == ch){
            count++;
        }
    }

    printf("%c가 나타나는 횟수: %d\n", ch, count);
    
    return 0;
}