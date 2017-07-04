import java.util.Arrays;
import java.util.Random;


public class MaxSumNoConsecutive {

	public static int findMaxSumnNoCons1(int[] in) {
		return auxMaxNoCons1(in.length,in);
	}
	private static int auxMaxNoCons1(int i, int[] in) {
		if(i == 0) return 0;
		if(i == 1) return in[i-1];
		int exclusive_sum = auxMaxNoCons1(i-1, in);
		int inclusive_sum = auxMaxNoCons1(i-2, in) +in[i-1];
		return Math.max(exclusive_sum, inclusive_sum);	
	}
	
	public static int findMaxSumnNoCons2(int[] in) {
		int[] c = new int[in.length+1]; 
		auxMaxNoCons2(in.length,in,c);
		return  c[in.length];
	}
	private static int auxMaxNoCons2(int i, int[] in, int[] c) {
		if(i == 0) return 0;
		if(i == 1) return in[i-1];
		int exclusive_sum = (c[i-1] != 0)? c[i-1]: auxMaxNoCons2(i-1, in, c);
		int inclusive_sum = ((c[i-2] != 0) ? c[i-2]: auxMaxNoCons2(i-2, in, c)) + in[i-1];
		return c[i] = Math.max(exclusive_sum, inclusive_sum );	
	}
	
	public static int findMaxSumnNoCons3(int[] in) {
		int[] c = new int[in.length+1]; 
		c[0] = 0;
		c[1] = in[0];
		for(int i = 2; i <= in.length; ++i) {
			int exclusive_sum = c[i-1];
			int inclusive_sum = c[i-2] + in[i-1];
			c[i] = Math.max(exclusive_sum, inclusive_sum );
		}
		return  c[in.length];
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		//System.out.println(Arrays.toString(in));
		//System.out.println(findMaxSumnNoCons1(in));
		//System.out.println(findMaxSumnNoCons2(in));
		System.out.println(findMaxSumnNoCons3(in));
	}

}
