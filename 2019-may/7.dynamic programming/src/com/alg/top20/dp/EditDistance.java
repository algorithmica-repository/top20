package com.alg.top20.dp;

public class EditDistance {

	public static int editDistance(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] mem = new int[m+1][n+1];
		for(int i = 0; i <= m; ++i)
			mem[i][n] = m - i;
		for(int j = 0; j <= n; ++j)
			mem[m][j] = n - j;
		for(int i = m-1; i >= 0; --i) {
			for(int j = n-1; j >= 0; --j) {
				if(s1.charAt(i) == s2.charAt(j))
					mem[i][j] = mem[i+1][j+1];
				else {
					int icost = mem[i][j+1] + 1;
					int dcost = mem[i+1][j] + 1;
					int rcost = mem[i+1][j+1] + 1;
					mem[i][j] = Math.min(icost, Math.min(dcost, rcost));
				}
			}
		}
		return mem[0][0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
