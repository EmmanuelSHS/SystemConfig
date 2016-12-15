#include <iostream>
using namespace std;

#define MAX 5

int split(int m, int k, int div) {
    if (div == 0) return k;
    else {
        int dig = m / div;
//        cout << dig << endl;
        if (dig == 3) --k;
        m -= dig * div;
//        cout << m << endl;
        div = div / 10;
//        cout << div << endl;
        return split(m, k, div);
    }
}

int main() {
    int nk = 0;
    int m, k;
    cin >> m >> k;
    int div = 10000;
    
    if (m % 19 != 0) cout << "NO" << endl;
    else {
        nk = split(m, k, div);
        if (nk == 0) cout << "YES" << endl;
        else cout << "NO" << endl;
    }

return 0;
}
