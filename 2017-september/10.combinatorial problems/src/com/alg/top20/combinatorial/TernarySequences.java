package com.alg.top20.combinatorial;
import java.util.Arrays;


public class TernarySequences {
	
	//iterative approach for generating n for loops fail
	public static void displayAllTernarySeq1(int n) {
		for(int i = 0; i <= 2; ++i) {
			for(int j = 0; j <= 2; ++j) {
				System.out.println(i + "" + j);
			}
		}
	}
	
	//recursive approach for generating n for loops fail
	public static void displayAllTernarySeq2(int n) {
		int[] out = new int[n];
		auxTernarySeq(0, n, out);		
	}
	private static void auxTernarySeq(int d, int n, int[] out) {
		if(d == n)  {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i <= 2; ++i) {
			out[d] = i;
			auxTernarySeq(d+1, n, out);
		}
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		displayAllTernarySeq2(n);
	}

}
