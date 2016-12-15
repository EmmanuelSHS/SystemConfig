#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX 80

int main() {
    char str1[80], str2[80];
    int res;

    gets(str1);
    gets(str2);
    
    for (int i = 0; i < MAX; ++i) {
        if (str1[i] == '\0') break;
        str1[i] = tolower(str1[i]);
    }

    for (int i = 0; i < MAX; ++i) {
        if (str2[i] == '\0') break;
        str2[i] = tolower(str2[i]);
    }

    res = strcmp(str1, str2);
    if (res == 0) printf("%c\n", '=');
    if (res > 0) printf("%c\n", '>');
    if (res < 0) printf("%c\n", '<');

return 0;
}
