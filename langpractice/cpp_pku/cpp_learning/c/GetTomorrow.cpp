#include <stdlib.h>
#include <stdio.h>

int y, m, d;
int year, month, day;
bool leap, nyear, nmonth;
int dom;

void get_flags() {
    if (((y % 4 == 0) && (y % 100 != 0)) || (y % 400 == 0)) leap = true;
//    printf("leap %d\n", leap); 
    if ( m == 1 || m == 3 || m == 5 || m == 7 || 
         m == 8 || m == 10 || m == 12) {
        dom = 0;
    }
    else if (m == 2) dom = 2;
//    printf("dom %d\n", dom);
    if ((dom == 0 && d == 31) ||
        (dom == 1 && d == 30) ||
        (dom == 2 && d == 29 && leap) ||
        (dom == 2 && d == 28 && !leap)) nmonth = true;
//    printf("nmonth %d\n", nmonth);
    if ( m == 12 && nmonth) nyear = true;
//    printf("nyear %d\n", nyear);
}

void update() {
    if      (nyear)  {year = y + 1; month = 1; day = 1;}
    else if (nmonth) {year = y; month = m + 1; day = 1;}
    else             {year = y; month = m; day = d + 1;}
}

void tomorrow() {
    dom = 1;
    leap = nyear = nmonth = false;
     
    get_flags();
    update();
}

int main() {
    scanf("%d-%d-%d", &y, &m, &d);
    tomorrow();
    printf("%d-%02d-%02d\n", year, month, day);

return 0;
}
