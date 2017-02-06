import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class FindCommonElements {

	public static int findCommonElements1(int[] in1, int[] in2) {
		int count = 0;
		//<=n * n
		for (int i = 0; i < in1.length; ++i) {
			for (int j = 0; j < in2.length; ++j) {
				if (in1[i] == in2[j])
					++count;
			}
		}
		return count;
	}

	public static int findCommonElements2(int[] in1, int[] in2) {
		int count = 0;
		//n log n
		Arrays.sort(in1);
		//n log n
		Arrays.sort(in2);
		int i = 0, j = 0;
		//<= 2n
		while (i < in1.length && j < in2.length) {
			if (in1[i] < in2[j])
				++i;
			else if (in1[i] > in2[j])
				++j;
			else {
				++i;
				++j;
				++count;
			}
		}
		return count;
	}
	
	public static int findCommonElements3(int[] in1, int[] in2) {
		int count = 0;
		//n log n
		Arrays.sort(in1);
		//n log n
		for(int i = 0; i < in2.length; ++i) {
			if(Arrays.binarySearch(in1, in2[i]) >= 0)
				++count;
		}
		return count;
	}
	
	public static int findCommonElements4(int[] in1, int[] in2) {
		int count = 0;
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i = 0; i < in1.length; ++i)
			hset.add(in1[i]);
		for(int i = 0; i < in2.length; ++i)
			if(hset.contains(in2[i]))
				++count;
		return count;
	}
	
	public static void removeDuplicates(int[] in) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i = 0; i < in.length; ++i)
			hset.add(in[i]);
		int[] out = new int[hset.size()];
		
			
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		// int m = Integer.parseInt(args[1]);
		int[] in1 = new int[n];
		int[] in2 = new int[n];

		Random r = new Random();
		// unit test case 1 : random numbers
		for (int i = 0; i < in1.length; ++i) {
			in1[i] = r.nextInt(n) + 1;
			in2[i] = r.nextInt(n) + 1;
		}
		//removeDuplicates(in1);
		//removeDuplicates(in2);
		//System.out.println(Arrays.toString(in1));
		//System.out.println(Arrays.toString(in2));
		long start = System.currentTimeMillis();
		int count = findCommonElements4(in1, in2);
		long end = System.currentTimeMillis();
		System.out.println(count);
		System.out.println("Time taken:" + (end - start) / 1000.0 + " seconds");
	}

}
