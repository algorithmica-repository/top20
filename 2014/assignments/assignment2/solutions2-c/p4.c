#include<stdio.h>
#include<malloc.h>
struct node{
int data;
struct node *next;
};
void append(struct node*,int);
void sort(struct node*);
void display(struct node*);
void main()
{
 struct node *start;
 start=(struct node*) malloc(sizeof(struct node));
 start->next=start;
 append(start,9);
 append(start,3);
 append(start,0);
 append(start,2);
 append(start,-9);
 append(start,13);
 append(start,12);
 printf("\nList before sorting:");
 display(start);
 printf("\nList after sorting:");
 sort(start);
 display(start);
 printf("\n");
}
void append(struct node *p,int n)
{
 struct node *temp,*r;
 temp=p->next;
 while(temp->next!=p)
 temp=temp->next;
 r=(struct node *) malloc(sizeof(struct node));
 r->data=n;
 r->next=p;
 temp->next=r;
}

void display(struct node *q)
{
 struct node *temp;
 temp=q->next;
 while(temp!=q)
 {
  printf("%d ",temp->data);
  temp=temp->next;
 }
}

void sort(struct node *head)
{
 int min;
 struct node *c1,*c2,*p1,*p2,*t1,*t2,*temp;
 c2=p2=head;
 c1=p1=head->next;
 while(c1->next!=head)
 {
  min=c1->data;
  while(p1!=head)
  {
   if(p1->data < min)
   {
    min=p1->data;
    t1=p1;
    t2=p2;
   }
   p1=p1->next;
   p2=p2->next;
  }
  c2->next=t1;
  t2->next=c1;
  temp=t1->next;
  t1->next=c1->next;
  c1->next=temp;
  c2=c2->next;
  c1=c2->next;
  p2=c2;
  p1=c1;
  t1=c1;
  t2=c2;
 }
}
   
