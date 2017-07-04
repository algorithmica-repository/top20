package com.alg.top20.dp;

import java.util.Random;


public class MaxPathSumInGrid {

	//TC:O(2 ^ 2n)   SC:O(n) ~ 2n
	public static int maxPathSum1(int[][] in) {
		MyInteger maxSum = new MyInteger();
		maxSum.set(0);
		auxPathSum1(1, 1, 0, in, maxSum);
		return maxSum.get();
	}
	private static void auxPathSum1(int i, int j, int csum, int[][] in, MyInteger maxSum) {
		if(i > in.length  || j > in.length) return;
		if(i == in.length && j == in.length) {
			//System.out.println(csum + in[i-1][j-1]);
			maxSum.set(Math.max(maxSum.get(), csum + in[i-1][j-1]));
			return;
		}
		auxPathSum1(i+1, j, in[i-1][j-1] + csum, in, maxSum);
		auxPathSum1(i, j+1, in[i-1][j-1] + csum, in, maxSum);
	}
	
	//TC:O(2 ^ 2n)   SC:O(n) ~ 2n
	public static int maxPathSum2(int[][] in) {
		return auxPathSum2(in.length, in.length, in);
	}
	private static int auxPathSum2(int i, int j, int[][] in ) {
		if(i == 0  || j == 0) return 0;
		int top_sum = auxPathSum2(i-1, j, in);
		int left_sum = auxPathSum2(i, j-1, in);
		return Math.max(top_sum, left_sum) + in[i-1][j-1];
	}
	
	//TC:O(n ^ 2)   SC:O(n^2) ~ 2n + n^2
	public static int maxPathSum3(int[][] in) {
		int[][] mem = new int[in.length+1][in.length+1];
		auxPathSum3(in.length, in.length, in, mem);
		return mem[in.length][in.length];
	}
	private static int auxPathSum3(int i, int j, int[][] in, int[][] mem) {
		if(i == 0  || j == 0) return 0;
		int top_sum = mem[i-1][j]!=0?mem[i-1][j]:auxPathSum3(i-1, j, in, mem);
		int left_sum = mem[i][j-1]!=0?mem[i][j-1]:auxPathSum3(i, j-1, in, mem);
		return mem[i][j] = Math.max(top_sum, left_sum) + in[i-1][j-1];
	}
	
	//TC:O(n ^ 2)   SC:O(n^2) ~ n^2
	public static int maxPathSum4(int[][] in) {
		int[][] mem = new int[in.length+1][in.length+1];
		for(int j = 0; j <= in.length; ++j) {
			mem[0][j] = 0;
			mem[j][0] = 0;
		}
		for(int i = 1; i <= in.length; ++i) {
			for(int j = 1; j <= in.length; ++j) {
				mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]) + in[i-1][j-1];
			}
		}
		printOptimalPath(in.length, in.length, mem);
		return mem[in.length][in.length];
	}
	
	//TC:O(n)   SC:O(n)
	private static void printOptimalPath(int i, int j, int[][] mem) {
		if(i == 0) return;
		if(mem[i-1][j] >= mem[i][j-1]) {
			printOptimalPath(i-1, j, mem);
			System.out.println("(" +i+","+j+")");
		} else {
			printOptimalPath(i, j-1, mem);
			System.out.println("(" +i+","+j+")");
		}
			
		
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[][] in = new int[n][n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				in[i][j] = r.nextInt(n) + 1;
			}
		}
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				System.out.print(in[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
		//System.out.println(maxPathSum1(in));
		//System.out.println(maxPathSum2(in));
		//System.out.println(maxPathSum3(in));
		System.out.println(maxPathSum4(in));
	}

}
