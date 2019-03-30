package com.alg.top20.string;

public class LCS {

	public static int lcs1(String s1, String s2) {
		MyInteger gmax = new MyInteger(0);
		auxlcs1(0, 0, s1, s2, 0, gmax);
		return gmax.get();
	}
	private static void auxlcs1(int i, int j, String s1, String s2, int csum, MyInteger gmax) {
		if(i == s1.length() || j == s2.length()) {
			gmax.set(Math.max(gmax.get(), csum));
			return;
		}
		if(s1.charAt(i) == s2.charAt(j))
			auxlcs1(i+1, j+1, s1, s2, 1+csum, gmax);
		else {
			auxlcs1(i+1, j, s1, s2, csum, gmax);
			auxlcs1(i, j+1, s1, s2, csum, gmax);
		}			
	}
	public static int lcs2(String s1, String s2) {
		return auxlcs2(0, 0, s1, s2);
	}
	private static int auxlcs2(int i, int j, String s1, String s2) {
		if(i == s1.length() || j == s2.length()) return 0;
		if(s1.charAt(i) == s2.charAt(j))
			return 1 + auxlcs2(i+1, j+1, s1, s2);
		else {
			int skipfirst = auxlcs2(i+1, j, s1, s2);
			int skipsecond = auxlcs2(i, j+1, s1, s2);
			return Math.max(skipfirst, skipsecond);
		}			
	}
	
	public static int lcs3(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		return auxlcs3(0, 0, s1, s2, mem);
	}
	private static int auxlcs3(int i, int j, String s1, String s2, int[][] mem) {
		int tmp;
		if(i == s1.length() || j == s2.length()) return 0;
		if(mem[i][j] != 0) return mem[i][j];
		if(s1.charAt(i) == s2.charAt(j))
			tmp = 1 + auxlcs2(i+1, j+1, s1, s2);
		else {
			int skipfirst = auxlcs2(i+1, j, s1, s2);
			int skipsecond = auxlcs2(i, j+1, s1, s2);
			tmp = Math.max(skipfirst, skipsecond);
		}
		mem[i][j] = tmp;
		return tmp;
	}
	
	public static int lcs4(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] mem = new int[m+1][n+1];
		for(int j = 0; j <= n; ++j)
			mem[m][j] = 0;
		for(int i = 0; i <= m; ++i)
			mem[i][n] = 0;
		for(int i = m-1; i >= 0; --i) {
			for(int j = n-1; j >= 0; --j) {
				if(s1.charAt(i) == s2.charAt(j))
					mem[i][j] = 1 + mem[i+1][j+1];
				else {
					int skipfirst = mem[i+1][j];
					int skipsecond = mem[i][j+1];
					mem[i][j]  = Math.max(skipfirst, skipsecond);
				}
			}
		}
		return mem[0][0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
