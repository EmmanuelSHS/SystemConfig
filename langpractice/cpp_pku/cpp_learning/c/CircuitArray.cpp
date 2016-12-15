#include <iostream>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int a[n], *p;
    for (int i = 0; i < n; ++i) cin >> a[i];

    p = &a[n - m];
    for (int i = 0; i < n; ++i) {
        cout << *p << " ";
        if ( p == &a[n - 1]) p = &a[0];
        else ++p;
    }
    cout << endl;

return 0;
}
