#include <iostream>
using namespace std;

int main() {
    int n, first;
    first = -1;
    cin >> n;
    int a[n];
    for (int i = 0; i < n; ++i) cin >> a[i];

    for (int i = 0; i < n; ++i) {
        if (i == a[i]) {
            first = i;
            break;
        }
    }

    if (first == -1) cout << "N" << endl;
    else cout << a[first] << endl;

return 0;
}
