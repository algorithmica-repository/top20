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
		auxSubsets2(s, "");
	}
	private static void auxSubsets2(String s, String path) {
		System.out.println(path);
		if(s.length() == 0) return;
		for(int i = 0; i < s.length(); ++i) 
			auxSubsets2(s.substring(i+1), path+s.charAt(i));
	}
	public static void main(String[] args) {
		allSubsets2(args[0]);
	} 

}
