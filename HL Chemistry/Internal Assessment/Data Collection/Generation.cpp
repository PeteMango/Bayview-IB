#include <bits/stdc++.h>
using namespace std;
double initial, final;

double generateError () {
    return (double)(rand()%(15-11 + 1) + 11)/100.0;
}

double randError () {
    return (double)(rand()%(99-96+1) + 96)/100.0;
}

double tempChange (double x) {
    return (25.69 * 1000 + 139.3*(x - 298.00))/(100*4.18)*(5.0/80.06)*randError();
}

double tempGain () {
    return (double)(rand()%(17-13+1)+13)/100.0;
}

double func (double x){
    if(x == 1) return 6;
    if(x == 2) return 3;
    if(x == 3) return 1;
    if(x == 4) return 0;
}

int main () {
    cin >> initial;
    int time[8] = {0, 2, 4, 6, 8, 10, 12, 14};
    double t[8];

    for(int i =1; i<=3; i++) {
        double tchange = tempChange(initial)-3*tempGain();
        cout << tchange << endl;
        t[0] = initial;
        for(int i = 1; i <= 4; i++) {
            t[i] = t[i-1] - func(i)/10.0*tchange - tempGain();
        }
        for(int i = 5; i <= 7; i++) {
            t[i] = t[i-1] - tempGain();
        }
        for(double u : t) {
            printf("%.2f, ", u);
        }
        cout << endl;
    }
}
