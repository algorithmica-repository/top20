package com.alg.top20.adhoc;

import java.util.BitSet;

public class FindMissing {

	//TC:O(n)  SC:O(n) bits
	public static int findMissing1(int[] in) {
		BitSet bset = new BitSet(in.length+1);
		for(int i = 0; i < in.length; ++i)
			bset.set(in[i]);
/*		for(int i = 0; i <= in.length; ++i)
			System.out.print(bset.get(i));
		System.out.println();*/
		for(int i = 0; i <= in.length; ++i)
			if(bset.get(i) == false) return i;
		return Integer.MIN_VALUE;
	}
	
	//TC:O(n)   SC:O(1)   array is readonly
	public static int findMissing2(int[] in) {
		int res = 0, i;
		for(i = 0; i < in.length; ++i)
			res ^= (i ^ in[i]);
		res ^= i;
		return res;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i;
		//todo: shuffle input data
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(findMissing2(in));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 + "secs");
	}

}
