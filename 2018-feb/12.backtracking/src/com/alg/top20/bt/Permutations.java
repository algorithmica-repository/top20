package com.alg.top20.bt;


import java.util.Arrays;

public class Permutations {

	public static void permutations0(int[] in) {
		int[] out = new int[in.length];
		auxPerm0(0, in, out);
	}
	private static boolean isValid0(int[] out) {
		for(int i = 0; i < out.length; ++i) {
			for(int j = i+1; j < out.length; ++j) {
				if(out[i]  == out[j]) return false;
			}
		}
		return true;
	}
	private static void auxPerm0(int d, int[] in, int[] out) {
		if(d == in.length) {
			if(isValid0(out))
				System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxPerm0(d+1, in, out);
		}
	}
	//backtracking
	public static void permutations1(int[] in) {
		int[] out = new int[in.length];
		auxPerm1(0, in, out);
	}
	private static boolean isValid(int[] out, int d, int c) {
		for(int i = 0; i < d; ++i) {
			if(out[i] == c) return false;
		}
		return true;
	}
	private static void auxPerm1(int d, int[] in, int[] out) {
		if(d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			//conditional branching
			if(isValid(out, d, in[i])) {
				out[d] = in[i];
				auxPerm1(d+1, in, out);
			}
		}
	}
	
	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	private static void reverse(int[] in, int i, int j) {
		while(i < j) {
			swap(in, i, j);
			++i;
			--j;
		}
	}
	private static boolean next_permutation(int[] in) {
		int i, j;
		for(i = in.length-2; i >= 0;--i)
			if(in[i] < in[i+1]) break;
		if(i < 0) return false;
		for(j = in.length-1;j > i;--j) { 
			if(in[j] > in[i]) {
				swap(in, i, j);
				break;
			}
		}
		reverse(in, i+1, in.length-1);
		return true;
	}
	//adhoc strategy
	public static void permutations2(int[] in) {
		do {
			System.out.println(Arrays.toString(in));
		} while(next_permutation(in));
	}
	public static void main(String[] args) {
		//permutations1(args[0].toCharArray());
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i+1;
		permutations2(in);
	}


}
