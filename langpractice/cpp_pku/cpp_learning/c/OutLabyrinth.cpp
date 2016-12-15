#include <iostream>
using namespace std;

#define MAX 102

int n, m, nw, maxs;
int x_s, y_s, x_e, y_e;
char r[MAX][MAX];

int walk (int i, int j, int step) {
    if (step > maxs) return -1;
    else {
        ++step;
        if (r[i][j] == 'T') return step;
        else {
            if (r[i - 1][j] != '#' && r[i - 1][j] != ' ') return walk(i - 1, j, step); 
            else if (r[i + 1][j] != '#' && r[i + 1][j] != ' ') return walk(i + 1, j, step); 
            else if (r[i][j - 1] != '#' && r[i][j - 1] != ' ') return walk(i, j - 1, step); 
            else if (r[i][j + 1] != '#' && r[i][j + 1] != ' ') return walk(i, j + 1, step); 
        }
    }
}

int main() {
    for (int i = 0; i < MAX; ++i) {
    for (int j = 0; j < MAX; ++j) {
        r[i][j] = ' ';
    }
    }

    nw = 0;
    cin >> n >> m;
    for (int i = 1; i < n + 1; ++i) {
    for (int j = 1; j < n + 1; ++j) {
        cin >> r[i][j];
        if (r[i][j] == 'S') {x_s = i; y_s = j;}
        if (r[i][j] == 'T') {x_e = i; y_e = j;}
        if (r[i][j] == '#') {++nw;}
    }
    }
    maxs = m + n - nw - 1;
    int step = 0;
    
    int min = walk(x_s, y_s, step);
    cout << min;

return 0;
}
