#include <iostream>
using namespace std;

int main() {
    int h, r;
    int times;
    double vol;
    double PI = 3.14159;

    cin >> h >> r;
    vol = PI * r * r * h * 0.001;
    times = (int)20 / vol + 1; //下取整
    cout << times << endl;

return 0;
}

