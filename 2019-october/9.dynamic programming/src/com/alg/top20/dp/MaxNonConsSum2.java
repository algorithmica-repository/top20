package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Random;

public class MaxNonConsSum2 {

	public static int maxNonConsSum1(int[] in) {
		MyInteger gmax = new MyInteger(0);
		auxNonConsSum1(in, in.length - 1, 0, gmax);
		return gmax.get();
	}

	private static void auxNonConsSum1(int[] in, int i, int psum, MyInteger gmax) {
		if (i < 0) {
			gmax.set(Math.max(psum, gmax.get()));
			return;
		}
		auxNonConsSum1(in, i - 2, psum + in[i], gmax);
		auxNonConsSum1(in, i - 1, psum, gmax);
	}

	public static int maxNonConsSum2(int[] in) {
		return auxNonConsSum2(in, in.length - 1);
	}

	private static int auxNonConsSum2(int[] in, int i) {
		if (i < 0)
			return 0;
		int inclusive = auxNonConsSum2(in, i - 2);
		int exclusive = auxNonConsSum2(in, i - 1);
		return Math.max(inclusive + in[i], exclusive);
	}

	public static int maxNonConsSum31(int[] in) {
		int[] mem = new int[in.length];
		auxNonConsSum31(in, in.length - 1, mem);
		System.out.println(Arrays.toString(mem));
		return mem[in.length - 1];
	}

	private static int auxNonConsSum31(int[] in, int i, int[] mem) {
		if (i < 0)
			return 0;
		if (mem[i] != 0)
			return mem[i];
		int inclusive = auxNonConsSum31(in, i - 2, mem);
		int exclusive = auxNonConsSum31(in, i - 1, mem);
		mem[i] = Math.max(inclusive + in[i], exclusive);
		return mem[i];
	}

	public static int maxNonConsSum32(int[] in) {
		int[] mem = new int[in.length+2];
		mem[0] =  0;
		mem[1] = 0;
		for (int i = 2; i < mem.length; ++i) {
			int inclusive = mem[i - 2] + in[i-2];
			int exclusive = mem[i - 1];
			mem[i] = Math.max(inclusive, exclusive);
		}
		System.out.println(Arrays.toString(mem));
		tracePath(mem, in, mem.length - 1);
		System.out.println();
		return mem[mem.length-1];
	}

	private static void tracePath(int[] mem, int[] in, int i) {
		if (i < 2)
			return;	
		if (mem[i] == mem[i - 1]) {
			tracePath(mem, in, i - 1);
		} else {
			tracePath(mem, in, i - 2);
			System.out.print("(" + in[i-2] + "," + (i-2) + ")" + "->");
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		System.out.println(Arrays.toString(in));
		//System.out.println(maxNonConsSum1(in));
		//System.out.println(maxNonConsSum2(in));
		//System.out.println(maxNonConsSum31(in));
		System.out.println(maxNonConsSum32(in));

	}

}
