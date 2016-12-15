#include <iostream>
using namespace std;

int main() {
   while(true) {
        int n = 0;
        cin >> n;
        if ( n == 0) break;
        int a[n];
        for (int i = 0; i < n; ++i) cin >> a[i];
        
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (a[i] <= a[j]) continue;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        if (n % 2 == 1) cout << a[n / 2] << endl;
        else cout << (a[(n / 2) - 1] + a[n / 2]) / 2 << endl;
    }
    
return 0;
}
