//Illustration of Vector operations
#include<iostream>
#include<vector>
using namespace std;
int main() {
    vector<int> v1;
    v1.push_back(30);
    v1.push_back(20);
    v1.push_back(10);
    v1.push_back(40);
    cout<<"vector size:"<<v1.size()<<endl;
     
    cout<<"Vector elements using iterator:"<<endl; 
    vector<int>::iterator i;
    for(i=v1.begin(); i!=v1.end(); i++)
      cout<<*i<<" ";
    cout<<endl;
    getchar();
}

