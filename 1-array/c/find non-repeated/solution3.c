#include<time.h>
int cmp(const void* a, const void *b) { return *(int*)a - *(int*)b; }

int FindUnRepeated(long a[], long n)
{
    long i;
    qsort(a, n, sizeof(long), cmp);
    for(i=0; i<n-1; i+=2) 
       if(a[i]!=a[i+1]) return a[i];
    return a[i];
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

