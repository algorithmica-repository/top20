package com.alg.top20.opt;

import java.util.Arrays;
import java.util.Random;

public class MaxNonConsecutiveSum {

	//naive approach
	public static int maxSum1(int[] in) {
		return 0;
	}
	
	//recursive approach
	public static int maxSum2(int[] in) {
		return auxSum2(in.length, in);
	}
	private static int auxSum2(int i, int[] in) {
		if(i <= 0) return 0;
		int inclusive = auxSum2(i-2, in) + in[i-1];
		int exclusive = auxSum2(i-1, in);
		return Math.max(inclusive, exclusive);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random(100);
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(10)+1;
		System.out.println(Arrays.toString(in));
		System.out.println(maxSum2(in));
	}

}
