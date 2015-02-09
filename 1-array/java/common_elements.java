package algorithmica;

import java.util.Arrays;
import java.util.Scanner;
public class common_elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a,b;
		int size;
		Scanner in=new Scanner(System.in);
		size=in.nextInt();
		a=new int[size];
		b=new int[size];
		for(int i=0;i<a.length;i++)
			a[i]=in.nextInt();
		for(int i=0;i<b.length;i++)
			b[i]=in.nextInt();
		System.out.println(findCommonElements(a, b));
	}
public static int findCommonElements(int[] a,int[] b)
{
	Arrays.sort(a);
	Arrays.sort(b);
	int i=0,j=0;
	int count=0;
	while(i<a.length&&j<b.length)
	{
		if(a[i]==b[j])
		{
			count++;
			i++;
			j++;
		}
		else if(a[i]<b[j])
			i++;
		else
			j++;
	}	
	return count;
	
}
}
