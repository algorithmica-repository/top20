package com.alg.top20.string;

public class LongestCommonSubsequence {

	public static int longCommonSubseq(String s1, String s2) {
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		for(int j = 0; j <= s2.length(); ++j)
			mem[0][j] = 0;
		for(int i = 1; i <= s1.length(); ++i)
			mem[i][0] = 0;
		for(int i = 1; i <= s1.length(); ++i) {
			for(int j = 1; j <= s2.length(); ++j) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					mem[i][j] = 1 + mem[i-1][j-1];
				else 
					mem[i][j] = Math.max(mem[i][j-1], mem[i-1][j]);
			}
		}
		return mem[s1.length()][s2.length()];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
