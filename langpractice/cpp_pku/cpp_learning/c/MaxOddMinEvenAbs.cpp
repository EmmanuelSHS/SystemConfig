#include <iostream>
using namespace std;

int main() {
    int N = 6;
    int num[N];
    int maxOdd = 1;
    int minEven = 100;
    int res = 0;

    for (int i = 0; i < N; ++i) {
        cin >> num[i];
        if (num[i]%2 == 0 && num[i] < minEven) minEven = num[i];
        else if (num[i]%2 == 1 && num[i] > maxOdd) maxOdd = num[i];
    }
    res = maxOdd - minEven;
    if (res < 0) res = -res;

    cout << res << endl;

return 0;
}
        
