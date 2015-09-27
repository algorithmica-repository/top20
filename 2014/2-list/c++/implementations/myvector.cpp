#include<iostream>
using namespace std;

template<typename T>
class myvector {
      T* a;
      int size;
      int capacity;
  public:
      myvector(int cap = 10) { capacity = cap; a = new T[cap]; size = 0; }
      
      T get(int ind) { return a[ind]; }
      
      void push_back(T x) {
         if(size == capacity) {
           capacity = capacity * 2;
           T* b = new T[capacity];
           for(int i = 0; i < size; i++) 
              b[i] = a[i];
           delete[] a;
           a = b;
         }
         a[size++] = x;
      }
      
      T pop_back() {
        return a[--size];
      }
      void display() {
        for(int i=0; i<size; i++)
          cout<<a[i]<<" ";
        cout<<endl;
      }
      
      bool empty() { return size==0; }
};

int main() {
    myvector<int> a1;
    for(int i = 1; i <= 10; i++)
       a1.push_back(i);
    cout<<"The elments of integer vector are:"<<endl;
    a1.display(); 
      
    myvector<float> a2;
    a2.push_back(10.2);
    a2.push_back(13.4);
    a2.push_back(15.4);
    cout<<"The elments of float vector are:"<<endl;  
    a2.display();
    
    cout<<a2.pop_back(); 
    cout<<a2.pop_back();
    getchar();
}
