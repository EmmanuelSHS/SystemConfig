#include <iostream>
using namespace std;

#define BD 2

int main() {
    int m, n;
    cin >> m >> n;
    int a[m + BD][n + BD];
    //bool flag[m][n];
    for (int i = 0; i < m + BD; ++i) {
    for (int j = 0; j < n + BD; ++j) {
        a[i][j] = 0;
    }
    }

    for (int i = 1; i < m + BD - 1; ++i) {
    for (int j = 1; j < n + BD - 1; ++j) {
        cin >> a[i][j];
    }
    }

    for (int i = 1; i < m + BD - 1; ++i) {
    for (int j = 1; j < n + BD - 1; ++j) {
        if (a[i][j] >= a[i - 1][j] &&
            a[i][j] >= a[i + 1][j] &&
            a[i][j] >= a[i][j - 1] &&
            a[i][j] >= a[i][j + 1]) {
            //flag[i][j] == true;
            cout << i - 1 << " " << j - 1 << "\n";
        }
    }
    }

return 0;
}
