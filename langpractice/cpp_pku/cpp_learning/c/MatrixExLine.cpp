#include <iostream>
#include <iomanip>
using namespace std;

#define COL 5
#define ROW 5
#define ALL 25

int exchangable(int n, int m) {
    if ( 0 <= n && n <= 4 && 0<= m && m <=4) return 1;
    return 0;
}

int main() {
    int a[ROW][COL];
    int n, m, flag;

    //flag = 0;

    for (int i = 0; i < ALL; ++i) {
        cin >> a[i / ROW][i % ROW];
    }
    cin >> n >> m;
    
    flag = exchangable(n, m);
    if (flag == 0) cout << "error" << endl;
    else {
        for (int i = 0; i < COL; ++i) {
            int tmp = a[n][i];
            a[n][i] = a[m][i];
            a[m][i] = tmp;
        }
        for (int i = 0; i < ROW; ++i) {
        for (int j = 0; j < COL; ++j) {
            cout << setw(4) << a[i][j];
        }
        cout << endl;
        }
    }
return 0;
}
