package com.alg.top20.opt;

import java.util.Arrays;
import java.util.Random;

public class MaxNonConsecutiveSum {

	//naive approach
	public static int maxSum1(int[] in) {
		MyInteger max = new MyInteger(0);
		auxSum1(in.length, in, 0, max);
		return max.get();
	}
	private static void auxSum1(int i, int[] in, int csum, MyInteger max) {
		if(i == 0) {
			max.set(Math.max(max.get(),csum));
			return;
		}
		if(i == 1) {
			max.set(Math.max(max.get(),csum+in[0]));
			return;
		}
		auxSum1(i-2, in, csum + in[i-1], max);
		auxSum1(i-1, in, csum, max);
	}
	//recursive approach
	public static int maxSum2(int[] in) {
		return auxSum2(in.length, in);
	}
	private static int auxSum2(int i, int[] in) {
		if(i == 0) return 0;
		if(i == 1) return in[0];
		int inclusive = auxSum2(i-2, in) + in[i-1];
		int exclusive = auxSum2(i-1, in);
		return Math.max(inclusive, exclusive);
	}
	//memoization
	public static int maxSum3(int[] in) {
		int[] mem = new int[in.length+1];
		auxSum3(in.length, in, mem);
		System.out.println(Arrays.toString(mem));
		return mem[in.length];
	}
	private static int auxSum3(int i, int[] in, int[] mem) {
		if(i == 0) return 0;
		if(i == 1) return in[0];
		if(mem[i] != 0) return mem[i];
		int inclusive = auxSum3(i-2, in, mem) + in[i-1];
		int exclusive = auxSum3(i-1, in, mem);
		mem[i] = Math.max(inclusive, exclusive);
		return mem[i];
	}
	
	//dynamic programming
	public static int maxSum4(int[] in) {
		int[] mem = new int[in.length+1];
		mem[0] = 0;
		mem[1] = in[0];
		for(int i = 2; i <= in.length; ++i)
			mem[i] = Math.max(mem[i-2] + in[i-1], mem[i-1]);
		//System.out.println(Arrays.toString(mem));
		return mem[in.length];
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random(100);
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(10)+1;
		//System.out.println(Arrays.toString(in));
		//System.out.println(maxSum2(in));
		//System.out.println(maxSum3(in));
		System.out.println(maxSum4(in));
		System.out.println(maxSum1(in));
	}

}
