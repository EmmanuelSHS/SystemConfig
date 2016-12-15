#include <iostream>
using namespace std;

int main(){
	int date;
	
	cin >> date;
	if (date == 1 or date == 3 or date == 5){
		cout << "NO" << endl;
	} else {
		cout << "YES" << endl;
	}
	return 0;
}
