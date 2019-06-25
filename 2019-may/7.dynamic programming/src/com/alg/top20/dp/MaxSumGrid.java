package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Random;

public class MaxSumGrid {

	public static int maxSumGrid1(int[][] in) {
		MyInteger gmax = new MyInteger(0);
		auxSumGrid1(0, 0, 0, gmax, in);
		return gmax.get();
	}

	private static void auxSumGrid1(int i, int j, int psum, MyInteger gmax,
			int[][] in) {
		if (i == in.length || j == in.length)
			return;
		if (i == in.length - 1 && j == in.length - 1) {
			if (psum + in[i][j] > gmax.get())
				gmax.set(psum + in[i][j]);
			return;
		}
		auxSumGrid1(i + 1, j, psum + in[i][j], gmax, in);
		auxSumGrid1(i, j + 1, psum + in[i][j], gmax, in);
	}

	public static int maxSumGrid2(int[][] in) {
		return auxSumGrid2(0, 0, in);
	}

	private static int auxSumGrid2(int i, int j, int[][] in) {
		if (i == in.length || j == in.length)
			return 0;
		int bsum = auxSumGrid2(i + 1, j, in);
		int rsum = auxSumGrid2(i, j + 1, in);
		return Math.max(bsum, rsum) + in[i][j];
	}

	public static int maxSumGrid3(int[][] in) {
		int[][] mem = new int[in.length][in.length];
		auxSumGrid3(0, 0, in, mem);
		return mem[0][0];
	}

	private static int auxSumGrid3(int i, int j, int[][] in, int[][] mem) {
		if (i == in.length || j == in.length)
			return 0;
		if (mem[i][j] != 0)
			return mem[i][j];
		int bsum = auxSumGrid3(i + 1, j, in, mem);
		int rsum = auxSumGrid3(i, j + 1, in, mem);
		return mem[i][j] = Math.max(bsum, rsum) + in[i][j];
	}

	private static void traceOptimalPath(int[][] mem) {
		int i = 0, j = 0;
		while (i < mem.length-1 && j < mem.length-1) {
			System.out.println("(" + i + "," + j + ")->");
			if (mem[i + 1][j] > mem[i][j + 1])
				i = i + 1;
			else
				j = j + 1;
		}
	}

	public static int maxSumGrid4(int[][] in) {
		int[][] mem = new int[in.length + 1][in.length + 1];
		for (int i = 0; i < in.length; ++i) {
			mem[in.length][i] = 0;
			mem[i][in.length] = 0;
		}
		for (int i = in.length - 1; i >= 0; --i) {
			for (int j = in.length - 1; j >= 0; --j) {
				int bsum = mem[i + 1][j];
				int rsum = mem[i][j + 1];
				mem[i][j] = Math.max(bsum, rsum) + in[i][j];
			}
		}
		traceOptimalPath(mem);
		return mem[0][0];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = new int[n][n];
		Random r = new Random();
		for(int i = 0; i < n; ++i)
			for(int j = 0; j < n; ++j)
				in[i][j] = r.nextInt(10);
		//for(int[] tmp:in)
		//	System.out.println(Arrays.toString(tmp));
		//System.out.println(maxSumGrid1(in));
		//System.out.println(maxSumGrid2(in));
		//System.out.println(maxSumGrid3(in));
		System.out.println(maxSumGrid4(in));

	}

}
