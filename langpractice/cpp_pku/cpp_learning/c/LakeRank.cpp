#include <iostream>
using namespace std;

bool flag = false;
int p, d, t, h;

void setflag() {
    bool ap, ad, ah;
    bool bp, bd, bt, bh;
    bool cd, ch;
    bool dp, dd, dt, dh;

    ap = (p == 3); ad = (d == 1);                ah = (h == 4);
    bp = (p == 2); bd = (d == 4); bt = (t == 3); bh = (h == 1);
                   cd = (d == 3);                ch = (h == 4);
    dp = (p == 1); dd = (d == 3); dt = (t == 4); dh = (h == 2);
    //cout << ap << ad << ah << endl;
    //cout << bp << bd << bt << bh << endl;
    //cout << cd << ch << endl;
    //cout << dp << dd << dt << dh << endl;
    int a = ap + ad +      ah;
    int b = bp + bd + bt + bh;
    int c =      cd +      ch;
    int d = dp + dd + dt + dh;
    //cout << a << b << c << d << endl;
    if (a == 1 && b == 1 && c == 1 && d == 1) flag = true;
    //cout << flag << endl;
}

int main() {
    p = d = t = h = 0;

    for (p = 1; p < 5; ++p) {
    for (d = 1; d < 5; ++d) {
        if (p == d) continue;
    for (t = 1; t < 5; ++t){
        if (d == t || p == t) continue;
    for (h = 1; h < 5; ++h){
        if (t == h || d == h || p == h) continue;
        //cout << p << d << t << h << endl;
        setflag();
        if (flag) break;
    }
        if (flag) break;
    }
        if (flag) break;
    }
        if (flag) break;
    }

    //cout << flag << endl;
    cout << p << "\n" << d << "\n" << t << "\n" << h << endl;
return 0;
}
