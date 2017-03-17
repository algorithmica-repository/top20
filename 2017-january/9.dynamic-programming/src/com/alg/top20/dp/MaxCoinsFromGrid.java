package com.alg.top20.dp;

import java.util.Random;

public class MaxCoinsFromGrid {
	private static int maxSum = 0;

	//TC:O(2 ^n) SC:O(n)
	private static void auxMaxCoins1(int i, int j, int psum, int[][] in) {
		if(i >= in.length || j >= in.length) return;
		if(i == in.length-1 && j == in.length-1) {
			//System.out.println(psum + in[i][j]);
			maxSum = Math.max(psum+in[i][j], maxSum);
			return;
		}
		auxMaxCoins1(i+1, j, psum +in[i][j],in);
		auxMaxCoins1(i, j+1, psum +in[i][j], in);
	}	
	public static int getMaxCoins1(int [][] in) {
		auxMaxCoins1(0, 0, 0, in);
		return maxSum;
	}
	
	//TC:O(2 ^n) SC:O(n)
	private static int auxMaxCoins2(int i, int j, int[][] in) {
		if(i < 0 || j < 0) return 0;
		int top = auxMaxCoins2(i-1, j, in);
		int left = auxMaxCoins2(i, j-1, in);
		return Math.max(top, left) + in[i][j];
	}
	public static int getMaxCoins2(int [][] in) {
		return auxMaxCoins2(in.length-1, in.length-1, in);
	}
	
	//TC:O(n^2) SC:O(n) n + n[recursive stack + memory]
	private static int auxMaxCoins3(int i, int j, int[][] in, int[][] mem) {
		if(i < 0 || j < 0) return 0;
		if(mem[i][j] != 0) return mem[i][j];
		int top = auxMaxCoins3(i-1, j, in, mem);
		int left = auxMaxCoins3(i, j-1, in, mem);
		return mem[i][j] = Math.max(top, left) + in[i][j];
	}
	public static int getMaxCoins3(int [][] in) {
		int[][] mem = new int[in.length][in.length];
		return auxMaxCoins3(in.length-1, in.length-1, in, mem);
	}
	
	//TC:O(n^2) SC:O(n) only  for memory
	public static int getMaxCoins4(int [][] in) {
		int[][] mem = new int[in.length][in.length];
		for(int i = 0; i < in.length;  ++i) {
			for(int j = 0; j < in.length; ++j) {
				mem[i][j] = Math.max(i-1 < 0?0:mem[i-1][j], j-1<0?0:mem[i][j-1]) + in[i][j];
			}
		}
		return mem[in.length-1][in.length-1];
	}
	public static void display(int[][] in) {
		for(int i = 0; i < in.length; ++i) {
			for(int j = 0; j < in.length; ++j) {
				System.out.print(in[i][j] + " ");
			}
			System.out.println();
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
		//display(in);
		//System.out.println(getMaxCoins3(in));
		System.out.println(getMaxCoins4(in));
	}
}
