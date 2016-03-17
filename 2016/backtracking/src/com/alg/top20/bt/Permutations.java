package com.alg.top20.bt;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

	private static boolean isvalid1(char[] out) {
		Set<Character> set = new HashSet<Character>();
		for (char c : out) {
			boolean ret = set.add(c);
			if (ret == false)
				return false;
		}
		return true;
	}

	private static void auxpermute1(int d, char[] in, char[] out) {
		if (d == in.length) {
			if (isvalid1(out))
				System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxpermute1(d + 1, in, out);
		}
	}

	public static void permute1(char[] in) {
		char[] out = new char[in.length];
		auxpermute1(0, in, out);
	}

	private static boolean isvalid2(int d, int c, char[] out) {
		for (int i = 0; i < d; ++i) {
			if(out[i] == c) return false;
		}
		return true;
	}

	private static void auxpermute2(int d, char[] in, char[] out) {
		if (d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for (int i = 0; i < in.length; ++i) {
			if (isvalid2(d,in[i],out)) {
				out[d] = in[i];
				auxpermute2(d + 1, in, out);
			}
		}
	}

	public static void permute2(char[] in) {
		char[] out = new char[in.length];
		auxpermute2(0, in, out);
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		char[] in = new char[size];
		for (int i = 0; i < size; ++i)
			in[i] = (char) (65 + i);
		permute2(in);
	}

}
