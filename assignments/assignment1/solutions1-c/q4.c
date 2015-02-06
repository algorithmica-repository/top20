#include<stdio.h>
void main()
{
 int t[]={15,20,22,25,30},s[]={10,19,20,23,24,30};
 int p=4,q=5;
 while(p>=0 && q>=0)
 {
  if(t[p]<=s[q])
  {
   printf("[%d,%d] ",t[p],s[q]);
   p--;
   q--;
  }
  else
  q++;
 }
}
