#include<stdio.h>
#include<malloc.h>
struct node{
int data;
struct node *link;
struct node *random;
};
void append(struct node**,int);
void randfield(struct node*);
void display(struct node*);
void displayrand(struct node*);
void copylist(struct node*,struct node **);
void mixlink(struct node *,struct node *);
void assgnrand(struct node *); 
void constructlist(struct node *,struct node *);
void main()
{
 struct node *start,*start1;
 start=start1=NULL;
 append(&start,9);
 append(&start,3);
 append(&start,0);
 append(&start,2);
 append(&start,-9);
 append(&start,13);
 append(&start,12);
 printf("\nList without randomization:");
 display(start);
 printf("\nList with randomization:");
 randfield(start);
 displayrand(start);
 copylist(start,&start1);
 mixlink(start,start1);
 assgnrand(start);
 constructlist(start,start1);
 printf("\nlist1:");
 displayrand(start);
 printf("\nlist2:");
 displayrand(start1);
 printf("\n");
}
void constructlist(struct node *current1,struct node *current2)
{
 while(current2->link!=NULL)
 {
  current1->link=current1->link->link;
  current2->link=current2->link->link;
  current1=current1->link;
  current2=current2->link;
 }
 current1->link=NULL;
}



void assgnrand(struct node *head)
{
 while(head!=NULL)
 {
  head->link->random=head->random->link;
  head=head->link->link;
 }
}
 



void mixlink(struct node *head1,struct node *head2)
{
 struct node *next1,*next2,*current1,*current2;
 next1=head1->link;
 next2=head2->link;
 current1=head1;
 current2=head2;
 while(next2!=NULL || next1!=NULL)
 {
  current1->link=current2;
  current2->link=next1;
  current1=next1;
  current2=next2;
  next1=next1->link;
  next2=next2->link;
 }
 current1->link=current2;
}


void copylist(struct node *q,struct node **q1)
{
 struct node *temp,*current;
 while(q!=NULL)
 {
  temp=(struct node *) malloc(sizeof(struct node));
  if(*q1!=NULL)
   current->link=temp;
  else
   *q1=temp;
  temp->link=NULL;
  temp->data=q->data;
  current=temp;
  q=q->link;
 }
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
void randfield(struct node *q)
{ 
 int i=1;
 struct node *temp,*head;
 temp=head=q;
 while(q!=NULL)
 {
  q->random=NULL;
  q=q->link;
  i++;
 }
 q=head;
 while(q!=NULL)
 {
  while(q->random==NULL)
  {
   if((rand()%i)==0)
   q->random=temp->link;
   temp=temp->link;
   if(temp==NULL)
   temp=head;
  }
  q=q->link;
 }
}
void displayrand(struct node *q)
{
 while(q!=NULL)
 {
  printf(" %d,%d ",q->data,q->random->data);
  q=q->link;
 }
}
void display(struct node *q)
{
 while(q!=NULL)
 {
  printf(" %d",q->data);
  q=q->link;
 }
}
