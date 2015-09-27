#include<iostream>
#include<map>
#include<string>
using namespace std;

int main() {
    map<int, string> m;
    m.insert(make_pair(10,"abc"));
    m.insert(make_pair(20,"xyz"));
    m.insert(make_pair(15,"pqr"));
    m.insert(make_pair(25,"def"));
    map<int,string>::iterator res = m.find(20);
    if(res==m.end()) cout<<"Element mapping not found"<<endl;
    else cout<<"Element mapping:"<<res->second<<endl;

    getchar();
}


