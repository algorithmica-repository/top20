//given a m*n array, print it in spiral form
//O(m*n) time
//O(1) space

#include<stdio.h>

void printSpiral(int *a,int m, int n)
{
	int i;
	int left=0, right=n-1, top=0, bottom=m-1;
	int state=1;

	while(left<right && top<bottom) //print all the circles
	{
		if(state==1) //left to right
		{
			i=left;
			while(i<right)
			{
				printf("%d ", *((a+top*n)+i));       
				i++;
			}
			state=2;
		}
		else if(state==2) //top to bottom
		{
			i=top;
			while(i<bottom)
			{
				printf("%d ", *((a+i*n)+right));    
				i++;
			}
			state=3;
		}
		else if (state==3) //right to left
		{
			i=right;
			while(i>left)
			{
				printf("%d ",*((a+bottom*n)+i));
				i--;
			}
			state=4;
		
		}

		else if(state==4) //bottom to top
		{
			i=bottom;
			while(i>top)
			{
				printf("%d ", *((a+i*n)+left));
				i--;
			}
			//now decrease the circle lenght
			state=1;
			left++;
			right--;
			top++;
			bottom--;
		}
	}
	
	if(top==bottom) //if only row present
	{
		i=left;
		while(i<=right)
		{
			printf("%d ",*((a+top*n)+i));
			i++;
		}
	}

	else if(left==right) //if only a column present
	{
		i=top;
		while(i<=bottom)
		{
			printf("%d ", *((a+i*n)+left));  
			i++;
		}
	}
	printf("\n");
}



int main()
{
	int m,n;
	scanf("%d %d",&m,&n);

	int a[m][n],i,j;

	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			scanf("%d",&a[i][j]);
		}
	}
	printSpiral((int *)a,m,n);


	return 0;
}

