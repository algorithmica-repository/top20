package com.alg.top20.bt;

import java.util.Arrays;

public class DisplayBinarySeq {

	//hard-coded logic..cant be useful
	public static void displayBS1(int n) {
		for(int i = 0; i <= 1; ++i) {
			for(int j = 0; j <= 1; ++j) {
				for(int k = 0; k <= 1; ++k) {
					System.out.println(i + " " + j + " " + k);
				}
			}
		}
	}
	
	private static void displayInBinary(int i) {
		int mask = 0x80000000;
		for(int j = 0; j < 32; ++j) {
			if((i & mask) == 0)
				System.out.print("0");
			else
				System.out.print("1");
			mask = mask >>> 1;
		}
		
	}
	public static void displayBS2(int n) {
		for(int i = 0; i <= (1 << n) - 1; ++i) {
			displayInBinary(i);
			System.out.println();
		}
	}
	
	private static void auxBS(int d, int n, int[] out) {
		if(d == n) {
			System.out.println(Arrays.toString(out));
			return;
		}
		for(int i = 0; i <= 1; ++i) {
			out[d] = i;
			auxBS(d + 1, n, out);
		}
	}
	
	public static void displayBS3(int n) {
		int[] out = new int[n];
		auxBS(0, n, out);
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		displayBS3(n);
	}

}
