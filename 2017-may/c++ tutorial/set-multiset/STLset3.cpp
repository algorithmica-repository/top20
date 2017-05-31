//Illustration of set operations
#include<iostream>
#include<set>
using namespace std;

int main() {
    multiset<int> s;
    s.insert(10);
    s.insert(20);
    s.insert(25);
    s.insert(20);
    s.insert(15);
    s.insert(18);
    s.insert(10);
    s.insert(15);
    s.insert(17);
    multiset<int>::iterator start = s.lower_bound(10);
    multiset<int>::iterator end = s.upper_bound(20);
    for(; start!=end; ++start)
       cout<<*start<<endl;
    getchar();
}


