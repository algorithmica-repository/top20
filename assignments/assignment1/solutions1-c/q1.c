#include<stdio.h>
#include<stdlib.h>
void main()
{
 int a[15];
 int l,r,i,m=0;
 printf("enter the elements in a: ");
 for(i=0;i<15;i++)
 scanf("%d",&a[i]);
 if(a[14]==0)
 {
  printf("\n%d",14);
  exit(1);
 }
 l=0;r=14;
 while(a[l]==0 && a[r]>0)
 {
  m=l+(r-l)/2;
  if(a[m]>=0)
  r=m-1;
  else
  l=m+1;
 }
 if(a[m]==0)
 printf("\n%d",m+1);
 else
 printf("\n%d",m);
}
