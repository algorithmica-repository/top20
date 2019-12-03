package com.alg.top20.combinatorics;

public class AllPermutations {

	public static void allPerm1(String in) {
		auxAllPerm1(0, in, "");
	}

	private static boolean isValid1(String res) {
		for (int i = 1; i < res.length(); ++i) {
			for (int j = 0; j < i; ++j)
				if (res.charAt(i) == res.charAt(j))
					return false;
		}
		return true;
	}

	private static void auxAllPerm1(int d, String in, String res) {
		if (d == in.length()) {
			if (isValid1(res))
				System.out.println(res);
			return;
		}
		for (int i = 0; i < in.length(); ++i)
			auxAllPerm1(d + 1, in, res + in.charAt(i));
	}

	public static void allPerm2(String in) {
		auxAllPerm2(0, in, "");
	}

	private static boolean isValid2(char c, String res) {
		for (int i = 0; i < res.length(); ++i) {
			if (res.charAt(i) == c)
				return false;
		}
		return true;
	}

	private static void auxAllPerm2(int d, String in, String res) {
		if (d == in.length()) {
			System.out.println(res);
			return;
		}
		for (int i = 0; i < in.length(); ++i) {
			if (isValid2(in.charAt(i), res))
				auxAllPerm2(d + 1, in, res + in.charAt(i));
		}
	}

	public static void allPerm3(String in) {
		auxPerm3(in, "");
	}

	private static void auxPerm3(String in, String res) {
		if (0 == in.length()) {
			System.out.println(res);
			return;
		}
		for (int i = 0; i < in.length(); ++i)
			auxPerm3(in.substring(0, i)+in.substring(i + 1), res + in.charAt(i));
	}

	public static void main(String[] args) {
		allPerm3(args[0]);
	}

}
