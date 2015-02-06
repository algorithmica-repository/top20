//Illustration of set operations
#include<iostream>
#include<set>
using namespace std;

void display(set<int>& s) {
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
    s.insert(20);
    display(s);
    
    int x;
    cout<<"Enter the element to find:";
    cin>>x;
    set<int>::iterator i = s.find(x);
    if(i==s.end()) cout<<"Element not found"<<endl;
    else cout<<"Element found"<<endl;
    getchar();
    
    cout<<"Enter the element to delete:";
    cin>>x;
    s.erase(x);
    display(s);
    
    getchar();
    getchar();
}


