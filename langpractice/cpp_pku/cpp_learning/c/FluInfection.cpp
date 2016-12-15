#include <iostream>
using namespace std;

#define MAXN 100

int n, day, infected;
char room[MAXN + 2][MAXN + 2];
int days[MAXN + 2][MAXN + 2];

void input() {
    cin >> n;
    
    for (int i = 1; i < n + 1; ++i) {
    for (int j = 1; j < n + 1; ++j) {
        cin >> room[i][j];
    }
    }
    for (int i = 0; i < n + 2; ++i) {
    for (int j = 0; j < n + 2; ++j) {
        days[i][j] = 1;
    }
    }

    cin >> day;
}

void infect(int i, int j, int d) {
    if ((room[i - 1][j] == '@' && days[i - 1][j] == d) ||
        (room[i + 1][j] == '@' && days[i + 1][j] == d) ||
        (room[i][j - 1] == '@' && days[i][j - 1] == d) ||
        (room[i][j + 1] == '@' && days[i][j + 1] == d) /*||
        (room[i - 1][j - 1] == '@' && days[i - 1][j - 1] == d) ||
        (room[i - 1][j + 1] == '@' && days[i - 1][j + 1] == d) || 
        (room[i + 1][j - 1] == '@' && days[i + 1][j - 1] == d) ||
        (room[i + 1][j + 1] == '@' && days[i + 1][j + 1] == d)*/) {
        room[i][j] = '@';
    }
}

void ofig() {
    for (int i = 1; i < n + 1; ++i) {
    for (int j = 1; j < n + 1; ++j) {
        cout << room[i][j];
        if ((j - n) == 0) cout << endl;
    }
    }    
}

void odays() {
    for (int i = 1; i < n + 1; ++i) {
    for (int j = 1; j < n + 1; ++j) {
        cout << days[i][j];
        if ((j - n) == 0) cout << endl;
    }
    }    
}

void update(int d) {
    for (int i = 1; i < n + 1; ++i) {
    for (int j = 1; j < n + 1; ++j) {
        if(days[i][j] != d + 1) days[i][j] = d + 1;
    }
    }
}

void dayson() {
    for (int d = 1; d < day; ++d) {
        for (int i = 1; i < n + 1; ++i) {
        for (int j = 1; j < n + 1; ++j) {
            if (room[i][j] == '.' && days[i][j] == d) {
                infect(i, j, d);
                ++days[i][j];
            }
        }
        }
//        update(d);
//        ofig();
//        odays();
    }
}

void count() {
    infected = 0;

    for (int i = 1; i < n + 1; ++i) {
    for (int j = 1; j < n + 1; ++j) {
        if (room[i][j] == '@') ++infected;
    }
    }
}

int main() {
    input();
//    odays();
    dayson();
    count();

    cout << infected << endl;

return 0;
}
