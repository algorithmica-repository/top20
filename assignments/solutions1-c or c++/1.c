//given array with continuous zeros followed by non zero elements
//eff algo to find the no of zeros

//O(log n) time


#include<stdio.h>

int zerosCount(int a[], int low, int high)
{
	if(a[low]!=0) //if no zeros at all
		return 0;

	if(low==high && a[low]==0) //if only one element, return its index+1
		return low+1;

	else if(low==high && a[low]!=0) //else return 0
		return 0;

	int mid=(low+high)/2;
	
	if(a[mid]==0) //
	{
		if(mid<high && a[mid+1]!=0) //if mid is the last zero, return its indx+1
			return mid+1; 
		else if(mid<high && a[mid+1]==0) //else go recursive to right
			return zerosCount(a,mid+1,high);
	}
	else //else go recursive to left
	{
		return zerosCount(a,low,mid-1);
	}

}
int main()
{
	int n;
	scanf("%d",&n);

	int i,a[n];
	for(i=0;i<n;i++)
		scanf("%d",&a[i]);

	printf("no of zeros : %d\n",zerosCount(a,0,n-1));

	return 0;
}


