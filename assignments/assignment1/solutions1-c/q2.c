#include<stdio.h>
void main()
{
 int a[20],i,n,res=0;
 printf("enter the value on n:");
 scanf("%d",&n);
 for(i=1;i<=n;i++)
 res=res^i;
 printf("\nenter the elements: ");
 for(i=0;i<n;i++)
 scanf("%d",&a[i]);
 for(i=0;i<n;i++)
 res=res^a[i];
 printf("\n%d",res);
}
