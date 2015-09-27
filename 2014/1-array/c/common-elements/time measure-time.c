#include<time.h>
#include<stdlib.h>
int cmp(const void* a, const void *b) { return *(int*)a - *(int*)b; }
void sort(int a[], int n) { 
     qsort(a, n, sizeof(int), cmp); 
}
int FindCommon1(int a[], int b[], int n)
{
    int i, j, count = 0;
    for(i=0; i<n; i++) {
       for(j=0; j<n; j++) {
          if(a[i]==b[j]) { count++; break; }
       }
    }
    return count;
}

void FindCommon2(int a[], int b[], int n)
{
    int i, count = 0;
    sort(b,n);
    for(i=0; i<n; i++) {
        if(bsearch(&a[i], b, n, sizeof(int), cmp) ) { printf("%d ",a[i]); break; }
    }
}



#define SIZE 100000
int main() 
{
    int a[SIZE], i; 
    int b[SIZE]; 
    double diff;
    time_t start, end;
    
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
    
    printf("\n\nSolution1");   
    time(&start);
    printf("\nNumber of common elements:%d",FindCommon1(a,b,SIZE));
    time(&end);
    diff = difftime(end, start);
    printf("\ntime taken:%.3lf sec",diff);
    getch();
    
    printf("\n\nSolution2");   
    time(&start);
    printf("\nNumber of common elements:%d",FindCommon2(a,b,SIZE));
    time(&end);
    diff = difftime(end, start);
    printf("\ntime taken:%.3lf sec",diff);
    getch();
    
    
}
