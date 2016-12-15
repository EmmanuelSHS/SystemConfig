#include <iostream>
using namespace std;

int main() {
    int s, m, n;
    cin >> s;

    for (int k = 0; k < s; ++k) {
        m = n = 0;
        cin >> m >> n;
        int a[m][n];
        int sum = 0;
        //cout << ".1";
        
        for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> a[i][j];
            if (i == 0 || i == m - 1 || j == 0 || j == n - 1) sum += a[i][j];
        }
        }
        //cout << ".2";
        //cout << ".3";
        //cout << ".4";
        cout << sum << endl;
    }

return 0;
}
