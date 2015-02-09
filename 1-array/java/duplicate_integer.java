package algorithmica;
import java.util.Scanner;
public class duplicate_integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int size=in.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<arr.length;i++)
			arr[i]=in.nextInt();

		System.out.println(findDuplicateElement(arr));
	}
	public static int findDuplicateElement(int[] a)
	{
		for(int i=0;i<a.length;i++)
		{
			if(a[Math.abs(a[i])]<0)
				return Math.abs(a[i]);
			else
				a[Math.abs(a[i])]*=-1;
		}
		return -1;
	}

}
