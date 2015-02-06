//Illustration of STL list operations
#include<iostream>
#include<list>
using namespace std;

int main() {
    list<int> l;
    l.push_back(30);
    l.push_back(20);
    l.push_back(10);
    l.push_back(40);
    l.push_front(15);
    l.pop_back();
    l.insert(l.begin(),60);
    list<int>::iterator i;
    for(i = l.begin(); i != l.end(); i++)
       cout<<*i<<endl;
    getchar();
}

