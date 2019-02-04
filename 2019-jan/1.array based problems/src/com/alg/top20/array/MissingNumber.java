package com.alg.top20.array;

import java.util.Arrays;
import java.util.BitSet;

public class MissingNumber {

	//TC:O(n log n)    SC:O(1)
	public static int findMissing1(int[] in) {
		int i;
		Arrays.sort(in);
		for(i = 0; i < in.length; ++i) {
			if(in[i] != i) break;
		}
		return i;
	}
	
	//TC:O(n)    SC:O(n)
	public static int findMissing2(int[] in) {
		int i;
		BitSet bset = new BitSet(in.length);
		for(i = 0; i < in.length; ++i)
			bset.set(in[i]);		
		for(i = 0; i < in.length; ++i)
			if(bset.get(i) == false) break;
		return i;
	}
	
	//TC:O(n)    SC:O(1)
	public static int findMissing3(int[] in) {
		int i, res = 0;		
		for(i = 0; i < in.length; ++i)
			res = res ^ (i ^ in[i]);
		return res ^ i;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i;
		System.out.println(findMissing1(in));
		System.out.println(findMissing2(in));
		System.out.println(findMissing3(in));
		
	}

}
