package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Random;

public class MaxNonConsSum {

	public static int maxNonConsSum1(int[] in) {
		MyInteger gmax = new MyInteger(0);
		auxNonConsSum1(0, 0, gmax, in);
		return gmax.get();
	}

	private static void auxNonConsSum1(int i, int psum, MyInteger gmax, int[] in) {
		if (i >= in.length) {
			if (psum > gmax.get())
				gmax.set(psum);
			return;
		}
		auxNonConsSum1(i + 2, psum + in[i], gmax, in);
		auxNonConsSum1(i + 1, psum, gmax, in);
	}

	public static int maxNonConsSum2(int[] in) {
		return auxNonConsSum2(0, in);
	}

	private static int auxNonConsSum2(int i, int[] in) {
		if (i >= in.length)
			return 0;
		int inclusive = auxNonConsSum2(i + 2, in);
		int exclusive = auxNonConsSum2(i + 1, in);
		return Math.max(inclusive + in[i], exclusive);
	}

	public static int maxNonConsSum3(int[] in) {
		int[] mem = new int[in.length];
		auxNonConsSum3(0, in, mem);
		return mem[0];
	}

	private static int auxNonConsSum3(int i, int[] in, int[] mem) {
		if (i >= in.length)
			return 0;
		if (mem[i] != 0)
			return mem[i];
		int inclusive = auxNonConsSum3(i + 2, in, mem);
		int exclusive = auxNonConsSum3(i + 1, in, mem);
		mem[i] = Math.max(inclusive + in[i], exclusive);
		return mem[i];
	}

	private static void traceOptimalPath(int[] in, int[] mem) {
		int i = 0;
		while (i < in.length) {
			if (mem[i] == mem[i + 1])
				i = i + 1;
			else {
				System.out.print(in[i] + "->");
				i = i + 2;
			}
		}
		System.out.println();
	}

	public static int maxNonConsSum4(int[] in) {
		int[] mem = new int[in.length + 2];
		mem[in.length + 1] = mem[in.length] = 0;
		for (int i = in.length - 1; i >= 0; --i) {
			int inclusive = mem[i + 2];
			int exclusive = mem[i + 1];
			mem[i] = Math.max(inclusive + in[i], exclusive);
		}
		traceOptimalPath(in, mem);
		return mem[0];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(10);
		System.out.println(Arrays.toString(in));
		// System.out.println(maxNonConsSum1(in));
		// System.out.println(maxNonConsSum2(in));
		// System.out.println(maxNonConsSum3(in));
		System.out.println(maxNonConsSum4(in));

	}

}
