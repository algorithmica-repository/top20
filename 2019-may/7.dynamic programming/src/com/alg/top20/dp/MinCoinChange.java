package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Random;

public class MinCoinChange {

	public static int minCoinChange1(int[] in, int s) {
		MyInteger gmin = new MyInteger(Integer.MAX_VALUE);
		auxCoinChange1(0, s, 0, gmin, in);
		return gmin.get();
	}

	private static void auxCoinChange1(int i, int j, int psum, MyInteger gmin,
			int[] in) {
		if (j == 0) {
			if (psum < gmin.get())
				gmin.set(psum);
			return;
		}
		if (i == in.length || in[i] > j)
			return;
		auxCoinChange1(i, j - in[i], psum + 1, gmin, in);
		auxCoinChange1(i + 1, j, psum, gmin, in);
	}

	public static int minCoinChange2(int[] in, int s) {
		return auxCoinChange2(0, s, in);
	}

	private static int auxCoinChange2(int i, int j, int[] in) {
		if (j == 0)
			return 0;
		if (i == in.length || in[i] > j)
			return Integer.MAX_VALUE;
		int inclusive = auxCoinChange2(i, j - in[i], in);
		if (inclusive != Integer.MAX_VALUE)
			inclusive = inclusive + 1;
		int exclusive = auxCoinChange2(i + 1, j, in);
		return Math.min(inclusive, exclusive);
	}

	public static int minCoinChange3(int[] in, int s) {
		int[][] mem = new int[in.length][s + 1];
		auxCoinChange3(0, s, in, mem);
		return mem[0][s];
	}

	private static int auxCoinChange3(int i, int j, int[] in, int[][] mem) {
		if (j == 0)
			return 0;
		if (i == in.length || in[i] > j)
			return Integer.MAX_VALUE;
		if (mem[i][j] != 0)
			return mem[i][j];
		int inclusive = auxCoinChange2(i, j - in[i], in);
		if (inclusive != Integer.MAX_VALUE)
			inclusive = inclusive + 1;
		int exclusive = auxCoinChange2(i + 1, j, in);
		return mem[i][j] = Math.min(inclusive, exclusive);
	}

	public static int minCoinChange4(int[] in, int s) {
		int[][] mem = new int[in.length + 1][s + 1];
		for (int i = 0; i <= in.length; ++i)
			mem[i][0] = 0;
		for (int j = 1; j <= s; ++j)
			mem[in.length][j] = Integer.MAX_VALUE;
		for (int i = in.length - 1; i >= 0; --i) {
			for (int j = 1; j <= s; ++j) {
				if (in[i] > j)
					mem[i][j] = Integer.MAX_VALUE;
				else {
					int inclusive = mem[i][j - in[i]];
					if (inclusive != Integer.MAX_VALUE)
						inclusive = inclusive + 1;
					int exclusive = mem[i + 1][j];
					mem[i][j] = Math.min(inclusive, exclusive);
				}
			}
		}
		return mem[0][s];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(10) + 1;
		Arrays.sort(in);
		System.out.println(Arrays.toString(in));
		int s = Integer.parseInt(args[1]);
		System.out.println(s);
		System.out.println(minCoinChange1(in, s));
		System.out.println(minCoinChange2(in, s));
		System.out.println(minCoinChange3(in, s));
		System.out.println(minCoinChange4(in, s));

	}

}
