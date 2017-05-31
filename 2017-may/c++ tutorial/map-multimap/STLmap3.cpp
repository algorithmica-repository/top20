//Illustration of map operations
#include<iostream>
#include<map>
#include<string>
using namespace std;

void display(map<int,string> m) {
    map<int,string>::iterator i = m.begin();
    for(;i!=m.end();i++)
      cout<<i->first<<" "<<i->second<<endl;
    cout<<endl;
}
int main() {
    map<int, string> m;
    m.insert(make_pair(10,"abc"));
    m.insert(make_pair(20,"xyz"));
    m.insert(make_pair(15,"pqr"));
    m.insert(make_pair(25,"def"));
    display(m);
    m.erase(20);
    display(m);
    getchar();
}


