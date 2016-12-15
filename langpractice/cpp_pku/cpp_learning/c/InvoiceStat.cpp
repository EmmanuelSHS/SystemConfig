#include <stdlib.h>
#include <stdio.h>
#include <iostream>
using namespace std;

#define N 3

double invoice[N][N];
double a, b, c;
double id1, id2, id3;

void inputp(int p) {
    int n;
    cin >> n;
    char t;
    double m;
    for (int i = 0; i < n; ++i) {
        cin >> t >> m;
        if (t == 'A') invoice[p - 1][0] += m;
        if (t == 'B') invoice[p - 1][1] += m;
        if (t == 'C') invoice[p - 1][2] += m;
    }
}

void input() {
    int p;

    for (int i = 0; i < N; ++i) {
    for (int j = 0; j < N; ++j) {
        invoice[i][j] = 0;
    }
    }

    for (int i = 0; i < N; ++i) {
        cin >> p;
        inputp(p);
    }    
}

void calculate() {
    for (int i = 0; i < N; ++i) {
        id1 += invoice[0][i];
        id2 += invoice[1][i];
        id3 += invoice[2][i];
        a += invoice[i][0];
        b += invoice[i][1];
        c += invoice[i][2];
    }
}

int main () {
    input();
    calculate();
    
    printf("1 %.2f\n", id1);
    printf("2 %.2f\n", id2);
    printf("3 %.2f\n", id3);
    printf("A %.2f\n", a);
    printf("B %.2f\n", b);
    printf("C %.2f\n", c);
        

return 0;
}
