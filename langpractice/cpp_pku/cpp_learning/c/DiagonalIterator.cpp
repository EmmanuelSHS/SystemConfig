#include <iostream>
using namespace std;

#define FLAGMAX 200

int main() {
    int row, col;
    cin >> row >> col;
// different compliers have diff. default value for bool array
    int flag[FLAGMAX][FLAGMAX];
    for (int i = 0; i < FLAGMAX; ++i) {
    for (int j = 0; j < FLAGMAX; ++j) {
        flag[i][j] = false;
    }
    }

    if (0 < row && row < 100 && 0 < col && col < 100) {
        int a[row][col];

        for (int i = 0; i < row; ++i) {
        for (int j = 0; j < col; ++j) {
            cin >> a[i][j];
            flag[i][j] = true;    
        }
        }
    /*
        for (int i = 0; i < row; ++i) {
        for (int j = 0; j < col; ++j) {
            cout << a[i][j];
        }
        cout << endl;
        }
    */
    /*    
        for (int i = 0; i < row + 1; ++i) {
        for (int j = 0; j < col + 1; ++j) {
            cout << flag[i][j];
        }
        cout << endl;
        }
    */
        for (int i = 0; i < row + col - 1; ++i) {
    //        cout << "i" << i << endl;  
            for (int j = 0; j < i + 1; ++j) {
    //            cout << "actual" << j << " " << i - j << endl;
                if (flag[j][i - j]) cout << a[j][i - j] << endl;
            }
        }
    }

return 0;
}
