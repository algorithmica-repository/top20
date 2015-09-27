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
    m[10]="abc";
    m[25]="xyz";
    m[20]="def";
    m[10]="pqr";
    m[11]="abc";
    display(m);
    m.erase(20);
    display(m);
    getchar();
}


