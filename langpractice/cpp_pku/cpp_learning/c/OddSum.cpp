#include <iostream>
using namespace std;

int main() {
    int m, n;
    int sum = 0;

    cin >> m >> n;
    if (0<=m & m<=n & n<=300) {
    for (int i = m; i < n+1; ++i) {
        if (i%2 == 1) sum += i;
    }
    }
    cout << sum << endl;

return 0;
}
