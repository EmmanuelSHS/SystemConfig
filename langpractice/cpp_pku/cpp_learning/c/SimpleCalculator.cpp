#include <iostream>
using namespace std;

int main() {
    int x1, x2;
    char op;
    cin >> x1 >> x2 >> op;
    if (op == '+') cout << x1 + x2 << endl;
    else if (op == '-') cout << x1 - x2 << endl;
    else if (op == '*') cout << x1 * x2 << endl;
    else if (op == '/') {
        if (x2 == 0) cout << "Divided by zero!" << endl;
        else cout << x1 / x2;
    }
    else cout << "Invalid operator!" << endl;

return 0;
}
