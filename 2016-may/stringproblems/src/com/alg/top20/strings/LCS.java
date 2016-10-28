package com.alg.top20.strings;

public class LCS {

	private static int auxlcs1(int i, int j, String s1, String s2) {
		if(i < 0 || j < 0) return 0;
		if(s1.charAt(i) == s2.charAt(j)) {
			return 1 + auxlcs1(i-1, j-1, s1, s2);
		} else {
			int sub1 = auxlcs1(i-1, j, s1, s2);
			int sub2 = auxlcs1(i, j-1, s1, s2);
			return Math.max(sub1, sub2);
		}
	}
	public static int lcs1(String s1, String s2) {
		return auxlcs1(s1.length()-1, s2.length()-1, s1, s2);
	}
	
	private static int auxlcs2(int i, int j, String s1, String s2, int[][] mem) {
		if(i < 0 || j < 0) return 0;
		if(mem[i][j] != -1) return mem[i][j];
		if(s1.charAt(i) == s2.charAt(j)) {
			return mem[i][j] = 1 + auxlcs2(i-1, j-1, s1, s2, mem);
		} else {
			int sub1 = auxlcs2(i-1, j, s1, s2, mem);
			int sub2 = auxlcs2(i, j-1, s1, s2, mem);
			return mem[i][j] = Math.max(sub1, sub2);
		}
	}
	public static int lcs2(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		for(int i = 0; i <  s1.length(); ++i) {
			for(int j = 0; j < s2.length(); ++j) {
				mem[i][j] = -1;
			}
		}
		return auxlcs2(s1.length()-1, s2.length()-1, s1, s2, mem);
	}
	
	private static int cost(int i, int j, int[][] mem) {
		if(i < 0 || j < 0)  	
			return 0;
		return mem[i][j];
	}
	
	public static int lcs3(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		for(int i = 0; i <  s1.length(); ++i) {
			for(int j = 0; j < s2.length(); ++j) {
				if(s1.charAt(i) == s2.charAt(j)) {
					mem[i][j] = 1 + cost(i-1,j-1,mem);
				} else {
					int sub1 = cost(i-1,j,mem);
					int sub2 = cost(i, j-1, mem);
					mem[i][j] = Math.max(sub1, sub2);
				}
			}
		}
		return mem[s1.length()-1][s2.length()-1];
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		String s1 = "";
		String s2 = "";
		for(int i = 0; i < n; ++i)
			s1 = s1 + 'a';
		for(int i = 0; i < m; ++i)
			s2 = s2 + 'z';
		System.out.println(lcs3(s1, s2));

	}

}
