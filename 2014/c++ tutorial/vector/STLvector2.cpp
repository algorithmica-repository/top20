//Illustration of Vector Iterator Usage
#include<iostream>
#include<vector>
using namespace std;

int main() {
    vector<int> v1;
    v1.push_back(30);
    v1.push_back(20);
    v1.push_back(10);
    v1.push_back(40);
    vector<int>::iterator i;
    for(i = v1.begin(); i!=v1.end();i++)
       cout<<*i<<endl;
    getchar();
}

