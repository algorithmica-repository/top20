package com.alg.top20.bt;

import java.util.Arrays;

public class DisplayAllSeq {

	private static void auxSeq(int d, char[] in, char[] out) {
		if(d == in.length) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i < in.length; ++i) {
			out[d] = in[i];
			auxSeq(d + 1, in, out);
		}
	}
	
	public static void displayAllSeq(char[] in) {
		char[] out = new char[in.length];
		auxSeq(0, in, out);
	}
	
	public static void main(String[] args) {
		char[] in = args[0].toCharArray();		
		displayAllSeq(in);
	}


}
