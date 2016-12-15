#include <stdlib.h>
#include <stdio.h>
#include <iostream>
using namespace std;

#define MAX 100

int main() {
    struct point {
        int x;
        int y;
        bool f;
    };
    int n, nt;

    n = nt = 0;
    struct point pt[MAX];
    for (int i = 0; i < MAX; ++i) {
        pt[i].x = -1;
        pt[i].y = -1;
        pt[i].f = true;
    }

    cin >> n;
    nt = n;
    for (int i = 0; i < n; ++i) {
        cin >> pt[i].x >> pt[i].y;
    }

    for (int i = 0; i < n; ++i) {
//        printf("judge %d,%d\n", pt[i].x, pt[i].y);
    for (int j = 0; j < n; ++j) {
//        printf("trying %d,%d\n", pt[j].x, pt[j].y);
        if (i == j) continue;
        int dx = pt[j].x - pt[i].x;
        int dy = pt[j].y - pt[i].y;
//        printf("has %d,%d\n", dx, dy);
        if (dx >= 0 && dy >= 0) {
            pt[i].f = false;
//            printf("flag set to false\n");
            --nt;
        }
    }
    }

    for (int i = 0; i < n; ++i) {
    for (int j = i; j < n; ++j) {
        if (pt[i].x > pt[j].x) {
            struct point tmp = pt[i];
            pt[i] = pt[j];
            pt[j] = tmp;
        }
    }
    }
/*
    for (int i = 0; i < n; ++i) {
        printf("(%d,%d,%d)", pt[i].x, pt[i].y, pt[i].f);
    }
*/
    int first = 0;
    for (int i = 0; i < n; ++i) {
        if (pt[i].x != -1 && pt[i].f) {
            printf("(%d,%d)", pt[i].x, pt[i].y);
            first = i;
            break;
        }
    }
    for (int i = first + 1; i < n; ++i) {
        if (pt[i].x != -1 && pt[i].f) printf(",(%d,%d)", pt[i].x, pt[i].y);
    }

    printf("\n");

return 0;
}
