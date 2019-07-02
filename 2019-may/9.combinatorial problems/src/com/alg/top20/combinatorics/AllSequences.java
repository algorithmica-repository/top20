package com.alg.top20.combinatorics;

public class AllSequences {

	public static void allSeq1(int n, String in) {
		auxSeq1(0, n, in, "");
	}
	public static void auxSeq1(int d, int n, String in, String out) {
		if(d == n) {
			System.out.println(out);
			return;
		}
		for(int i = 0; i <  in.length(); ++i)
			auxSeq1(d+1, n, in, out+in.charAt(i));
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[1]);
		allSeq1(n, args[0]);
	}


}
