//Implementation of Singly linked list operations
#include<iostream>
#include<cstdlib>
using namespace std;

//generic node declaration 
template<typename T>
struct node {
     T data;
     node<T>* next;
     node(T x) {
        data = x;
        next = NULL;
     }
     node() {
       next = NULL;
     } 
};

//template or blueprint of generic list objects
template<typename T>
class mylist {
      node<T>* head;
      int size;
  public:
      mylist() { head = new node<T>(); size = 0; }
      //inserts the element into the list in sorted order
      void insert(T x) {
        node<T>* current = head, *tmp;
        while(current->next != NULL && current->next->data < x)
           current = current->next;
        tmp = new node<T>(x);
        tmp->next = current->next;
        current->next=tmp;
        size++;
      }
      //removes the element if found otherwise list is unchanged
      bool remove(T x) {
        node<T>* current = head, *tmp;
        while(current->next != NULL && current->next->data != x)
           current = current->next;
        if(current->next!=NULL) {
           tmp = current->next;
           current->next = tmp->next;
           delete tmp;
           size--;
           return true;
        }
        return false;       
      }      
      //traverse and display the elements of list
      void display() {
         node<T>* current = head->next;
         while(current != NULL) {
           cout<<current->data<<" ";
           current = current->next;
         }
         cout<<endl;
      }
      //reverse the links of all the nodes of list
      void reverse() {
         node<T>* tmp, *current, *prev;
         prev = NULL;
         current = head->next;
         while(current!=NULL) {
           tmp = current->next;
           current->next = prev;
           prev = current;
           current = tmp;
         }
         head->next = prev;
      }
      //remove all the nodes of linked list including header node     
      ~mylist() {
         node<T>* tmp;
         while(head!=NULL) {
           tmp = head->next;
           delete head;
           head = tmp;
         }
         cout<<"~mylist";
      }
      //check for emptiness of list
      bool empty() { return size==0; }
};

#define SIZE 100
int main() {
    mylist<long> l1;
    srand(time(0));
    for(int i = 1; i<=SIZE; i++)
       l1.insert(rand()%SIZE+1);
    //cout<<"First List before reversal:"<<endl;
    l1.display();
    /*for(int i = 1; i<=10; i++) {
       int tmp = rand()%SIZE+1;
       cout<<tmp<<" "<<l1.remove(tmp)<<endl;
    }
    l1.display();
    l1.reverse();
    cout<<"List after reversal:"<<endl;
    l1.display();*/
   
    getchar();
}

