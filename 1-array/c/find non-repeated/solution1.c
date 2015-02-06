int FindUnRepeated(int a[], int n)
{
    int i, j;
    for(i=0; i<n; i++) {
       for(j=i+1; j<n; j++) {
          if(a[i]==a[j]) break;
       }
       if(j==n) return a[i];
    }
}
int main() 
{
    int a[] = {1, 2, 2, 1, 3, 4, 3};
    printf("%d",FindUnRepeated(a,7));
    getch();
}

    
