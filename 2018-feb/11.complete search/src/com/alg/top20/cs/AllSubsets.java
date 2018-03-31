package com.alg.top20.cs;

public class AllSubsets {

	public static void allSubsets1(String in) {
		auxSubsets1(0,  in, "");
	}
	private static void auxSubsets1(int d, String in, String res) {
		if(d == in.length()) {
			System.out.println(res);
			return;
		}
		auxSubsets1(d+1, in, res);
		auxSubsets1(d+1, in, res+in.charAt(d));
	}
	public static void main(String[] args) {
		allSubsets1(args[0]);
	}

}
