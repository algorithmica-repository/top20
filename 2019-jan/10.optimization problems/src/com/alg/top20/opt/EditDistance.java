package com.alg.top20.opt;

import java.util.Arrays;

public class EditDistance {

	// complete search
	// TC:O(3 ^ m+n) SC:O(m+n)
	public static int editDistance1(String s1, String s2) {
		MyInteger gmin = new MyInteger(Integer.MAX_VALUE);
		auxDistance1(0, 0, 0, s1, s2, gmin);
		return gmin.get();
	}

	private static void auxDistance1(int i, int j, int csum, String s1, String s2, MyInteger gmin) {
		if (i == s1.length()) {
			gmin.set(Math.min(gmin.get(), csum+s2.length()-j));
			return;
		}
		if(j == s2.length()) {
			gmin.set(Math.min(gmin.get(), csum+s1.length()-i));
			return;
		}
		if (s1.charAt(i) != s2.charAt(j)) {
			auxDistance1(i + 1, j + 1, csum+1, s1, s2, gmin);
			auxDistance1(i, j + 1, csum+1, s1, s2, gmin);
			auxDistance1(i + 1, j, csum+1, s1, s2, gmin);
		} else
			 auxDistance1(i + 1, j + 1, csum, s1, s2, gmin);

	}

	// optimal recursion ~ recursion with optimal substructure
	// TC:O(3 ^ m+n) SC:O(m+n)
	public static int editDistance2(String s1, String s2) {
		return auxDistance2(0, 0, s1, s2);
	}

	private static int auxDistance2(int i, int j, String s1, String s2) {
		if (i == s1.length())
			return s2.length() - j;
		if (j == s2.length())
			return s1.length() - i;
		if (s1.charAt(i) != s2.charAt(j)) {
			int rcost = auxDistance2(i + 1, j + 1, s1, s2);
			int icost = auxDistance2(i, j + 1, s1, s2);
			int dcost = auxDistance2(i + 1, j, s1, s2);
			return Math.min(dcost, Math.min(rcost, icost)) + 1;
		} else
			return auxDistance2(i + 1, j + 1, s1, s2);
	}

	// memory fillup with recursion
	// TC:O(mn) SC:O(mn)
	public static int editDistance3(String s1, String s2) {
		int[][] mem = new int[s1.length()][s2.length()];
		for(int i = 0; i < s1.length(); ++i) 
			for(int j = 0; j < s2.length(); ++j) 
				mem[i][j] = -1;
		return auxDistance3(0, 0, s1, s2, mem);
	}

	private static int auxDistance3(int i, int j, String s1, String s2, int[][] mem) {
		if (i == s1.length())
			return s2.length() - j;
		if (j == s2.length())
			return s1.length() - i;
		if(mem[i][j] != -1) return mem[i][j];
		if (s1.charAt(i) != s2.charAt(j)) {
			int rcost = auxDistance3(i + 1, j + 1, s1, s2, mem);
			int icost = auxDistance3(i, j + 1, s1, s2, mem);
			int dcost = auxDistance3(i + 1, j, s1, s2, mem);
			mem[i][j] = Math.min(dcost, Math.min(rcost, icost)) + 1;
			return mem[i][j];
		} else {
			mem[i][j] = auxDistance3(i + 1, j + 1, s1, s2, mem);
			return mem[i][j];
		}
	}
	
	// memory fillup without recursion
	// TC:O(mn) SC:O(mn)
	public static int editDistance4(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] mem = new int[m + 1][n + 1];
		for (int j = 0; j <= n; ++j) 
			mem[m][j] = n-j;
		for (int i = 0; i <= m; ++i) 
			mem[i][n] = m-i;

		for (int i = m - 1; i >= 0; --i) {
			for (int j = n - 1; j >= 0; --j) {
				if (s1.charAt(i) != s2.charAt(j)) {
					int rcost = mem[i + 1][j + 1];
					int icost = mem[i][j + 1];
					int dcost = mem[i + 1][j];
					mem[i][j] = Math.min(dcost, Math.min(rcost, icost)) + 1;
				} else 
					mem[i][j] = mem[i + 1][j + 1];
			}
		}
		return mem[0][0];
	}

	

	public static void main(String[] args) {
		String s1 = args[0];
		String s2 = args[1];
		//System.out.println(editDistance1(s1, s2));
		//System.out.println(editDistance2(s1, s2));
		System.out.println(editDistance3(s1, s2));
		System.out.println(editDistance4(s1, s2));
	}

}
