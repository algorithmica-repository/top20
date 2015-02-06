
void FindCommon(int a[], int b[], int n)
{
    int i, j;
    for(i=0; i<n; i++) {
       for(j=0; j<n; j++)
          if(a[i]==b[j]) { printf("%d ",a[i]); break; }
    }
}
int main() 
{
    int a[] = {2, 14, 4, 9, 11};
    int b[] = {2, 14, 16, 9, 11};
    FindCommon(a,b,5);
    getch();
}

    
