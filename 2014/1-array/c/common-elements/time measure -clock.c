#include<time.h>
#include<stdlib.h>
int FindCommon(int a[], int b[], int n)
{
    int i, j, count = 0;
    for(i=0; i<n; i++) {
       for(j=0; j<n; j++) {
          if(a[i]==b[j]) { count++; break; }
       }
    }
    return count;
}
#define SIZE 10000
int main() 
{
    int a[SIZE], i; 
    int b[SIZE]; 
    double diff;
    clock_t start, end;
    
    srand((unsigned)time(0)); 
    for(i=0;i<SIZE;i++) {
       a[i] = rand() % SIZE;
       b[i] = rand() % SIZE;
    }
    
    for(i=0;i<SIZE;i++) 
       printf("%d ", a[i]);
    printf("\n\n");
    
    for(i=0;i<SIZE;i++) 
       printf("%d ", b[i]);
       
    start = clock();
    printf("\n\n%d",FindCommon(a,b,SIZE));
    end = clock();
    diff = (end - start) * 1000. / CLOCKS_PER_SEC;
    printf("\ntime taken:%lf msec",diff);
    getch();
}
