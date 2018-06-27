package com.alg.top20.cs;
import java.util.Arrays;


public class AllSequences {

	public static void allSeq(char[] in, int n){
		char[] out = new char[n];
		auxSeq(0, n, in, out);		
	}
	private static void auxSeq(int d, int n, char[] in, char[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxSeq(d+1, n, in, out);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		char[] in = args[1].toCharArray();
		allSeq(in, n);
	}


}
