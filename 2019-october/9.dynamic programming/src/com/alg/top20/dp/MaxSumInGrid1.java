package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Random;

public class MaxSumInGrid1 {

	public static int maxSumInGrid1(int[][] in) {
		MyInteger gmax = new MyInteger(0);
		auxSumInGrid1(0, 0, 0, gmax, in);
		return gmax.get();
	}

	private static void auxSumInGrid1(int i, int j, int psum, MyInteger gmax, int[][] in) {
		if (i >= in.length || j >= in.length)
			return;
		if (i == in.length - 1 && j == in.length - 1) {
			gmax.set(Math.max(gmax.get(), psum + in[i][j]));
			return;
		}
		auxSumInGrid1(i + 1, j, in[i][j] + psum, gmax, in);
		auxSumInGrid1(i, j + 1, in[i][j] + psum, gmax, in);
	}

	public static int maxSumInGrid2(int[][] in) {
		return auxSumInGrid2(0, 0, in);
	}

	private static int auxSumInGrid2(int i, int j, int[][] in) {
		if (i >= in.length || j >= in.length)
			return 0;
		if (i == in.length - 1 && j == in.length - 1)
			return in[i][j];
		int downSum = auxSumInGrid2(i + 1, j, in);
		int rightSum = auxSumInGrid2(i, j + 1, in);
		return Math.max(downSum, rightSum) + in[i][j];
	}

	public static int maxSumInGrid31(int[][] in) {
		int[][] mem = new int[in.length][in.length];
		auxSumInGrid31(0, 0, in, mem);
		print2DArray(mem);
		return mem[0][0];
	}

	private static int auxSumInGrid31(int i, int j, int[][] in, int[][] mem) {
		if (i >= in.length || j >= in.length)
			return 0;
		if (i == in.length - 1 && j == in.length - 1)
			return in[i][j];
		if (mem[i][j] != 0)
			return mem[i][j];
		int downSum = auxSumInGrid31(i + 1, j, in, mem);
		int rightSum = auxSumInGrid31(i, j + 1, in, mem);
		mem[i][j] = Math.max(downSum, rightSum) + in[i][j];
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
			mem[i][in.length] = 0;
		for (int j = 1; j <= in.length; ++j)
			mem[in.length][j] = 0;
		for (int i = in.length - 1; i >= 0; --i) {
			for (int j = in.length - 1; j >= 0; --j) {
				int downSum = mem[i + 1][j];
				int rightSum = mem[i][j + 1];
				mem[i][j] = Math.max(downSum, rightSum) + in[i][j];
			}
		}
		print2DArray(mem);
		traceOptimalRoute(mem, in);
		return mem[0][0];
	}

	private static void traceOptimalRoute(int[][] mem, int[][] in) {
		int i = 0, j = 0;

		while (i < in.length && j < in.length) {
			if (mem[i + 1][j] > mem[i][j + 1]) {
				System.out.println("(" + i + "," + j + "," + in[i][j] + ")");
				i = i + 1;
			} else {
				System.out.println("(" + i + "," + j + "," + in[i][j] + ")");
				j = j + 1;
			}
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
		//System.out.println(maxSumInGrid31(in));
		System.out.println(maxSumInGrid32(in));

	}

}
