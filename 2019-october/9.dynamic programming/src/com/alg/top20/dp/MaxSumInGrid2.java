package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Random;

import sun.util.locale.provider.AuxLocaleProviderAdapter;

public class MaxSumInGrid2 {

	public static int maxSumInGrid1(int[][] in) {
		MyInteger gmax = new MyInteger(0);
		auxSumInGrid1(in.length - 1, in.length - 1, 0, gmax, in);
		return gmax.get();
	}

	private static void auxSumInGrid1(int i, int j, int psum, MyInteger gmax, int[][] in) {
		if (i < 0 || j < 0)
			return;
		if (i == 0 && j == 0) {
			gmax.set(Math.max(gmax.get(), psum + in[i][j]));
			return;
		}
		auxSumInGrid1(i - 1, j, in[i][j] + psum, gmax, in);
		auxSumInGrid1(i, j - 1, in[i][j] + psum, gmax, in);
	}

	public static int maxSumInGrid2(int[][] in) {
		return auxSumInGrid2(in.length - 1, in.length - 1, in);
	}

	private static int auxSumInGrid2(int i, int j, int[][] in) {
		if (i < 0 || j < 0)
			return 0;
		if (i == 0 && j == 0)
			return in[i][j];
		int leftSum = auxSumInGrid2(i - 1, j, in);
		int topSum = auxSumInGrid2(i, j - 1, in);
		return Math.max(leftSum, topSum) + in[i][j];
	}

	public static int maxSumInGrid31(int[][] in) {
		int[][] mem = new int[in.length][in.length];
		auxSumInGrid31(0, 0, in, mem);
		print2DArray(mem);
		return mem[0][0];
	}

	private static int auxSumInGrid31(int i, int j, int[][] in, int[][] mem) {
		if (i < 0 || j < 0)
			return 0;
		if (i == 0 && j == 0)
			return in[i][j];
		if (mem[i][j] != 0)
			return mem[i][j];
		int leftSum = auxSumInGrid31(i - 1, j, in, mem);
		int topSum = auxSumInGrid31(i, j - 1, in, mem);
		mem[i][j] = Math.max(leftSum, topSum) + in[i][j];
		return mem[i][j];
	}

	private static void print2DArray(int[][] in) {
		for (int[] tmp : in)
			System.out.println(Arrays.toString(tmp));
		System.out.println();
	}

	public static int maxSumInGrid32(int[][] in) {
		int[][] mem = new int[in.length + 1][in.length + 1];
		for (int i = 0; i <= in.length; ++i)
			mem[i][0] = 0;
		for (int j = 1; j <= in.length; ++j)
			mem[0][j] = 0;
		for (int i = 1; i <= in.length; ++i) {
			for (int j = 1; j <= in.length; ++j) {
				int topSum = mem[i - 1][j];
				int leftSum = mem[i][j - 1];
				mem[i][j] = Math.max(topSum, leftSum) + in[i - 1][j - 1];
			}
		}
		print2DArray(mem);
		traceOptimalRoute(in.length, in.length, mem, in);
		return mem[in.length][in.length];
	}

	private static void traceOptimalRoute(int i, int j, int[][] mem, int[][] in) {
		if (i <= 0 || j <= 0)
			return;
		if (mem[i - 1][j] > mem[i][j - 1]) {
			traceOptimalRoute(i - 1, j, mem, in);
			System.out.println("(" + (i-1) + "," + (j-1) + "," + in[i-1][j-1] + ")");
		} else {
			traceOptimalRoute(i, j - 1, mem, in);
			System.out.println("(" + (i-1) + "," + (j-1) + "," + in[i-1][j-1] + ")");
		}
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = new int[n][n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j)
				in[i][j] = r.nextInt(2 * n) + 1;
		}
		print2DArray(in);
		// System.out.println(maxSumInGrid1(in));
		// System.out.println(maxSumInGrid2(in));
		// System.out.println(maxSumInGrid31(in));
		System.out.println(maxSumInGrid32(in));

	}

}
