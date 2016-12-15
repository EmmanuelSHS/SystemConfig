#include <stdlib.h>
#include <stdio.h>

void sort(int id[], float s[], int n) {
    for (int i = 0; i < n; ++i) {
    for (int j = i; j < n; ++j) {
        if (s[i] < s[j]) {
            int tmp_id = id[i];
            id[i] = id[j];
            id[j] = tmp_id;
            float tmp_s = s[i];
            s[i] = s[j];
            s[j] = tmp_s;
        }
    }
    }
}

int main() {
    int n = 0;
    float min = 0.;
    scanf("%d %f", &n, &min);

    int id[n], flag;
    float s[n];

    flag = 0;

    for (int i = 0; i < n; ++i) {
        scanf("%d %f", &id[i], &s[i]);
        if (s[i] > min) flag = 1;
    }
    
    if (flag == 0) printf("None.\n");
    else {
        sort(id, s, n);
        for (int i = 0; i < n; ++i) { 
            if (s[i] > min) printf("%03d %.1f\n", id[i], s[i]);
        }
    }

return 0;
}
