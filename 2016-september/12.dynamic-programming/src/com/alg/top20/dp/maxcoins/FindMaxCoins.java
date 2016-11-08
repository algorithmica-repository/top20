package com.alg.top20.dp.maxcoins;

import java.util.Random;

public class FindMaxCoins {
	private static int max = Integer.MIN_VALUE;

	// explore all paths
	public static void auxMaxCoins1(int[][] in, int i, int j, int csum) {
		if(i >= in.length || j >= in.length) return;
		if(i == in.length-1 && j == in.length-1) {
			max = Math.max(max, csum + in[i][j]);
			System.out.println(csum + in[i][j]);
			return;
		}
		auxMaxCoins1(in, i+1, j, csum + in[i][j]);
		auxMaxCoins1(in, i, j+1, csum + in[i][j]);
	}
	public static int findMaxCoins1(int[][] in) {
		auxMaxCoins1(in, 0, 0, 0);
		return max;
	}
	//use recursive thought to reduce and build
	public static int auxMaxCoins2(int[][] in, int i, int j) {
		if(i < 0 || j < 0) return  0;
		int topcell = auxMaxCoins2(in, i-1, j);
		int leftcell = auxMaxCoins2(in, i, j-1);
		return  Math.max(topcell, leftcell) + in[i][j];
	}
	public static int findMaxCoins2(int[][] in) {
		return auxMaxCoins2(in, in.length-1, in.length-1);
	}
	
	// use recursion with memory
	public static int auxMaxCoins3(int[][] in, int i, int j, int[][] mem) {
		if(i < 0 || j < 0) return  0;
		if(mem[i][j] != 0) return mem[i][j];
		int topcell = auxMaxCoins3(in, i-1, j, mem);
		int leftcell = auxMaxCoins3(in, i, j-1, mem);
		mem[i][j] = Math.max(topcell, leftcell) + in[i][j];
		return mem[i][j];
	}
	public static int findMaxCoins3(int[][] in) {
		int[][] mem = new int[in.length][in.length];
		return auxMaxCoins3(in, in.length-1, in.length-1, mem);
	}
	// fill memory without recursion
	public static int findMaxCoins4(int[][] in) {
		int[][] mem = new int[in.length][in.length];
		
		return mem[][];
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[][] in = new int[n][n];
		Random r = new Random(100);
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				in[i][j] = r.nextInt(10) + 1;
				//System.out.print(in[i][j] + " ");
			}
			//System.out.println();
		}
		//System.out.println(findMaxCoins1(in));
		//System.out.println(findMaxCoins2(in));
		System.out.println(findMaxCoins3(in));
	}

}
