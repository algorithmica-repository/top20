package com.alg.top20.combinatorics;

public class AllSubsets {
	
	public static void allSubsets1(String in) {
		auxAllSubsets1(0, in, "");
	}
	private static void auxAllSubsets1(int d, String in, String res) {
		if(d == in.length()) {
			System.out.println(res);
			return;
		}
		auxAllSubsets1(d+1, in, res+in.charAt(d));
		auxAllSubsets1(d+1, in, res+" ");
	}
	
	public static void allSubsets2(String in) {
		auxSubsets2(in, "");
	}
	private static void auxSubsets2(String in, String res) {
		System.out.println(res);
		if(0 == in.length()) return;
		for(int i = 0; i < in.length(); ++i)
			auxSubsets2(in.substring(i+1), res+in.charAt(i));
	}

	public static void main(String[] args) {
		allSubsets2(args[0]);
	}

}
