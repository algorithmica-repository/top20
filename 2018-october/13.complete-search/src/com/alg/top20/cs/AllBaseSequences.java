package com.alg.top20.cs;

import java.util.Arrays;

public class AllBaseSequences {

	public static void allSeq1(int n, int b) {
		for(int i = 0; i < b; ++i) {
			for(int j = 0; j < b; ++j) {
				for(int k = 0; k < b; ++k) 
					System.out.println(i +"" +j+""+k);
			}
		}
	}
	
	public static void allSeq2(int n, int b) {
		int[] out = new int[n];
		auxSeq2(0, out, b);
	}
	private static void auxSeq2(int d, int[] out, int b) {
		if(d == out.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < b; ++i) {
			out[d] = i;
			auxSeq2(d+1, out, b);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		allSeq2(n, 10);
	}

}
