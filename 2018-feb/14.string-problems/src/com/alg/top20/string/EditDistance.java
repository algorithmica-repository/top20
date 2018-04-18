package com.alg.top20.string;

import java.util.Arrays;

public class EditDistance {

	public static int editDistance1(String s1, String s2) {
		return auxDistance1(s1.length(),s2.length(),s1, s2);
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
	
	public static int editDistance2(String s1, String s2) {
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		auxDistance2(s1.length(),s2.length(),s1, s2, mem);
		//for(int[] tmp: mem)
		//	System.out.println(Arrays.toString(tmp));
		return mem[s1.length()][s2.length()];
	}
	private static int auxDistance2(int i, int j, String s1, String s2, int[][] mem) {
		if(i == 0) return j;
		if(j == 0) return i;
		if(mem[i][j] != 0) return mem[i][j];
		int res;
		if(s1.charAt(i-1) == s2.charAt(j-1))
			res =  auxDistance2(i-1, j-1, s1, s2, mem);
		else {
			int icost = auxDistance2(i, j-1, s1, s2, mem);
			int rcost = auxDistance2(i-1, j-1, s1, s2, mem);
			int dcost = auxDistance2(i-1, j, s1, s2, mem);
			res = Math.min(Math.min(icost, rcost), dcost) + 1;
		}
		mem[i][j] = res;
		return res;
	}
	
	public static int editDistance3(String s1, String s2) {
		int[][] mem = new int[s1.length()+1][s2.length()+1];
		//fill up base case values
		for(int j = 0; j <= s2.length(); ++j)
			mem[0][j] = j;
		for(int i = 1; i <= s1.length(); ++i)
			mem[i][0] = i;
		for(int i = 1; i <= s1.length(); ++i) {
			for(int j = 1; j <= s2.length(); ++j) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					mem[i][j] =  mem[i-1][j-1];
				else {
					int icost = mem[i][j-1];
					int rcost = mem[i-1][j-1];
					int dcost = mem[i-1][j];
					mem[i][j] = Math.min(Math.min(icost, rcost), dcost) + 1;
				}
			}
		}
		for(int[] tmp: mem)
			System.out.println(Arrays.toString(tmp));
		return mem[s1.length()][s2.length()];
	}
	public static void main(String[] args) {
		System.out.println(editDistance2(args[0], args[1]));
		System.out.println(editDistance3(args[0], args[1]));

	}

}
