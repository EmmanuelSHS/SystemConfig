#include <iostream>
using namespace std;

int main() {
    int m;
    int hun, fif, twe, ten, fiv, one;

    cin >> m;
    hun = (int)m / 100;
    m -= hun * 100;
    fif = (int)m / 50;
    m -= fif * 50;
    twe = (int)m / 20;
    m -= twe * 20;
    ten = (int)m / 10;
    m -= ten * 10;
    fiv = (int)m / 5;
    one = m - fiv * 5;

    cout << hun << "\n";
    cout << fif << "\n";
    cout << twe << "\n";
    cout << ten << "\n";
    cout << fiv << "\n";
    cout << one << endl;
/*  <iostream> has no printf
    printf("%d\n", hun);
    printf("%d\n", fif);
    printf("%d\n", twe);
    printf("%d\n", ten);
    printf("%d\n", fiv);
    printf("%d\n", one);
*/
return 0;
}
