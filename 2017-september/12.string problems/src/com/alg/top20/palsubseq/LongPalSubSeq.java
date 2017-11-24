package com.alg.top20.palsubseq;

import java.util.Arrays;

public class LongPalSubSeq {

	//TC:O(2^n * n)
	//SC:O(1)
	//Adhoc
	public static int longPalSubseq1(String s) {
		//TODO
		return 0;
	}
	//TC:O(n^2)
	//SC:O(n^2) -> O(n)
	//Recursion->Dynamic programming
	public static int longPalSubseq2(String s) {
		int n = s.length();
		int[][] mem = new int[n+1][n+1];
		for(int i = 1; i <= n; ++i)
			mem[i][i] = 1;
		for(int i = n-1; i >= 1; --i) {
			for(int j = i+1; j <= n; ++j) {
				if(s.charAt(i-1) == s.charAt(j-1))
					mem[i][j] = 2  + mem[i+1][j-1];
				else 
					mem[i][j] = Math.max(mem[i+1][j], mem[i][j-1]);
			}
		}	
		printMemory(mem);
		printSequence(mem, 1, n, s);
		System.out.println();
		return mem[1][n];
	}
	
	private static void printMemory(int[][] mem) {
		for(int[] tmp: mem)
			System.out.println(Arrays.toString(tmp));
	}
	//TODO:try to build first half of the result
	private static void printSequence(int[][] mem, int i, int j, String s) {
		if(i > j) return;
		if(s.charAt(i-1) == s.charAt(j-1)) {
			//System.out.print(s.charAt(i-1));
			printSequence(mem, i+1, j-1, s);
			System.out.print(s.charAt(i-1));
		} else {
			if(mem[i+1][j] > mem[i][j-1])
				printSequence(mem, i+1, j, s);
			else
				printSequence(mem, i, j-1, s);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(longPalSubseq2(args[0]));
	}

}
