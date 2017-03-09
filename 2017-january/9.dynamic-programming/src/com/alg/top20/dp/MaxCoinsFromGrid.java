package com.alg.top20.dp;

import java.util.Random;

public class MaxCoinsFromGrid {
	private static int maxSum = 0;

	private static void auxMaxCoins1(int i, int j, int psum, int[][] in) {
		if(i >= in.length || j >= in.length) return;
		if(i == in.length-1 && j == in.length-1) {
			//compute maximum of current pathsum and previous maximum
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
		display(in);
		System.out.println(getMaxCoins1(in));
	}
}
