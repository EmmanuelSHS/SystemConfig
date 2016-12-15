#include <stdlib.h>
#include <stdio.h>
#include <string.h>

int main() {
    char s[15], n[15], *str, *substr;
    
    while(gets(s)) {
        str = strtok(s, " ");
        substr = strtok(NULL," ");

        char max = NULL; int maxp = 0;
        for (int i = 0; i < 15; ++i) {
            if (str[i] == '\0') break;
            if (str[i] > max) {
                max = str[i];
                maxp = i;
            }
        }

        for (int i = 0; i < maxp + 1; ++i) n[i] = str[i];
        for (int i = 0; i < 4; ++i) {
            if (substr[i] == '\0') break;
            n[i + maxp + 1] = substr[i];
        }
        for (int i = maxp + 3; i < 15; ++i) {
            if (str[i - 2] == 0) break;
            n[i] = str[i - 2];
        }
        printf("%s\n", n);
    }

return 0;
}
