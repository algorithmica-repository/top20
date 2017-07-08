package com.alg.top20.bt;
import java.util.Arrays;

public class Permutations {

	//recursive approach: O(n ^ n+2)  SC:O(n)
	public static void Permutations1(char[] in) {
		char[] out = new char[in.                                 length];
		auxPermutation1(0, in, out);
	}

	private static boolean isValidPermutation(char[] out) {
		for(int i = 0; i < out.length-1;++i) {
			for(int j = i+1; j < out.length; ++j) {
				if(out[i] == out[j]) return false;
			}
		}
		return true;
	}
	private static void auxPermutation1(int d, char[] in, char[] out) {
		if (d == in.length) {
			if (isValidPermutation(out)) {
				System.out.println(Arrays.toString(out));
			}
			return;
		}
		for (int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxPermutation1(d + 1, in, out);
		}
	}
	
	//Backtracking solution 1: O(n * (? + n!) )  SC:O(n)
	public static void Permutations2(char[] in) {
		char[] out = new char[in.length];
		auxPermutation2(0, in, out);
	}

	private static boolean isValid(char c, char[] out, int d) {
		for(int i = 0; i < d; ++i) {
			if(out[i] == c) return false;
		}
		return true;
	}

	private static void auxPermutation2(int d, char[] in, char[] out) {
		if (d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < in.length; ++i) {
			if (isValid(in[i], out, d)) {
				out[d] = in[i];
				auxPermutation2(d + 1, in, out);
			}
		}
	}
	
	//Backtracking solution 2 : O(n! + ?)  SC:O(n)
	public static void Permutations3(char[] in) {
		char[] out = new char[in.length];
		boolean[] used = new boolean[in.length];
		auxPermutation3(0, in, out, used);
	}

	private static boolean isValid3(boolean[] used, int i) {
		return used[i] == false;
	}

	private static void auxPermutation3(int d, char[] in, char[] out, boolean[] used) {
		if (d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < in.length; ++i) {
			if (isValid3(used, i)) {
				out[d] = in[i];
				used[i] = true;
				auxPermutation3(d + 1, in, out, used);
				used[i] = false;
			}
		}
	}
	
	private static void swap(char[] in, int i, int j) {
		char tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	private static void reverse(char[] in, int start) {
		int end = in.length - 1;
		while(start < end) {
			swap(in, start, end);
			++start;
			--end;
		}		
	}
	private static boolean next_permutation(char[] in) {
		int i = in.length - 2;
		while( i >= 0 && in[i] > in[i+1])
			--i;
		if(i < 0) return false;
		int j = in.length - 1;
		while(in[j] < in[i])
			--j;
		swap(in, i, j);
		reverse(in, i+1);
		return true;
	}
	//TC:O(n! * n) SC:O(1)
	public static void Permutations4(char[] in) {
		do {
			System.out.println(Arrays.toString(in));
		} while(next_permutation(in));
	}

	public static void main(String[] args) {
		char[] in = args[0].toCharArray();
		// System.out.println(Arrays.toString(in));
		Permutations4(in);
	}

}
