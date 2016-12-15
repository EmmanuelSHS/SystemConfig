#include <iostream>
using namespace std;

#define NEI 4

int main() {
    int n, count;
    cin >> n;
    int all = n * n;
    int a[n][n];
    for (int i = 0; i < all; ++i) cin >> a[i / n][i % n];
    count = 0;

    for (int i = 1; i < n - 1; ++i) {
    for (int j = 1; j < n - 1; ++j) {
        int diff = a[i -1][j] - a[i][j] + a[i + 1][j] - a[i][j] + a[i][j - 1] - a[i][j] + a[i][j + 1] - a[i][j];    
        if (diff >= 200) ++count;
    }
    }
    cout << count << endl;

return 0;
}
