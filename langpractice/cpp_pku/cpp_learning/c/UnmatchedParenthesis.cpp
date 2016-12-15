#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MAX 101
char str[MAX] = {'\0'};
char out[MAX] = {'\0'};
int len;

void inspace() {
    for (int i = 0; i < len; ++i) {
        out[i] = ' ';
    }
}

/* not necessary
void output() {
    for (int i = 0; i < len; ++i) {
        printf("%c", out[i]);
    }
    char end = '\0';
    printf("%c\n", end);
}
*/
void push(int i) {
    out[i] = '$';    
}

void pop(int i) {
    out[i] = '?';
    for (int j = i; j > -1; --j) {
        if(out[j] == '$') {
            out[i] = ' ';
            out[j] = ' ';
            break;
        }
    }
}

void search() {
    for(int i = 0; i < len; ++i) {
        if(str[i] == '(') push(i);
        if(str[i] == ')') pop(i);
    }    
}

int main() {
    while(gets(str)) {
        len = strlen(str);
//        printf("%d", len);
        if (len > 0) {
            printf("%s\n", str);

            inspace();
            search();
            printf("%s\n", out);
//            output();
        }
    }

return 0;
}
