//Illustration of multiset operations
#include<iostream>
#include<set>
using namespace std;

int main() {
    multiset<int> s;
    s.insert(10);
    s.insert(20);
    s.insert(30);
    s.insert(10);
    s.insert(20);
    s.insert(17);
    multiset<int>::iterator i;
    for(i=s.begin(); i!=s.end(); ++i)
       cout<<*i<<endl;
    getchar();
}


