#include <stdio.h>
#include <math.h>
#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    float x[n], y[n];
    for (int i = 0; i < n; ++i) cin >> x[i] >> y[i];
    float dis = 0.;

    for (int i = 0; i < n; ++i) {
    for (int j = i; j < n; ++j) {
        if (j == i) continue;
        float tmp = pow((x[i] - x[j]), 2) + pow((y[i] - y[j]),2);
        float tmpsquare = pow(tmp, 0.5);
        if (tmpsquare > dis) dis = tmpsquare;
    }
    }
    printf("%.4f\n", dis);

return 0;
}
