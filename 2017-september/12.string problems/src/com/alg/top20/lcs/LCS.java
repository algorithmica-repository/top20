package com.alg.top20.lcs;

import java.util.Arrays;
import java.util.Random;

public class LCS {

	//TC:O(mn)
	//SC:O(mn)
	public static int lcs(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] mem = new int[m+1][n+1];
		for(int j = 0; j <= n; ++j)
			mem[0][j] = 0;
		for(int i = 1; i <= m; ++i)
			mem[i][0] = 0;
		for(int i = 1; i <= m; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(s1.charAt(i-1) == s2.charAt(j-1))
					mem[i][j] = 1 + mem[i-1][j-1];
				else 
					mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
			}
		}
		printMemory(mem);
		printSequence(mem, m, n, s1, s2);
		return mem[m][n];		
	}
	private static void printMemory(int[][] mem) {
		for(int[] tmp: mem)
			System.out.println(Arrays.toString(tmp));
	}
	private static void printSequence(int[][] mem, int i, int j, String s1, String s2) {
		if(i == 0 || j == 0) return;
		if(s1.charAt(i-1) == s2.charAt(j-1)) {
			printSequence(mem, i-1, j-1, s1, s2);
			System.out.println(s1.charAt(i-1));
		} else {
			if(mem[i-1][j] > mem[i][j-1])
				printSequence(mem, i-1, j, s1, s2);
			else
				printSequence(mem, i, j-1, s1, s2);
		}
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
		s1 = "abcda";
		s2 = "cdabac";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(lcs(s1, s2));
	}


}
