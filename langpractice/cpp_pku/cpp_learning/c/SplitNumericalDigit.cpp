#include <iostream>
using namespace std;

int main() {
    int input;
    int ones, tens, huns;

    cin >> input;
    huns = input / 100;
    cout << huns << "\n";
    input = input - 100*huns;
    tens = input / 10;
    cout << tens << "\n";
    ones = input - 10*tens;
    cout << ones << endl;
    
return 0;
}
