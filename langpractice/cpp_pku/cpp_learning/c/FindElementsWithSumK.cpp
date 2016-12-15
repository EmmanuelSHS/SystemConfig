#include <iostream>
using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    int a[n];
    bool flag = false;
    int sum = 0;

    for (int i = 0; i < n; ++i) cin >> a[i];
    for (int i = 0; i < n; ++i) {
        if (a[i] >= k) continue;
        for (int j = 0; j < n; ++j) {
            if (a[j] >= k) continue;
            sum = a[i] + a[j];
            if (sum == k) {
                flag = true;
                break;
            }
        }
    }
    if (flag == true) cout << "yes" << endl;
    else cout << "no" << endl;
return 0;
}
