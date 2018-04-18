package com.alg.top20.string;

import java.util.Arrays;

public class LCS {

	public static int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] mem = new int[m+1][n+1];
		for(int i = 0; i <= m; ++i)
			mem[i][0] = 0;
		for(int j = 1; j <= n; ++j)
			mem[0][j] = 0;
		for(int i = 1; i <= m; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(s1.charAt(i-1) == s2.charAt(j-1) )
					mem[i][j] = mem[i-1][j-1] + 1;
				else {
					mem[i][j] = Math.max(mem[i][j-1], mem[i-1][j]);
				}
			}
		}
		for(int[] tmp: mem)
			System.out.println(Arrays.toString(tmp));
		displayPath(mem, m, n, s1, s2);
		System.out.println();
		return mem[m][n];
	}
	private static void displayPath(int[][] mem, int i, int j, String s1, String s2) {
		if(i == 0 || j == 0) return;
		if(s1.charAt(i-1) == s2.charAt(j-1)) {
			displayPath(mem, i-1, j-1, s1, s2);
			System.out.print(s1.charAt(i-1));
		} else {
			if(mem[i-1][j] > mem[i][j-1])
				displayPath(mem, i-1, j, s1, s2);
			else
				displayPath(mem, i, j-1, s1, s2);
		}
	}
	public static void main(String[] args) {
		System.out.println(lcs(args[0], args[1]));
	}

}
