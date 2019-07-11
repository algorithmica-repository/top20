package com.alg.top20.string;

import java.util.Arrays;

public class LongestCommonSubseq {

	private static void trace_optimal_solution(int[][] mem, String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (s1.charAt(i) == s2.charAt(j)) {
				System.out.print(s1.charAt(i));
				++i;
				++j;
			} else if (mem[i + 1][j] > mem[i][j + 1])
				++i;
			else
				++j;
		}
		System.out.println();
	}

	public static int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] mem = new int[m + 1][n + 1];
		for (int j = 0; j <= n; ++j)
			mem[m][j] = 0;
		for (int i = 0; i <= m; ++i)
			mem[i][n] = 0;
		for (int i = m - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				if (s1.charAt(i) == s2.charAt(j))
					mem[i][j] = 1 + mem[i + 1][j + 1];
				else
					mem[i][j] = Math.max(mem[i + 1][j], mem[i][j + 1]);
			}
		}
		trace_optimal_solution(mem, s1, s2);
		for(int[] tmp: mem)
			System.out.println(Arrays.toString(tmp));
		return mem[0][0];
	}

	public static void main(String[] args) {
		System.out.println(lcs(args[0], args[1]));
	}

}
