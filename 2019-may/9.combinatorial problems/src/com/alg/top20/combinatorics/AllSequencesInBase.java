package com.alg.top20.combinatorics;

public class AllSequencesInBase {

	public static void allSeq1(int n, int b) {
		auxSeq1(0, n, b, "");
	}
	public static void auxSeq1(int d, int n, int b, String out) {
		if(d == n) {
			System.out.println(out);
			return;
		}
		for(int i = 0; i <  b; ++i)
			auxSeq1(d+1, n, b, out+i);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		allSeq1(n, b);
	}

}
