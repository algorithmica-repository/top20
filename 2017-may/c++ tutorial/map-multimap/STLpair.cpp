#include<iostream>
using namespace std;

int main() {
    pair<int,int> p1(10,20);
    cout<<p1.first<<" "<<p1.second<<endl;
    pair<int, int> p2 = make_pair(100, 200);
    cout<<p2.first<<" "<<p2.second<<endl;
    getchar();
}


