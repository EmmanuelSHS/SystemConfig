#include <iostream>
using namespace std;

int jiaogu(int n) {
    if (n == 1) {
        cout << "End" << endl;
        return 0;
    }
    else {
        if (n % 2 == 0) {
            cout << n << "/2=";
            n = n / 2;
            cout << n << "\n";
        }
        else {
            cout << n << "*3+1=";
            n = 3 * n + 1;
            cout << n << "\n";
        }            
        return jiaogu(n);
    }
}
 
int main() {
    int n = 0;
    cin >> n;
    if (n > 0) jiaogu(n);

return 0;
}
