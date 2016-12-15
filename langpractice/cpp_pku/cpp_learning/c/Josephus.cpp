#include <iostream>
using namespace std;

// 从一人的情况开始考虑，从而反推出最后胜者在n论以前所处的位置 
int main() {
while(true) {
    int n, m, p;
    cin >> n >> m;
    p = 0;
    if (m == 0 && n == 0) break;
    for (int i = 2; i <= n; ++i) p = (p + m) % i;
    cout << p+1 << "\n";
}
return 0;
}

/* 使用链表解决问题
int succedent[300];
int precedent[300];

int main() {
    int n, m;
    while (true) {
        cin >> n >> m;
        if (n == 0 && m == 0) break;

        for (int i = 0; i < n; ++i) {
            succedent[i] = i + 1;
            precedent[i + 1] = i;
        }
        succedent[n - 1] = 0;
        precedent[0] = n - 1;

        int current = 0;
        while (true) {
            for (int count = 0; count < m - 1; count ++) {
                current = succedent[current];
                
                int pre = precedent[current];
                int suc = succedent[current];

                succedent[pre] = suc;
                precedent[suc] = pre;

                if (pre == suc) {
                    cout << pre+1 << endl;
                    break;
                }
                current = suc;
            }
        }
    }
return 0;
}
*/
