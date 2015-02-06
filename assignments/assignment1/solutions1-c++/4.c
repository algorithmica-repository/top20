//given a non decresing arrays of cups ans saucer sizes
//cup is paired with sauser only if size of cup is <=sauser size
//O(min(m.n)) time
//O(1) space


#include<stdio.h>




int maxPairings(int c[], int s[], int m, int n)
{
	int count=0;
	int i=0,j=0;
	int cup,saucer;

	while(i<m && j<n)
	{
		cup=c[i];
		saucer=s[j];

		if(cup<=saucer)
		{
			count++;
			i++;
			j++;
		}
		else
		{
			j++;
		}
	}
	return count;
}




int main()
{
	int m; //cup array size
	int n; //saucer array size

	scanf("%d %d",&m,&n);
	int i;
	int c[m],s[n];
	for(i=0;i<m;i++)
		scanf("%d",&c[i]);

	for(i=0;i<n;i++)
		scanf("%d",&s[i]);

	printf("max pairings is: %d\n",maxPairings(c,s,m,n));

	return 0;
}
