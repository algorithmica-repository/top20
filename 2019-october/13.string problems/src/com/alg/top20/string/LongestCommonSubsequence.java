package com.alg.top20.string;

public class LongestCommonSubsequence {
	
	public static int lcs1(String s1, String s2) {
		MyInteger gmax = new MyInteger(0);
		auxLcs1(0, 0, s1, s2, 0, gmax);
		return gmax.get();
	}
	private static void auxLcs1(int i, int j, String s1, String s2, int psum, MyInteger gmax) {
		if(i >= s1.length() || j >= s2.length()) {
			gmax.set(Math.max(psum, gmax.get()));
			return;
		}
		if(s1.charAt(i) == s2.charAt(j))
			auxLcs1(i+1, j+1, s1, s2, 1+psum, gmax);
		else {
			auxLcs1(i+1, j, s1, s2, psum, gmax);
			auxLcs1(i, j+1, s1, s2, psum, gmax);
		}			
	}
	
	public static int lcs2(String s1, String s2) {
		return auxLcs2(0, 0, s1, s2);
	}
	private static int auxLcs2(int i, int j, String s1, String s2) {
		if(i >= s1.length() || j >= s2.length()) return 0;
		if(s1.charAt(i) == s2.charAt(j))
			return auxLcs2(i+1, j+1, s1, s2) + 1;
		else {
			int skipleft = auxLcs2(i+1, j, s1, s2);
			int skipright = auxLcs2(i, j+1, s1, s2);
			return Math.max(skipleft, skipright);
		}			
	}
	
	public static int lcs31(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		auxLcs31(0, 0, s1, s2, mem);
		return mem[0][0];
	}
	private static int auxLcs31(int i, int j, String s1, String s2, int[][] mem) {
		if(i >= s1.length() || j >= s2.length()) return 0;
		if(mem[i][j] != 0) return mem[i][j];
		if(s1.charAt(i) == s2.charAt(j))
			mem[i][j] = auxLcs31(i+1, j+1, s1, s2, mem) + 1;
		else {
			int skipleft = auxLcs31(i+1, j, s1, s2,  mem);
			int skipright = auxLcs31(i, j+1, s1, s2, mem);
			mem[i][j] = Math.max(skipleft, skipright);
		}	
		return mem[i][j];
	}
	
	public static int lcs32(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] mem = new int[n+1][m+1];
		for(int  j = 0;  j <= m; ++j)
			mem[n][j] = 0;
		for(int i = 0; i <= n; ++i)
			mem[i][m] = 0;
		for(int i = n-1; i >= 0; --i) {
			for(int j = m-1; j >= 0; --j) {
				if(s1.charAt(i) == s2.charAt(j))
					mem[i][j] = mem[i+1][j+1] + 1;
				else {
					int skipleft = mem[i+1][j];
					int skipright = mem[i][j+1];
					mem[i][j] = Math.max(skipleft, skipright);
				}	
			}
		}
		return mem[0][0];
	}

	public static void main(String[] args) {
		//System.out.println(lcs1(args[0], args[1]));
		//System.out.println(lcs2(args[0], args[1]));
		System.out.println(lcs31(args[0], args[1]));
		System.out.println(lcs32(args[0], args[1]));

	}

}
