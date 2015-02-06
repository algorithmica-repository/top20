//implementation of doubly linked list operations
#include<iostream>
#include<cstdlib>
#include<ctime>
using namespace std;

template<typename T>
class node {
  public:
     T data;
     node<T>* next;
     node<T>* prev;
     node(T x) {
        data = x;
        next = prev = this;
     }
     node() {
        data = 0;
        next = prev = this;
     } 
};

template<typename T>
class mylist {
      node<T>* head;
      int size;
  public:
      mylist() { head = new node<T>(); size = 0; }
      
      void insertOrder(T x) {
        node<T>* current = head->next, *tmp;
        while(current!= head && x > current->data)
           current = current->next;
        tmp = new node<T>(x);
        tmp->prev = current->prev;
        tmp->next = current;
        current->prev->next = tmp;
        current->prev = tmp;
        size++;
      }
      void remove(T x) {
        node<T>* current = head->next, *tmp;
        while(current!= head && x != current->data)
           current = current->next;
        if(current==head) return;
        current->prev->next = current->next;
        current->next->prev = current->prev;
        delete current;
        size--;
      }
      void removeDuplicates() {
           node<T>* current = head->next, *tmp;
           while(current->next!=head) {
              tmp = current->next;
              if(current->data == tmp->data) {
                current->next = tmp->next;
                tmp->next->prev = current;
                delete tmp;
              }
              else
                current = current->next;
           }
      }           
      void fdisplay() {
         node<T>* current = head->next;
         while(current != head) {
           cout<<current->data<<" ";
           current = current->next;
         }
         cout<<endl;
      }
      void bdisplay() {
         node<T>* current = head->prev;
         while(current != head) {
           cout<<current->data<<" ";
           current = current->prev;
         }
         cout<<endl;
      }        
      ~mylist() {
         node<T> * tmp;
         while(head->next!=head) {
           tmp = head->next;
           head->next = tmp->next;
           delete tmp;
         }
         delete head;
      }
};

int main() {
    mylist<long> l1;
    srand((unsigned)time(0));
    for(int i = 1; i<=20; i++)
       l1.insertOrder(rand()%10+1);
    cout<<"List forward display:"<<endl;
    l1.fdisplay();
    cout<<"List backward display:"<<endl;
    l1.bdisplay();
    cout<<"Enter the element to delete:";
    int x;
    cin>>x;
    l1.remove(x);
    cout<<"List after removal of given number:"<<endl;
    l1.fdisplay();
    cout<<"List after removal of all duplicates:"<<endl;
    l1.removeDuplicates();
    l1.fdisplay();    
    
    getchar();
    getchar();
}

