package com.alg.top20.cs;

public class AllSubsets {
	
	public static void allSubsets1(String s) {
		auxSubsets1(0, s, "");
	}
	private static void auxSubsets1(int d, String s, String path) {
		if(d == s.length()) {
			System.out.println(path);
			return;
		}
		auxSubsets1(d+1, s, path);
		auxSubsets1(d+1, s, path+s.charAt(d));
	}
	
	public static void allSubsets2(String s) {
		auxSubsets1(0, s, "");
	}
	private static void auxSubsets2(int d, String s, String path) {
		if(d == s.length()) {
			System.out.println(path);
			return;
		}
		auxSubsets1(d+1, s, path);
		auxSubsets1(d+1, s, path+s.charAt(d));
	}
	public static void main(String[] args) {
		allSubsets1(args[0]);
	} 

}
