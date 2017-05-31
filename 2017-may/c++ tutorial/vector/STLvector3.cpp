//Illustration of Algorithms application to Vector
#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

void display(vector<int>& v) {
    vector<int>::iterator i;
    for(i = v.begin(); i!=v.end();i++)
       cout<<*i<<" ";
    cout<<endl;
}
     
int main() {
    vector<int> v1;
    v1.push_back(30);
    v1.push_back(20);
    v1.push_back(10);
    v1.push_back(40);
    display(v1);
    
    cout<<"Enter the element to search:";
    int element;
    cin>>element;
    vector<int>::iterator res1 = find(v1.begin(),v1.end(),element);
    if(res1 == v1.end()) cout<<"Element not found"<<endl;
    else cout<<"Element found"<<endl;
    
    cout<<"The elements of vector after sorting:"<<endl;
    sort(v1.begin(),v1.end());
    display(v1);

    cout<<"Enter the element to search:";
    cin>>element;
    bool res2 = binary_search(v1.begin(),v1.end(),element);
    if(res2 == false) cout<<"Element not found"<<endl;
    else cout<<"Element found"<<endl;
   
    getchar();   
    getchar();
}

