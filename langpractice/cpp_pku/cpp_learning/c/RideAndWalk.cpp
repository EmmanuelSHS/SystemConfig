#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    int flag[n];
    int distance;
    int twalk, tbike, TBIKE;

    TBIKE = 23 + 27;

    for(int i = 0; i < n; ++i) {
        cin >> distance;
        twalk = distance / 1.2;
        tbike = distance / 3 + TBIKE;
        if (twalk > tbike) flag[i] = 0;
        else if (twalk < tbike) flag[i] = 1;
        else if (twalk == tbike) flag[i] = 2;
    }
    for(int i = 0; i < n; ++i) {
        if (flag[i] == 0) cout << "Bike\n";
        else if (flag[i] == 1) cout << "Walk\n";
        else cout << "All\n";
    }

return 0;
}
