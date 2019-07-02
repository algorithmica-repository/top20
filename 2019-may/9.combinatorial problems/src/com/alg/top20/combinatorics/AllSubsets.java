package com.alg.top20.combinatorics;

public class AllSubsets {

	public static void subsets1(String in) {
		auxSubsets1(0, in, "");
	}
	private static void auxSubsets1(int d, String in, String out) {
		if(d == in.length()) {
			System.out.println(out);
			return;
		}
		auxSubsets1(d+1, in, out+in.charAt(d));
		auxSubsets1(d+1, in, out);
	}
	
	public static void subsets21(String in) {
		auxSubsets21(in, "");
	}
	private static void auxSubsets21(String in, String out) {
		System.out.println(out);
		if(in.length() == 0) return;
		for(int i = 0; i < in.length(); ++i)
			auxSubsets21(in.substring(i+1), out+in.charAt(i));
	}
	
	public static void subsets22(String in) {
		auxSubsets22(0, in, "");
	}
	private static void auxSubsets22(int start, String in, String out) {
		System.out.println(out);
		if(start == in.length()) return;
		for(int i = start; i < in.length(); ++i)
			auxSubsets22(i+1, in, out+in.charAt(i));
	}
	public static void main(String[] args) {
		subsets1(args[0]);
		subsets22(args[0]);
	}
}
