#include <iostream>
using namespace std;

int main() {
	int N, a[1000], b[1000];

	cin >> N;
	for (int i = 0; i < N; ++i) {
		cin >> a[i];
	}
	for (int i = 0; i < N; ++i) {
		b[i] = 0;
		while (a[i]/2 != 0) {
			if (a[i]%2 == 1) b[i] += 1;
			a[i] /= 2;
		}
		b[i] += 1;
		cout << b[i] << "\n";
	}
	
return 0;
}
