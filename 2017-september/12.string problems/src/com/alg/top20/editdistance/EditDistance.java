package com.alg.top20.editdistance;

import java.util.Arrays;
import java.util.Random;

public class EditDistance {

	//TC:O(3 ^ (m+n) )
	//SC:O(m+n)
	//Recursion
	public static int editDistance1(String s1, String s2) {
		return auxDistance1(s1.length(), s2.length(), s1, s2);
	}
	private static int auxDistance1(int i, int j, String s1, String s2) {
		if(i == 0) return j;
		if(j == 0) return i;
		if(s1.charAt(i-1) == s2.charAt(j-1))
			return auxDistance1(i-1, j-1, s1, s2);
		else {
			int icost = auxDistance1(i, j-1, s1, s2);
			int rcost = auxDistance1(i-1, j-1, s1, s2);
			int dcost = auxDistance1(i-1, j, s1, s2);
			return Math.min(Math.min(icost, rcost), dcost) + 1;
		}
	}
	
	//TC:O(mn)
	//SC:O(mn)
	//Memoizaton 
	public static int editDistance2(String s1, String s2) {
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		return auxDistance2(s1.length(), s2.length(), s1, s2, mem);
	}
	private static int auxDistance2(int i, int j, String s1, String s2, int[][] mem) {
		if(i == 0) return j;
		if(j == 0) return i;
		if(mem[i][j] != 0) return mem[i][j];
		if(s1.charAt(i-1) == s2.charAt(j-1)) {
			return mem[i][j] = auxDistance2(i-1, j-1, s1, s2, mem);
		}
		else {
			int icost = auxDistance2(i, j-1, s1, s2, mem);
			int rcost = auxDistance2(i-1, j-1, s1, s2, mem);
			int dcost = auxDistance2(i-1, j, s1, s2, mem);
			return mem[i][j] = Math.min(Math.min(icost, rcost), dcost) + 1;
		}
	}
	
	//TC:O(mn)
	//SC:O(mn)
	//Dynamic programing 
	public static int editDistance3(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] mem = new int[m+1][n+1];
		for(int j = 0; j <= n; ++j)
			mem[0][j] = j;
		for(int i = 1; i <= m; ++i)
			mem[i][0] = i;
		for(int i = 1; i <= m; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) 
					mem[i][j] = mem[i-1][j-1];
				else {
					int icost = mem[i][j-1];
					int dcost = mem[i-1][j];
					int rcost = mem[i-1][j-1];
					mem[i][j] = Math.min(Math.min(icost, rcost), dcost) + 1;	
				}
			}
		}
		for(int[] tmp: mem)
			System.out.println(Arrays.toString(tmp));
		return mem[m][n];
	}
	
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		String s1 = "";
		String s2 = "";
		
		Random r = new Random(100);
		for(int i =  0; i < m; ++i)
			s1 = s1 + (char)('a' + r.nextInt(26));
		for(int i =  0; i < n; ++i)
			s2 = s2 + (char)('a' + r.nextInt(26));
		System.out.println(s1);
		System.out.println(s2);
		//System.out.println(editDistance2(s1, s2));
		System.out.println(editDistance3(s1, s2));
	}

}
