package com.alg.top20.cs;

public class AllSubsets {

	public static void allSubsets11(String in) {
		auxSubsets11(in, "");
	}
	private static void auxSubsets11(String in, String out) {
		if(in.length() == 0) {
			System.out.println(out);
			return;
		}
		//exclude
		auxSubsets11(in.substring(1), out);
		//include
		auxSubsets11(in.substring(1), out+in.charAt(0));
	}
	
	public static void allSubsets12(String in) {
		auxSubsets12(0, in, "");
	}
	private static void auxSubsets12(int d, String in, String out) {
		if(d == in.length()) {
			System.out.println(out);
			return;
		}
		auxSubsets12(d+1, in, out+in.charAt(d));
		auxSubsets12(d+1, in, out);
	}
	
	public static void allSubsets2(String in) {
		auxSubsets2(in, "");
	}
	private static void auxSubsets2(String in, String out) {
		if(in.length() == 0) 
			return;
		for(int i = 0; i < in.length(); ++i) {
			System.out.println(out+in.charAt(i));
			auxSubsets2(in.substring(i+1), out+in.charAt(i));
		}
	}
	
	public static void main(String[] args) {
		allSubsets2(args[0]);

	}

}
