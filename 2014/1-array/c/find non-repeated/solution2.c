#include<time.h>
int FindUnRepeated(int a[], int n)
{
    int i, j;
    for(i=0; i<n; i++) {
       for(j=0; j<n; j++) {
          if(i!=j && a[i]==a[j]) break;
       }
       if(j==n) return a[i];
    }
}
#define LIMIT 70000
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
