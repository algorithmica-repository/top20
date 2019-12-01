package com.alg.top20.combinatorics;

public class AllSequences {

	public static void allSeq1(String in) {
		auxAllSeq1(0, in, "");
	}
	private static void auxAllSeq1(int d, String in, String res) {
		if(d == in.length()) {
			System.out.println(res);
			return;
		}
		for(int i = 0; i < in.length(); ++i)
			auxAllSeq1(d+1, in, res+in.charAt(i));
	}

	public static void main(String[] args) {
		allSeq1(args[0]);
	}

}
