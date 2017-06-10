package com.alg.top20.basic.removeduplicates;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RemoveDuplicates1 {

	//<= n(n-1)/2 + n + c1 n^2 + c2
	//<=c n^2 ~ O(n^2)
	public static List<Integer> removeDuplicates1(int[] in) {
		List<Integer> out = new LinkedList<Integer>();
		// n(n-1)/2
		for (int i = 0; i < in.length; ++i) {
			if (in[i] != Integer.MAX_VALUE) {
				out.add(in[i]);
				for (int j = i + 1; j < in.length; ++j) {
					if (in[i] == in[j])
						in[j] = Integer.MAX_VALUE;
				}
			}
		}
		return out;
	}

	// n logn + c n 
	// <= c. n logn ~ O(n log  n) 
	public static List<Integer> removeDuplicates2(int[] in) {
		//n log n comparisons
		Arrays.sort(in);
		int i = 0, j;
		List<Integer> out = new LinkedList<Integer>();
		out.add(in[0]);
		// c *n
		for (j = i + 1; j < in.length; ++j) {
				if (in[j] == in[i])
					in[j] = Integer.MAX_VALUE;
				else {
					i = j;
					out.add(in[i]);
				}
		}		
		return out;
	}

	//time: 2n + n ~ O(n)
	//space: <= n slots   O(n)
	public static List<Integer> removeDuplicates3(int[] in) {
		HashSet<Integer> hset = new HashSet<Integer>();
		// n * 2 * O(1)
		for (int i = 0; i < in.length; ++i) {
			hset.add(in[i]);
		}
		List<Integer> out = new LinkedList<Integer>();
		//n
		for (Integer e:hset) {
			out.add(e);
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
		
		for(int i = 0; i < in.length; ++i) 
			 System.out.print(in[i] + " ");
		 System.out.println();
		 
		long start = System.currentTimeMillis();
		List<Integer> out = removeDuplicates3(in);
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000.0 + "seconds");
		
		System.out.println(out);
		 }
}
