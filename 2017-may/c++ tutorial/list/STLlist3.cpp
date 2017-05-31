//illustration of STL List operations
#include<iostream>
#include<list>
#include<algorithm>
using namespace std;

void display(list<int>& l) {
    list<int>::iterator i;
    for(i = l.begin(); i != l.end(); i++)
       cout<<*i<<" ";
    cout<<endl;
}
int main() {
    list<int> l;
    l.push_back(30);
    l.push_back(20);
    l.push_back(10);
    l.push_back(40);
    l.push_back(50);
    l.push_front(10);
    cout<<"list before removal:"<<endl;
    display(l);
    cout<<"list after removal:"<<endl;
    l.remove(10);
    display(l);
    cout<<"list after reversal:"<<endl;
    l.reverse();
    display(l);
    
    getchar();
}

