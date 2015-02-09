package algorithmica;
import java.util.*;

public class majority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int size=in.nextInt();
		int[] arr;
		arr=new int[size];
		for(int i=0;i<arr.length;i++)
			arr[i]=in.nextInt();
		Arrays.sort(arr);
		int prev=arr[0],count=1,maxcount=1,popular=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==prev)
			{
				count++;
			}
			else
			{
				if(count>maxcount)
				{
					maxcount=count;
					popular=arr[i-1];
				}
				count=1;
				prev=arr[i];
			}	
		}
		popular=count>maxcount?arr[arr.length-1] : popular;
		count=(count>maxcount)?count:maxcount;
		System.out.println(popular+" "+count);
		
		
	}

}
