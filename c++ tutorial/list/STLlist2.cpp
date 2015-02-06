//illustration of STL list operations
#include<iostream>
#include<list>
using namespace std;

void display(list<int>& l) {
    list<int>::iterator i;
    for(i = l.begin(); i != l.end(); i++)
       cout<<*i<<" ";
    cout<<endl;
}
int main() {
    list<int> l;
    l.push_front(50);
    l.push_back(30);
    l.push_back(20);
    l.push_back(10);
    l.push_back(40);
    l.push_back(50);
    l.push_front(10);
    cout<<"list before duplicate removal:"<<endl;
    display(l);
    cout<<"list after duplicate removal:"<<endl;
    l.sort(); //sort the list
    l.unique();//removes duplicates
    l.reverse();//reverse the contents of list
    display(l);
    
    getchar();
}

