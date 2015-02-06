//Illustration of set operations
#include<iostream>
#include<set>
#include<vector>
using namespace std;

void display(set<int> s) {
    set<int>::iterator i;
    for(i = s.begin(); i != s.end(); i++)
       cout<<*i<<endl;
    cout<<endl;
}
int main() {
    set<int> s;
    s.insert(10);
    s.insert(20);
    s.insert(30);
    s.insert(15);
    display(s);
    s.erase(s.find(20));
    vector<int> v;
    v.push_back(18);
    v.push_back(20);
    v.push_back(30);
    s.insert(v.begin(),v.end());
    display(s);
    set<int> s1;
    s1.insert(s.begin(),s.end());
    display(s1);

    getchar();
}


