#include <iostream>
using namespace std;

int main() {
    int n, maxScore, score[100];
    maxScore = 0;

    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> score[i];
        if (score[i] > maxScore) maxScore = score[i];
    }
    cout << maxScore << endl;

return 0;
}
