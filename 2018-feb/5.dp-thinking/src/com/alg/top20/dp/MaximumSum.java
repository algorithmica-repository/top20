package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Random;

public class MaximumSum {

	private static int auxSum1(int i, int[] in) {
		if(i <= 0) return 0;
		int inclSum = auxSum1(i-2, in) + in[i-1];
		int exclSum = auxSum1(i-1, in);
		return Math.max(inclSum, exclSum);
	}
	public static int maxSum1(int[] in) {
		return auxSum1(in.length, in);
	}
	
	private static int auxSum2(int i, int[] in, int[] mem) {
		if(i <= 0) return 0;
		if(mem[i] > 0) return mem[i];
		int inclSum = auxSum2(i-2, in, mem) + in[i-1];
		int exclSum = auxSum2(i-1, in, mem);
		mem[i] = Math.max(inclSum, exclSum);
		return mem[i];
	}
	public static int maxSum2(int[] in) {
		int[] mem = new int[in.length+1];
		return auxSum2(in.length, in, mem);
	}
	
	public static int maxSum3(int[] in) {
		int[] mem = new int[in.length+1];
		mem[0] = 0;
		mem[1] = in[0];
		for(int i = 2; i <= in.length; ++i) {
			int inclSum = mem[i-2] + in[i-1];
			int exclSum = mem[i-1];
			mem[i] = Math.max(inclSum, exclSum);
		}			
		return mem[in.length];
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random(100);
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n);
		System.out.println(Arrays.toString(in));
		System.out.println(maxSum2(in));

	}

}
