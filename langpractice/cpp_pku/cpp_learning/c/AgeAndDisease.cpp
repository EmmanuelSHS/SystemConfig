#include <stdio.h>
#include <iostream>
using namespace std;

int main() {
    int n, a[100];
    double count[4];
    int GROUP = 4;

    cin >> n;
    for (int i = 0; i < n; ++i) {
        cin >> a[i];
        if (1 <= a[i] && a[i] <= 18) ++count[0];
        else if (19 <= a[i] && a[i] <= 35) ++count[1];
        else if (36 <= a[i] && a[i] <= 60) ++count[2];
        else if (60 < a[i]) ++count[3];
    }

    for (int i = 0; i < GROUP; ++i) {
        count[i] = (double)count[i] / n;
        count[i] = count[i] * 100.;
    }
   
   printf("1-18: %.2f%%\n", count[0]); 
   printf("19-35: %.2f%%\n", count[1]);  
   printf("36-60: %.2f%%\n", count[2]);  
   printf("60-: %.2f%%\n", count[3]);  

return 0;
}
