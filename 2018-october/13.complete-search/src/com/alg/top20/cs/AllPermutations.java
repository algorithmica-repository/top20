package com.alg.top20.cs;


public class AllPermutations {

	public static void allPerm1(String in) {
		auxPerm1(in, "");
	}
	private static boolean isValid1(String out) {
		for(int i = 1; i < out.length(); ++i) {
			for(int j = 0; j < i; ++j)
				if(out.charAt(i) == out.charAt(j)) return false;
		}
		return true;
	}
	private static void auxPerm1( String in, String out) {
		if(out.length() == in.length()) {
			if(isValid1(out))
				System.out.println(out);
			return;
		}
		for(int i = 0; i < in.length(); ++i)
			auxPerm1(in, out+in.charAt(i));
	}
	
	public static void allPerm2(String in) {
		auxPerm2(in, "");
	}
	private static boolean isValid2(String out, char c) {
		for(int i = 0; i < out.length(); ++i) {
			if(c == out.charAt(i)) return false;
		}
		return true;
	}
	private static void auxPerm2( String in, String out) {
		if(out.length() == in.length()) {
			System.out.println(out);
			return;
		}
		for(int i = 0; i < in.length(); ++i) {
			if(isValid2(out, in.charAt(i)))
				auxPerm2(in, out+in.charAt(i));
		}
	}
	
	public static void allPerm3(String in) {
		auxPerm3(in, "");
	}
	private static void auxPerm3(String in, String out) {
		if(in.length() == 0) {
			System.out.println(out);
			return;
		}
		for(int i = 0; i < in.length(); ++i) 
			auxPerm3(in.substring(0,i)+in.substring(i+1), out+in.charAt(i));
	}
	public static void main(String[] args) {
		allPerm3(args[0]);
	}

}
