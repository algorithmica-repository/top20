import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class RemoveDuplicates {

	//<= n(n-1)/2 + n + c1 n^2 + c2
	//<=c n^2 ~ O(n^2)
	public static int[] removeDuplicates1(int[] in) {
		int ndistinct = 0;
		// n(n-1)/2
		for (int i = 0; i < in.length; ++i) {
			if (in[i] != Integer.MAX_VALUE) {
				++ndistinct;
				for (int j = i + 1; j < in.length; ++j) {
					if (in[i] == in[j])
						in[j] = Integer.MAX_VALUE;
				}
			}
		}
		int[] out = new int[ndistinct];
		int k = 0;
		// c * n
		for (int i = 0; i < in.length; ++i) {
			if (in[i] != Integer.MAX_VALUE)
				out[k++] = in[i];
		}
		return out;
	}

	// n logn + c n 
	// <= c. n logn ~ O(n log  n) 
	public static int[] removeDuplicates2(int[] in) {
		//n log n comparisons
		Arrays.sort(in);
		int i = 0, j, ndistinct = 1;
		// c *n
		for (j = i + 1; j < in.length; ++j) {
				if (in[j] == in[i])
					in[j] = Integer.MAX_VALUE;
				else {
					i = j;
					++ndistinct;
				}
		}
		
		int[] out = new int[ndistinct];
		int k = 0;
		for (i = 0; i < in.length; ++i) {
			if (in[i] != Integer.MAX_VALUE)
				out[k++] = in[i];
		}
		return out;
	}

	//time: 2n + n ~ O(n)
	//space: <= n slots   O(n)
	public static int[] removeDuplicates3(int[] in) {
		HashSet<Integer> hset = new HashSet<Integer>();
		// n * 2 * O(1)
		for (int i = 0; i < in.length; ++i) {
//			if(! hset.contains(in[i]))
				hset.add(in[i]);
		}
		int[] out = new int[hset.size()];
		int k = 0;
		//n
		for (Integer e:hset) {
			out[k++] = e;
		}
		return out;
	}
	public static void main(String[] args) {
		// int[] in = { 10,20,10,10};
		int size = Integer.parseInt(args[0]);
		int[] in = new int[size];
		// test case
		Random r = new Random();
		for (int i = 0; i < in.length; ++i) 
			in[i] = r.nextInt(size) + 1;
		
		/*for(int i = 0; i < in.length; ++i) 
			 System.out.print(in[i] + " ");
		 System.out.println();*/
		 
		long start = System.currentTimeMillis();
		int[] out = removeDuplicates3(in);
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000.0 + "seconds");
		
		 /*for(int i = 0; i < out.length; ++i) 
			 System.out.print(out[i] + " ");
*/	}
}
