package com.alg.top20.combinatorics;

public class AllPermutations {

	public static void perm1(String in) {
		auxPerm1(in, "");
	}
	private static boolean isValid1(String res) {
		for(int i = 0; i < res.length(); ++i) {
			for(int j = i+1; j < res.length(); ++j) {
				if(res.charAt(i) == res.charAt(j)) return false;
			}
		}
		return true;
	}
	private static void auxPerm1(String in, String res) {
		if(res.length() == in.length()) {
			if(isValid1(res))
				System.out.println(res);
			return;
		}
		for(int i = 0; i < in.length(); ++i) {
			auxPerm1(in, res+in.charAt(i));
		}
	}
	
	public static void perm2(String in) {
		auxPerm2(in, "");
	}
	private static boolean isValid2(String res, char c) {
		for(int i = 0; i < res.length(); ++i)
			if(res.charAt(i) == c) return false;
		return true;
	}
	private static void auxPerm2(String in, String res) {
		if(res.length() == in.length()) {
			System.out.println(res);
			return;
		}
		for(int i = 0; i < in.length(); ++i) {
			if(isValid2(res, in.charAt(i)))
				auxPerm2(in, res+in.charAt(i));
		}
	}
	
	public static void perm3(String in) {
		auxPerm3(in, "");
	}
	private static void auxPerm3(String in, String res) {
		if(in.length() == 0) {
			System.out.println(res);
			return;
		}
		for(int i = 0; i < in.length(); ++i) {
			auxPerm3(in.substring(0, i) + in.substring(i+1), res+in.charAt(i));
		}
	}
	
	
	public static void main(String[] args) {
		perm3(args[0]);
	}

}
