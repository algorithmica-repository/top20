#include<time.h>
int FindUnRepeated(int a[], int n)
{
    int i, res = 0;
    for(i=0; i<n; i++) 
      res = res ^ a[i];
    return res;
}
#define LIMIT 200000
int main() 
{
    time_t start, end;
    double diff;
    int a[LIMIT+1], i;
    for(i=0; i<LIMIT; i+=2) {
      a[i]= i;
      a[i+1]=i; 
    }    
    a[i]= LIMIT+1;
    printf("Input:");
    for(i=0; i <= LIMIT; i++)
      printf("%d ",a[i]);
    time(&start);
    printf("\nUnrepeated element:%d",FindUnRepeated(a,LIMIT+1));
    time(&end);
    diff = difftime(end, start);
    printf("\ntime taken:%.3lf sec",diff);
    getch();
}
