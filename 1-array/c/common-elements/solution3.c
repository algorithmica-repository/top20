int cmp(const void* a, const void *b) { return *(int*)a - *(int*)b; }
void sort(int a[], int n) { 
     qsort(a, n, sizeof(int), cmp); 
}

int FindCommon(int a[], int b[], int n)
{
    int i=0, j=0, count = 0;
    sort(a,n);
    sort(b,n);
    while(i<n && j<n) {
       if(a[i]==b[j]) { count++; i++; j++; }
       else if(a[i]<b[j]) i++;
            else j++;
    }
    return count;
}
int main() 
{
    int a[] = {1, 5, 4, 3, 2};
    int b[] = {2, 4, 6, 9, 1};    
    printf("Number of common elements:%d\n",FindCommon(a,b,5));
    getch();
}

