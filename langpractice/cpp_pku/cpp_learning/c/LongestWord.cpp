#include <stdio.h>
#include <stdlib.h>

#define MAXNUM 500

int main() {
    int max, start, count, end;
    char str[MAXNUM];
    max = 0; start = 0; count = 0; end = 0;

    gets(str);
    
    for (int i = 0; i < MAXNUM; ++i) {
        if (str[i] == '\0') break;
        if (str[i] == ' ' || str[i] == '.') {
            if (count > max) {
                max = count;
                start = i - max;
            }
            count = 0;
            continue;
        }
        ++count;
    }
    end = start + max;

    for (int i = start; i < end; ++i) printf("%c", str[i]);
    printf("\n");

return 0;
}
