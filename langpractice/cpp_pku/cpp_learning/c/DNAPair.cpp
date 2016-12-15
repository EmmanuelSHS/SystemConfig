#include <string.h>
#include <iostream>
using namespace std;

#define MAX 256
void reverse(char str[], char pair[], int len) {
    for (int i = 0; i < len; ++i) {
        if (str[i] == 'A') pair[i] = 'T';
        if (str[i] == 'T') pair[i] = 'A';
        if (str[i] == 'G') pair[i] = 'C';
        if (str[i] == 'C') pair[i] = 'G';
    }
}

int main() {
    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        char str [MAX] = {'\0'};
        char pair[MAX] = {'\0'};
        cin >> str;
        int len = strlen(str);
        reverse(str, pair, len);
        cout << pair << endl;
        //printf("%s\n", pair);
    }

return 0;
}
