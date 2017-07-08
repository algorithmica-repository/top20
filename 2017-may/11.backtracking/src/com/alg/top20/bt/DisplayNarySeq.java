package com.alg.top20.bt;
import java.util.Arrays;


public class DisplayNarySeq {

	public static void displayNarySeq(int n, int base) {
		int[] out = new int[n];
		auxNarySeq(0, n, base, out);
	}
	private static void auxNarySeq(int d, int n, int base, int[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}		
		for(int i = 0; i < base; ++i) {
			out[d] = i;
			auxNarySeq(d+1, n, base, out);
		}
	}
	public static void main(String[] args) {
		int base = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		displayNarySeq(n, base);
	}

}
