#include <stdlib.h>
#include <stdio.h>
#include <iostream>
using namespace std;

int main() {
    int a, b, c;
    scanf("%d,%d,%d", &a, &b, &c);
    
    if      (a + b == c) cout << "+" << endl;
    else if (a - b == c) cout << "-" << endl;
    else if (a * b == c) cout << "*" << endl;
    else if (a / b == c) cout << "/" << endl;
    else if (a % b == c) cout << "%" << endl;
    else                 cout << "error" << endl;

return 0;
}

