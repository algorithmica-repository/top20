package com.alg.top20.combinatorics;

public class TernarySequences {

	public static void ternarySeq0(int n) {
		for(int i = 0; i < 3; ++i) {
			for(int j = 0; j < 3; ++j) {
				System.out.println(i + "" + j);
			}
		}
	}
	
	public static void ternarySeq11(int n) {
		auxTernarySeq11(0, n, "");
	}
	private static void auxTernarySeq11(int d, int n, String res) {
		if(d == n) {
			System.out.println(res);
			return;
		}
		auxTernarySeq11(d+1, n, res+"0");
		auxTernarySeq11(d+1, n, res+"1");
		auxTernarySeq11(d+1, n, res+"2");
	}
	
	public static void ternarySeq12(int n) {
		auxTernarySeq12(0, n, "");
	}
	private static void auxTernarySeq12(int d, int n, String res) {
		if(d == n) {
			System.out.println(res);
			return;
		}
		for(int i = 0; i < 3; ++i)
			auxTernarySeq12(d+1, n, res+i);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ternarySeq12(n);
	}

}
