package com.alg.top20.combinatorics;

public class AllPermutations {

	public static void permutations1(String in) {
		auxPermutations1(0, in, "");
	}
	private static boolean isValid1(String out) {
		for(int i = 0; i < out.length(); ++i) {
			for(int j = i+1; j < out.length(); ++j) {
				if(out.charAt(i) == out.charAt(j)) return false;
			}
		}
		return true;
	}
	public static void auxPermutations1(int d, String in, String out) {
		if(d == in.length()) {
			if(isValid1(out))
				System.out.println(out);
			return;
		}
		for(int i = 0; i <  in.length(); ++i)
			auxPermutations1(d+1, in, out+in.charAt(i));
	}
	
	public static void permutations2(String in) {
		auxPermutations2(0, in, "");
	}
	private static boolean isValid2(char c, String out) {
		for(int i = 0; i < out.length(); ++i) {
			if(c == out.charAt(i)) return false;
		}
		return true;
	}
	public static void auxPermutations2(int d, String in, String out) {
		if(d == in.length()) {
			System.out.println(out);
			return;
		}
		for(int i = 0; i <  in.length(); ++i) {
			if(isValid2(in.charAt(i), out) )
				auxPermutations2(d+1, in, out+in.charAt(i));
		}
	}
	
	public static void permutations3(String in) {
		auxPermutations3(in, "");
	}
	private static void auxPermutations3(String in, String out) {
		if(in.length() == 0) {
			System.out.println(out);
			return;
		}
		for(int i = 0; i < in.length(); ++i)
			auxPermutations3(in.substring(0, i) + in.substring(i+1), out+in.charAt(i));
	}
	public static void main(String[] args) {
		permutations3(args[0]);
	}

}
