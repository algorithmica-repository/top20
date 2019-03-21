package com.alg.top20.combinatorics;

public class AllSubsets {

	public static void allSubsets1(String in) {
		auxSubsets1(0, in, "");
	}
	private static void auxSubsets1(int d, String in, String res)  {
		if(d == in.length()) {
			System.out.println(res);
			return;
		}
		auxSubsets1(d+1, in, res+in.charAt(d));
		auxSubsets1(d+1, in, res);
	}
	
	public static void allSubsets21(String in) {
		auxSubsets21(in, "");
	}
	private static void auxSubsets21(String in, String res)  {
		System.out.println(res);
		if(in.length() == 0) return;
		for(int i = 0; i < in.length(); ++i) 
			auxSubsets21(in.substring(i+1), res + in.charAt(i));
	}
	
	public static void allSubsets22(String in) {
		auxSubsets22(0, in, "");
	}
	private static void auxSubsets22(int start, String in, String res)  {
		System.out.println(res);
		if(start == in.length()) return;
		for(int i = start; i < in.length(); ++i) 
			auxSubsets22(i+1, in, res + in.charAt(i));
	}
	public static void main(String[] args) {
		allSubsets21(args[0]);
		System.out.println();
		allSubsets22(args[0]);
	}

}
