//gievn array containing 0 to n except 1
//fid the missing element

#include<stdio.h>

int findMissing(int a[], int n)
{
	int ans=0,i;
	for(i=1;i<=n;i++)
		ans^=i;

	for(i=0;i<n;i++)
		ans^=a[i];

	return ans;
}



int main()
{
	int n;
	scanf("%d",&n);

	int i,a[n];

	for(i=0;i<n;i++)
		scanf("%d",&a[i]);

	printf("missing no: %d\n",findMissing(a,n));

	return 0;
}

