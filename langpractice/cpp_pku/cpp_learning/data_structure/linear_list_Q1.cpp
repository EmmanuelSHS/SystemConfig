/** Josephus Problem 
 * use linkedlist to solve
 * let pointer n -> 1
 * set counter i
 * i == m, delete this element
 * till one element left
 */
#include <list>
#include <iostream>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int mks[n];
    // init list with a array, since the array start at 0, value need +1
    for (int i = 0; i < n; ++i) mks[i] = i + 1;
    list<int> monkeys (mks, mks + sizeof(mks) / sizeof(int));
    // # of monkeys left, counting mark
    int left = n;
    int bcount = m;

    while (left > 1) {
        // iterate
        for (list<int>::iterator it = monkeys.begin(); it != monkeys.end(); ++it) {
            if (bcount == 1) {
                // delete monkeys(i)
                // cout << *it << endl;
                monkeys.erase(it);
                bcount = m;
                --left;
                // without break, the for loop will go on till left = 0 & then while stop
                if (left == 1) break;
                continue;
            }
            --bcount;
        }
    } 

    for (list<int>::iterator it = monkeys.begin(); it != monkeys.end(); ++it) {
        cout /* << "finally " */ << int(*it) << endl;
    }

return 0;
}
