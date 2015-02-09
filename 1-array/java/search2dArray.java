package algorithmica;
import java.util.Scanner;
public class search2dArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size;
		Scanner in=new Scanner(System.in);
		size=in.nextInt();
		int [][] arr=new int[size][size];
		for(int i=0;i<arr.length;i++)
			for(int j=0;j<arr.length;j++)
				arr[i][j]=in.nextInt();
		int x=in.nextInt();
		pair p=findElementIndex(arr, x);
		p.getindex();
	
	}
	public static pair findElementIndex(int[][] a,int x)
	{
		int ri=0;
		int ci=a.length-1;
		while(ri<a.length&&ci>=0)
		{	
			if(a[ri][ci]==x)
				return new pair(ri,ci);
			else if(x>a[ri][ci])
				ri++;
			else
				ci--;
		}
		return new pair(-1,-1);
		
	
	}

}


class pair
{
	private int ri;
	private int ci;
	public pair(int ri,int ci)
	{
		this.ri=ri;
		this.ci=ci;
	}
	public void getindex()
	{
		System.out.println(this.ri+" "+this.ci);
	}
}