package com.alg.top20.selection;
import java.util.Arrays;
import java.util.Random;


public class Shuffle {
	
	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in [j];
		in[j] = tmp;
	}
	public static void shuffle1(int[] in) {
		Random r = new Random();
		for(int i = 0; i < in.length; ++i) {
			int rind = r.nextInt(in.length);
			swap(in, i, rind);
		}
	}
	//TC:O(n)  SC:O(1)
	public static void shuffle2(int[] in) {
		Random r = new Random();
		for(int i = in.length-1; i > 0; --i) {
			int rind = r.nextInt(i+1);
			swap(in, i, rind);
		}
	}
	
	public static void main(String[] args) {
		int[] in = { 1, 2, 3};
		shuffle2(in);
		System.out.println(Arrays.toString(in));
	}
}
