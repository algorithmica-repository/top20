package com.alg.top20.opt;

import java.util.Arrays;
import java.util.Random;

public class MaxGridSum {

	//naive 
	public static int maxSum1(int[][] in) {
		MyInteger max = new MyInteger(0);
		auxSum1(in.length, in.length, in, 0, max);
		return max.get();
	}
	private static void auxSum1(int i, int j, int[][] in, int csum, MyInteger max) {
		if(i < 1 || j < 1) return;
		if(i == 1 && j == 1) {
			max.set(Math.max(max.get(), csum + in[0][0]));
			return;
		}
		auxSum1(i-1, j, in, csum + in[i-1][j-1], max);
		auxSum1(i, j-1, in, csum + in[i-1][j-1], max);
	}
	//recursion
	public static int maxSum2(int[][] in) {
		return auxSum2(in.length, in.length, in);
	}
	private static int auxSum2(int i, int j, int[][] in) {
		if(i < 1 || j < 1) return 0;
		int top = auxSum2(i-1, j, in);
		int left = auxSum2(i, j-1, in);
		return Math.max(top, left) + in[i-1][j-1];
	}
	
	//memoization
	public static int maxSum3(int[][] in) {
		int[][] mem = new int[in.length+1][in.length+1];
		return auxSum3(in.length, in.length, in, mem);
	}
	private static int auxSum3(int i, int j, int[][] in, int[][] mem) {
		if(i < 1 || j < 1) return 0;
		if(mem[i][j] != 0) return mem[i][j];
		int top = auxSum3(i-1, j, in, mem);
		int left = auxSum3(i, j-1, in, mem);
		mem[i][j] = Math.max(top, left) + in[i-1][j-1];
		return mem[i][j];
	}
	
	//dynamic programming
	public static int maxSum4(int[][] in) {
		int[][] mem = new int[in.length+1][in.length+1];
		for(int i = 0; i <= in.length; ++i)
			mem[i][0] = mem[0][i] = 0;
		for(int i = 1; i <= in.length; ++i) {
			for(int j = 1; j <= in.length; ++j) {
				int top = mem[i-1][j];
				int left = mem[i][j-1];
				mem[i][j] = Math.max(top, left) + in[i-1][j-1];
			}
		}
		System.out.println();
		for(int[] tmp:mem)
			System.out.println(Arrays.toString(tmp));
		retrieveOptimalPath(in.length, in.length, mem);
		System.out.println("(" + in.length + "," + in.length + ")");

		return mem[in.length][in.length];
	}
	
	private static void retrieveOptimalPath(int i, int j, int[][] mem) {
		if(i == 1 && j == 1) return;
		if(mem[i-1][j] > mem[i][j-1]) {
			retrieveOptimalPath(i-1, j, mem);
			System.out.print("(" + (i-1) + "," + j + ")->");
		} else {
			retrieveOptimalPath(i, j-1, mem);
			System.out.print("(" + i + "," + (j-1) + ")->");
		}			
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = new int[n][n];
		Random r = new Random();
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				in[i][j] = r.nextInt(10) + 1;
			}
		}
		for(int[] tmp:in)
			System.out.println(Arrays.toString(tmp));
		//System.out.println(maxSum2(in));
		//System.out.println(maxSum1(in));
		System.out.println(maxSum4(in));
	}

}
