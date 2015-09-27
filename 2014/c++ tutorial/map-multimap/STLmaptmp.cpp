//Illustration of map operations
#include<iostream>
#include<map> //it contains both map and multimap
#include<string>
using namespace std;

int main() {
    multimap<int, string> m;
    m.insert(make_pair(10,"abc"));
    m.insert(make_pair(20,"xyz"));
    m.insert(make_pair(20,"pqr"));
    m.insert(make_pair(25,"def"));
    multimap<int,string>::iterator i;
    for(i = m.begin();i!=m.end();i++)
      cout<<i->first<<" "<<i->second<<endl;
    getchar();
}


