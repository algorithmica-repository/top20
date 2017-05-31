//Illustration of map operations
#include<iostream>
#include<map>
#include<string>
using namespace std;

int main() {
    map<int, string> m;
    m.insert(make_pair(10,"abc"));
    m.insert(make_pair(20,"xyz"));
    m.insert(make_pair(20,"pqr"));
    m.insert(make_pair(25,"def"));
    map<int,string>::iterator i;
    for(i = m.begin();i!=m.end();i++)
      cout<<i->first<<" "<<i->second<<endl;
    getchar();
}


