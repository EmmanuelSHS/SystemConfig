#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    for (int i = 10; i <= n; ++i) {
        int tens = i / 10;
        int ones = i - tens*10;
        if ( i % (tens + ones) == 0) cout << i << "\n";
    }
    cout << endl;

return 0;
}
