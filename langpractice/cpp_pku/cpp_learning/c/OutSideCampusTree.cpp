#include <iostream>
using namespace std;

int main() {
    int l, m;
    int n, nl;
    cin >> l >> m;
    n = l + 1;
    nl = 0;
    int a[n];
    for (int i = 0; i < n; ++i) a[i] = 1;
    
    for (int i = 0; i < m; ++i) {
        int upper = 0;
        int lower = 0;
        cin >> lower >> upper;
        for (int j = lower; j < upper + 1; ++j) {
            if (a[j] == 0) continue;
            a[j] = 0;
        }
    }
    for (int i = 0; i < n; ++i) nl += a[i];
    
    cout << nl << endl;
    
return 0;
}
