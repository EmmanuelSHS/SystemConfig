#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <iostream>
using namespace std;

#define SPACE 1
#define MAXW 42

int main() {
    int n = 0;
    scanf("%d\n", &n);
//    cout << n << endl;
/*  
 *  scanf("%s", str);
 *  stops at " "
 */
    int maxn = n * MAXW;
    char str[maxn];
//    cout << "fgets started" << endl;
    fgets(str, maxn, stdin);
//    cout << "fgets done" << endl;

    char *p = strtok(str, " ");
//    cout << p << endl;
        
    int llen = 0;
    while(p != NULL) {
//    for (int i = 0; i < n; ++i) {
        int wlen = strlen(p);
        //cout << wlen;
        if (llen == 0) {
            printf("%s", p);
            llen += wlen;
        }
        else {
            if (llen + SPACE + wlen <= 80) {
                printf(" %s", p);
                llen += SPACE + wlen;
            }
            else {
                printf("\n%s", p);
                llen = wlen;
            }
        }
        p = strtok(NULL, " ");
//        if (p == NULL) break;
//        if (!p) cout << "p is NULL" << endl;
//        else cout << p << endl;
    }

return 0;
}
