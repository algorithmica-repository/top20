//Illustration of multimap operations
#include<iostream>
#include<map>
#include<string>
using namespace std;

void display(multimap<int, string> m) {
    multimap<int,string>::iterator i = m.begin();
    for(;i!=m.end();i++)
      cout<<i->first<<" "<<i->second<<endl;
    cout<<endl;
}
int main() {
    multimap<int, string> m;
    m.insert(make_pair(10,"abc"));
    m.insert(make_pair(20,"xyz"));
    m.insert(make_pair(15,"pqr"));
    m.insert(make_pair(25,"def"));
    m.insert(make_pair(25,"lmn"));
    display(m);
    m.erase(25);
    display(m);
    getchar();
}


