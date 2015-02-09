package algorithmica;

import java.util.Scanner;

public class trailingzeroes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int size=in.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<arr.length;i++)
			arr[i]=in.nextInt();
		System.out.println(findtralingzeroes(arr));

	}

	private static int findtralingzeroes(int[] a) {
		// TODO Auto-generated method stub
		int low=0;
		int high=a.length-1;
		int mid;
		while(low<high-1)
		{
			mid=(high+low)/2;
			if(a[mid]==0)
			{
				low=mid;
			}
			else
			{
				high=mid-1;
			}
			
		}
		if(a[high]==0)
			return high+1;
		if(a[low]==0)
			return low+1;
		
		
		
		return 0;
	}

}
