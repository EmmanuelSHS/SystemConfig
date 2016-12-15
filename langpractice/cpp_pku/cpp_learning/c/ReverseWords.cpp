#include <stdlib.h>
#include <stdio.h>
#include <string.h>
//#include <iostream>
//using namespace std;

#define MAX 501
/*
void move(char *p, int len) {
    char tmp = p[0];
    for (int i = 1; i < len; ++i) p[i - 1] = p[i];
    p[len - 1] = tmp;
}

int rev(char *p, int len) {
    if (len == 1) return 0;
    else {
        move(p, len);
        return rev(p, len - 1);
    }
}

int main() {
    char str[MAX] = {'\0'};
    //gets() doesn't include '\0' in the end of the string
    gets(str);
//    cout << "gets done" << endl;

    char *p = strtok(str, " \t");
    int len = strlen(p);
    rev(p, len);
    printf("%s", p);
    p = strtok(NULL," \t");
//    cout << "1 strtok done" << endl;

    while (p != NULL) {
        //printf("%s", p);
        int len = strlen(p);
        rev(p, len);
        printf(" %s", p);
        p = strtok(NULL," \t");
    }
    char end = '\0';
    printf ("%c", end); 

return 0;
}*/

// another method
int main() {
    int i = 0, j, k;
    char s[MAX], temp;
    gets(s);
    while (s[i]) {
        while (s[i] == ' ') i++;
        if (!s[i]) break;
        j = i;
        while (s[j] != ' ' && s[j]) j++;
        for (k = i; k < (i + j) / 2; k++) {
            temp = s[k];
            s[k] = s[j - 1 + i - k];
            s[j - 1 + i - k] = temp;
        }
        i = j;
    }

    printf("%s\n", s);

return 0;
}
