#include<stdio.h>
void main()
{
 int a[10][10]={
		{1,2,3,4,3,2,1,4,5,6},
		{0,8,6,4,3,6,7,8,9,0},
		{1,2,6,7,3,4,5,4,4,3},
		{2,3,2,2,1,1,3,4,5,5},
		{1,2,2,2,3,3,4,2,2,1},
		{1,1,1,2,2,3,5,2,3,1},
		{2,5,7,6,5,4,3,8,0,9},
		{1,1,2,3,4,2,3,5,4,6},
		{1,2,1,2,1,2,1,2,1,2},
		{2,3,2,4,2,2,5,5,5,3},
	       };
 int p1,p2,q1,q2,i,j,flag=0;
 printf("enter the value of p1 and p2");
 scanf("%d%d",&p1,&p2);
 printf("\nenter the value of q1 and q2");
 scanf("%d%d",&q1,&q2);
 i=p1;j=q1;
 while(!(p1==p2) || !(q1==q2))
 {
  printf("%d,",a[i][j]);
  if(flag==0)
  {
   if(j==q2)
   {
    flag=2;
    p1++;
    i++;
   }
   else
   j++;
  }
  else if(flag==1)
  {
   if(j==q1)
   { 
    flag=3;
    p2--;
    i--;
   }
   else
   j--;
  }
  else if(flag==2)
  {
   if(i==p2)
   {
    flag=1;
    q2--;
    j--;
   }
   else
   i++;
  }
  else if(flag==3)
  {
   if(i==p1)
   {
    flag=0;
    q1++;
    j++;
   }
   else
   i--;
  }
 }
 printf("%d\n",a[i][j]);
}
