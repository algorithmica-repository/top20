package com.alg.top20.basic;

import java.util.Arrays;
import java.util.BitSet;

public class FindDuplicate {

	public static int findDuplicate1(int[] in) {
		for (int i = 0; i < in.length - 1; ++i) {
			for (int j = i + 1; j < in.length; ++j) {
				if (in[i] == in[j])
					return in[i];
			}
		}
		return 0;
	}
	public static int findDuplicate2(int[] in) {
		Arrays.sort(in);
		for(int i = 1; i < in.length; ++i) {
			if(in[i] == in[i-1]) return in[i];
		}
		return  0;
	}
	
	public static int findDuplicate3(int[] in) {
		BitSet bset = new BitSet(in.length);
		for(int i = 0; i < in.length; ++i) {
			if(bset.get(in[i]) == true)
				return in[i];
			bset.set(in[i]);
		}
		return 0;
	}
	
	public static int findDuplicate4(int[] in) {
		for(int i = 0; i < in.length; ++i) {
			int tmp = Math.abs(in[i]);
			if(in[tmp] < 0)
				return tmp;
			in[tmp] *= -1;
		}
		return 0;
	}

	public static int[] testcase1(int n) {
		int[] in = new int[n];
		int i;
		for(i = 0; i < n-1; ++i)
			in[i] = i+1;
		in[i] = i;
		return in;
	}

	public static int[] testcase2(int n) {
		int[] in = new int[n];
		int i;
		for(i = 0; i < n-1; ++i)
			in[i] = n-(i+1);
		in[i] = i;
		return in;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = testcase2(n); 
		System.out.println(Arrays.toString(in));

		long start = System.currentTimeMillis();
		System.out.println(findDuplicate4(in));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start)/1000.0 + " Seconds");

	}

}