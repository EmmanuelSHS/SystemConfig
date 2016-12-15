#include <iostream>
using namespace std;

int main() {
    int n, x, y;
    int res;

    cin >> n >> x >> y;
    res = n - y/x - 1;
    cout << res << endl;

return 0;
}
