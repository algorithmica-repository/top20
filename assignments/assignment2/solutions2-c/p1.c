#include<stdio.h>
#include<malloc.h>
struct node{
char data;
struct node *link;
};
void append(struct node**,char);
void countmaxseq(struct node*);
void main()
{
 struct node *start;
 start=NULL;
 append(&start,'R');
 append(&start,'B');
 append(&start,'R');
 append(&start,'B');
 append(&start,'R');
 append(&start,'R');
 append(&start,'R');
 append(&start,'R');
 append(&start,'R');
 append(&start,'B');
 append(&start,'B');
 append(&start,'B');
 append(&start,'R');
 countmaxseq(start);
}
void append(struct node **p,char n)
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
void countmaxseq(struct node *q)
{
 int i=1,max=0;
 if(q==NULL)
 {
  printf("list is empty");
  return;
 }
 while(q->link!=NULL)
 {
  if(q->data==q->link->data)
  i++;
  else
  {
   if(i>max)
   max=i;
   i=1;
  }
  q=q->link;
 }
 printf("\nMaxcount=%d\n",max);
}
