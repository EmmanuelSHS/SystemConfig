#include <iostream>
using namespace std;

int main() {
    int score = 0;
    cin >> score;

    if (95 <= score && score <= 100) cout << 1 << endl;
    else if (90 <= score && score < 95) cout << 2 << endl;
    else if (85 <= score && score < 90) cout << 3 << endl;
    else if (80 <= score && score < 85) cout << 4 << endl;
    else if (70 <= score && score < 80) cout << 5 << endl;
    else if (60 <= score && score < 70) cout << 6 << endl;
    else if (score < 60) cout << 7 << endl;

return 0;
}
