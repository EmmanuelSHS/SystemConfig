#include <iostream>
using namespace std;

int main() {
	int k, a[100];
	int numOne, numFive, numTen;
	k = 0;
	numOne = 0;
	numFive = 0;
	numTen = 0;

	cin >> k;
	if (1 < k & k < 100) {
	for (int i = 0; i < k; ++i) {
		cin >> a[i];
		if (a[i] == 1) ++numOne;
		else if (a[i] == 5) ++numFive;
		else if (a[i] == 10) ++numTen;
	}
	}
	cout << numOne << endl;
	cout << numFive << endl;
	cout << numTen << endl;

return 0;
}
