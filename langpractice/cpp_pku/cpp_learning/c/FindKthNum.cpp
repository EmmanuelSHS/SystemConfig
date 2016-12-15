#include <iostream>
using namespace std;

void arrange(int a[], int N) {
    for (int i = 0; i < N; ++i) {
        for (int j = i + 1; j < N; ++j) {
            if (a[i] < a[j]) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
    }
}

int main() {
    int N, K;
    cin >> N >> K;
    int a[N];
    for (int i = 0; i < N; ++i) cin >> a[i];
    
    arrange(a, N);
    //for (int i = 0; i < N; ++i) cout << a[i];
    cout << a[K - 1] << endl;
return 0;
}
