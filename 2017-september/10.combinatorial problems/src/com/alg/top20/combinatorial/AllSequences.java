package com.alg.top20.combinatorial;
import java.util.Arrays;


public class AllSequences {
	
	//iterative approach for generating n for loops fail
	public static void displayAllSeq1(int n, char[] in) {
		for(int i = 0; i < in.length; ++i) {
			for(int j = 0; j < in.length; ++j) {
				for(int k = 0; k < in.length; ++k) {
					System.out.println(in[i] + "" + in[j] + "" + in[k]);
				}
			}
		}
	}
	
	//recursive approach for generating n for loops fail
	public static void displayAllSeq2(int n, char[] in) {
		char[] out = new char[n];
		auxAllSeq(0, n, in, out);		
	}
	private static void auxAllSeq(int d, int n, char[] in, char[] out) {
		if(d == n)  {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxAllSeq(d+1, n, in, out);
		}
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		char[] in = args[1].toCharArray();
		displayAllSeq2(n, in);
	}

}
