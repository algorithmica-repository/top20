package com.alg.top20.basic.twosum;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class TwoSum1 {

	//<= c .n(n-1)/2  ~ O(n^2)
	public static boolean twoSum1(int[] in, int s) {
		for(int i = 0; i < in.length; ++i) {
			for(int j = i+1; j < in.length; ++j) {
				if(in[i] + in[j] == s) return true;
			}
		}
		return false;
	}
	
	//n log n + n log n ~ O(n log n)
	public static boolean twoSum2(int[] in, int s) {
		Arrays.sort(in);
		for(int i = 0; i < in.length-1; ++i) {
			if(Arrays.binarySearch(in, i+1, in.length-1, s-in[i]) >= 0)
				return true;
			
		}
		return false;
	}
	
	//n log n  + <=c. n ~ O(n log n)
	public static boolean twoSum3(int[] in, int s) {
		Arrays.sort(in);
		for(int i = 0, j = in.length-1; i < j;) {
			if(in[i] + in[j] == s) return true;
			if(in[i] + in[j] < s)
				++i;
			else
				--j;			
		}
		return false;
	}
	
	//n * 2 * O(1) ~ O(n)
	public static boolean twoSum4(int[] in, int s) {
		HashSet<Integer> hset = new HashSet<Integer>();
		for(int i = 0; i < in.length; ++i) {
			if(hset.contains(s-in[i]))
				return true;
			else
				hset.add(in[i]);			
		}
		return false;
	}
	
	public static void testcase1(int[] in) {
		int s = 0;
		System.out.println(s);		
		System.out.println(twoSum3(in, s));
	}
	
	public static void testcase2(int[] in, Random r) {
		int s = r.nextInt(in.length) +  1;
		System.out.println(s);
		System.out.println(twoSum3(in, s));
	}
	
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int[] in = new int[size];
		
		Random r = new Random();
		for (int i = 0; i < in.length; ++i) 
			in[i] = r.nextInt(size) + 1;

		/*for(int i = 0; i < in.length; ++i) 
			 System.out.print(in[i] + " ");
		 System.out.println();*/
		long start = System.currentTimeMillis();
		testcase1(in); 
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000.0 + "seconds");

	}

}
