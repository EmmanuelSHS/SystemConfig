#include <iostream>
using namespace std;

int main() {
    int N, a[100];
    N = 0;

    cin >> N;
    for (int i = 0; i < N; ++i) {
        cin >> a[i];
    }
    for (int i = 0; i < N; ++i) {
        cout << a[N - i - 1] << " ";
    }
    cout << endl;

return 0;
}
