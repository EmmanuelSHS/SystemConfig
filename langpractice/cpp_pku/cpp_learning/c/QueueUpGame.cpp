#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define MAX 100

//this method lacks efficiency
char l[MAX];
char s[MAX];
int n[MAX];

void cgender(char b, char g) {
    int len = strlen(l);
    for (int i = 0; i < len; ++i) {
        if (l[i] == b) s[i] = 'b';
        if (l[i] == g) s[i] = 'g';
    }
}

void shrink(int pos, int len) {
    for (int i = pos; i < len; ++i) {
        s[i] = s[i + 2];
        n[i] = n[i + 2];
    }
}

int out(int len) {
    if (len == 0) return 0;
    else {
        for (int i = 1; i < len; ++i) {
            if (s[i - 1] == 'b' && s[i] == 'g') { 
                printf("%d %d\n", n[i - 1], n[i]);
                shrink(i - 1, len);
                len -= 2;
                break;
            }
            //TODO if WRONG ANSWER, maybe '('not always boy
        }
        return out(len);
    }
}

int main() {
    char b, g;
    gets(l);
    if (l[0] == '(') {
        b = '(';
        g = ')';
    }
    else {
        b = ')';
        g = '(';
    }
    cgender(b, g);
    int len = strlen(l);
    for (int i = 0; i < len; ++i) n[i] = i;

    out(len);

return 0;
}
