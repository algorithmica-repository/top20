package com.alg.top20.dp.twod;

import java.util.Random;

public class MaxSumInGrid {
	//TC:O(2 ^ 2n)
	//SC:O(n)
	//Adhoc: explore all paths
	public static int maxSum1(int[][] in) {
		MyInteger maxSum = new MyInteger(0);
		auxSum1(in, 0, 0, 0, maxSum);
		return maxSum.get();
	}
	private static void auxSum1(int[][] in, int i, int j, int pathSum, MyInteger maxSum) {
		if(i >= in.length || j >= in.length) return;
		if(i == in.length-1 && j == in.length-1) {
			maxSum.set(Math.max(maxSum.get(), pathSum + in[i][j]));
			return;
		}
		auxSum1(in, i, j+1, pathSum + in[i][j], maxSum);
		auxSum1(in, i+1, j, pathSum + in[i][j], maxSum);
	}
	
	//TC:O(2 ^ 2n)
	//SC:O(n)
	//Recursion
	public static int maxSum2(int[][] in) {
		return auxSum2(in, in.length, in.length);
	}
	private static int auxSum2(int[][] in, int i, int j) {
		if(i <= 0 || j <= 0) return 0;
		int topSum = auxSum2(in, i-1, j);
		int leftSum = auxSum2(in, i, j-1);
		return Math.max(topSum, leftSum) + in[i-1][j-1];
	}
	
	//TC:O(n ^ 2)
	//SC:O(n ^ 2)
	//Memoization : Recursion with memory
	public static int maxSum3(int[][] in) {
		int[][] mem = new int[in.length+1][in.length+1];
		return auxSum3(in, in.length, in.length, mem);
	}
	private static int auxSum3(int[][] in, int i, int j, int[][] mem) {
		if(i <= 0 || j <= 0) return 0;
		if(mem[i][j] != 0) return mem[i][j];
		int topSum = auxSum3(in, i-1, j, mem);
		int leftSum = auxSum3(in, i, j-1, mem);
		mem[i][j] = Math.max(topSum, leftSum) + in[i-1][j-1];
		return mem[i][j];
	}
	
	//TC:O(n ^ 2)
	//SC:O(n ^ 2)
	//Dynamic programming
	public static int maxSum4(int[][] in) {
		int[][] mem = new int[in.length+1][in.length+1];
		for(int i = 1; i <= in.length; ++i) {
			for(int j = 1; j <= in.length; ++j) {
				mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]) + in[i-1][j-1];
			}
		}
		printSequence(mem, in.length, in.length);
		return mem[in.length][in.length];
	}
	
	private static void printSequence(int[][] mem, int i, int j) {
		if(i == 1 && j == 1) return;
		if(mem[i-1][j] > mem[i][j-1]) {
			printSequence(mem, i-1, j);
			System.out.println("(" + (i-1) + "," + j + ")");
		} else {
			printSequence(mem, i, j-1);
			System.out.println("(" + i + "," + (j-1) + ")");
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		int[][] in = new int[n][n];
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				in[i][j] = r.nextInt(2*n) + 1;
				System.out.print(in[i][j] + " ");
			}
			System.out.println();
		}
		//System.out.println(maxSum3(in));
		System.out.println(maxSum4(in));
	}


}
