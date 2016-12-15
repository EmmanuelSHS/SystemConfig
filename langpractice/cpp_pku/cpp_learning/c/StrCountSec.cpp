#include <iostream>
using namespace std;
#include <string.h>
#include <ctype.h>

#define MAX 501
#define WL 26

char str[MAX];

struct Stat {
    char name;
    int count;
    int first;
};

Stat s[WL];

int pe = -1;

void iter() {
    for (int i = 0; i < WL; ++i) {
        cout << s[i].name << " " << s[i].count << " " << s[i].first << endl;
    }
}

void getLtrs() {
    int len = strlen(str);
    for (int i = 0; i < len; ++i) {
        if (!isalpha(str[i])) {
            for (int j = i; j < len; ++j) {
                str[j] = str[j + 1];
            }
        }
    }       
}

bool isExist(int i) {
    for (int j = 0; j < WL; ++j) {
        if (str[i] == s[j].name) return true;
    }
    return false;
}

int pEnd(int i) {
    return ++pe;
}

void init(int i) {
    int j = pEnd(i);
    s[j].name = str[i];
    s[j].first = i;
    s[j].count = 1;
}

void add(int i) {
    for (int j = 0; j < WL; ++j) {
        if (str[i] == s[j].name) ++s[j].count; 
    }
}

void getStats() {
    int len = strlen(str);
    for (int i = 0; i < len; ++i) {
        if(!isExist(i)) init(i);
        else add(i);
    }
//    iter();
}

Stat getSec() {
    Stat res;

    for (int i = 0; i < WL; ++i) {
    for (int j = i; j < WL; ++j) {
        if(s[i].count < s[j].count) {
            Stat tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
    }

//    iter();
    int max = s[0].count;
    int sp;
    for (sp = 0; sp < WL; ++sp) {
        if (max > s[sp].count) {
            res = s[sp];
            break;
        }
    }
//    cout << "first second:" << res.name << endl;
    for (int i = sp; i < WL; ++i) {
        if (res.first > s[i].first && res.count == s[i].count) res = s[i];
    }
     
    return res;
}
    
void initS() {
    for (int i = 0; i < WL; ++i) {
        s[i].name = ' ';
        s[i].count = 0;
        s[i].first = MAX;
    }
}

int main() {
    cin >> str;
    initS();
    getLtrs();
    
    int len = strlen(str);
    for (int i = 0; i < len; ++i) str[i] = tolower(str[i]);
    getStats();
    Stat res = getSec();

    cout << (char)(res.name - 32) << "+" << res.name << ":" << res.count << endl;

return 0;
}
