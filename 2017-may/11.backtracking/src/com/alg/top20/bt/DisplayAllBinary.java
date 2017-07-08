package com.alg.top20.bt;
import java.util.Arrays;


public class DisplayAllBinary {

	public static void displayBinarySeq1(int n) {
		for(int i = 0; i <=1; ++i) {
			for(int j = 0; j <= 1; ++j) {
				System.out.println(i +" " +j);
			}
		}
	}	
	public static void displayBinarySeq2(int n) {
		int[] out = new int[n];
		auxBinarySeq2(0, n, out);
	}
	private static void auxBinarySeq2(int d, int n, int[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}		
		for(int i = 0; i <=1; ++i) {
			out[d] = i;
			auxBinarySeq2(d+1, n, out);
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		displayBinarySeq2(n);
	}

}
