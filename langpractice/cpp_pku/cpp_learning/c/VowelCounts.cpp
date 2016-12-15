#include <stdio.h>
#include <stdlib.h>

#define MAX 80

int main() {
    char in[MAX];
    int na, ne, ni, no, nu;
    na = 0; ne = 0; ni = 0; no = 0; nu = 0;
    gets(in);

    for (int i = 0; i < MAX; ++i) {
        if (in[i] == '\0') break;
        if (in[i] == 'a') ++na;
        else if (in[i] == 'e') ++ne;
        else if (in[i] == 'i') ++ni;
        else if (in[i] == 'o') ++no;
        else if (in[i] == 'u') ++nu;
    }
    printf("%d %d %d %d %d\n", na, ne, ni, no, nu);

return 0;
}
