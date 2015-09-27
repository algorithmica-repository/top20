#include<stdio.h>
#include<malloc.h>
struct node{
int data;
struct node *link;
};
void append(struct node**,int);
void reorderlist(struct node**);
void display(struct node*);
void main()
{
 struct node *start;
 start=NULL;
 append(&start,9);
 append(&start,3);
 append(&start,0);
 append(&start,2);
 append(&start,-9);
 append(&start,13);
 append(&start,12);
 printf("\nList before reorder:");
 display(start);
 printf("\nList after reorder:");
 reorderlist(&start);
 display(start);
 printf("\n");
}
void append(struct node **p,int n)
{
 struct node *temp,*r;
 if(*p==NULL)
 {
  temp=(struct node*) malloc(sizeof(struct node));
  temp->data=n;
  temp->link=NULL;
  *p=temp;
 }
 else
 { 
  temp=*p;
  while(temp->link!=NULL)
  {
   temp=temp->link;
  }
  r=(struct node*) malloc(sizeof(struct node));
  r->data=n;
  r->link=NULL;
  temp->link=r;
 }
}
void reorderlist(struct node **q)
{
 struct node *temp,*fast,*slow;
 temp=fast=slow=*q;
 if(*q==NULL)
 {
  printf("List is empty");
  return;
 }
 while(fast->link!=NULL && fast->link->link!=NULL)
 {
  slow=slow->link;
  fast=fast->link->link;
 }
 if(fast->link!=NULL)
 {
  //slow=slow->link;
  fast=fast->link;
 }
 *q=slow->link;
 slow->link=NULL;
 fast->link=temp;
}
void display(struct node *q)
{
 while(q!=NULL)
 {
  printf("%d ",q->data);
  q=q->link;
 }
}
