#include<stdlib.h>
int cmp(const void* a, const void *b) { return *(int*)a - *(int*)b; }
void sort(int a[], int n) { 
     qsort(a, n, sizeof(int), cmp); 
}
void FindCommon(int a[], int b[], int n)
{
    int i, count = 0;
    sort(b,n);
    for(i=0; i<n; i++) {
        if(bsearch(&a[i], b, n, sizeof(int), cmp) ) printf("%d ",a[i]);
    }
}
int main() 
{
    int a[] = {1, 12, 4, 9, 11};
    int b[] = {2, 14, 16, 9, 11};
    FindCommon(a,b,5);
    getch();
}

