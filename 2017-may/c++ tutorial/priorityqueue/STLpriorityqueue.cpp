#include<iostream>
#include<queue>
using namespace std;
int main() {
  priority_queue<int> pq1;
  pq1.push(10);
  pq1.push(20);
  pq1.push(15);
  pq1.push(25);
  while(!pq1.empty()) {
    cout<<pq1.top()<<endl;
    pq1.pop();
  }
  getchar();
}

