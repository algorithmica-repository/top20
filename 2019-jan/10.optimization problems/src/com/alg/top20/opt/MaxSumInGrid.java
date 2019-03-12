package com.alg.top20.opt;

import java.util.Arrays;
import java.util.Random;

public class MaxSumInGrid {

	//complete search
	//TC:O(2 ^ 2n)  SC:O(n)
	public static int maxSum1(int[][] in) {
		MyInteger msum = new MyInteger(0);
		auxSum1(0, 0, 0, in, msum);
		return msum.get();
	}
	private static void auxSum1(int i, int j, int csum, int[][] in, MyInteger msum) {
		if(i >= in.length || j >= in.length) return;
		if(i == in.length-1 && j == in.length-1) {
			msum.set(Math.max(msum.get(), csum + in[i][j]));
			return;
		}
		auxSum1(i, j+1, csum+in[i][j], in, msum);
		auxSum1(i+1, j, csum+in[i][j], in, msum);
	}
	//optimal recursion ~ recursion with optimal substructure
	//TC:O(2 ^ 2n)  SC:O(n)
	public static int maxSum2(int[][] in) {
		return auxSum2(0, 0, in);
	}
	private static int auxSum2(int i, int j, int[][] in) {
		if(i >= in.length || j >= in.length) return 0;
		int rsum = auxSum2(i, j+1, in);
		int dsum = auxSum2(i+1, j, in);
		return Math.max(rsum, dsum) + in[i][j];
	}
	//memory fillup with recursion
	//TC:O(n ^ 2)  SC:O(n ^ 2)
	public static int maxSum3(int[][] in) {
		int[][] mem = new int[in.length][in.length];
		return auxSum3(0, 0, in, mem);
	}
	private static int auxSum3(int i, int j, int[][] in, int[][] mem) {
		if(i >= in.length || j >= in.length) return 0;
		if(mem[i][j] != 0) return mem[i][j];
		int rsum = auxSum3(i, j+1, in, mem);
		int dsum = auxSum3(i+1, j, in, mem);
		mem[i][j] =  Math.max(rsum, dsum) + in[i][j];
		return mem[i][j];
	}
	
	//memory fillup without recursion
	//TC:O(n ^ 2)  SC:O(n ^ 2)
	public static int maxSum4(int[][] in) {
		int n = in.length;
		int[][] mem = new int[n+1][n+1];
		for(int i = 0; i <= n; ++i) {
			mem[n][i] = 0;
			mem[i][n] = 0;
		}
		for(int i = n-1; i >= 0; --i) {
			for(int j = n-1; j >= 0; --j) {
				int rsum = mem[i][j+1];
				int dsum = mem[i+1][j];
				mem[i][j] =  Math.max(rsum, dsum) + in[i][j];
			}
		}
		for(int[] tmp:mem)
			System.out.println(Arrays.toString(tmp));
		trace_optimal_path(0, 0, mem);
		System.out.println();
		return mem[0][0];
	}
	private static void trace_optimal_path(int i, int j, int[][] mem) {
		if(i == mem.length-1 || j == mem.length-1) return;
		if(mem[i+1][j] > mem[i][j+1]) {
			System.out.print("(" +(i+1) +"," + j +")->");
			trace_optimal_path(i+1, j, mem);
		} else {
			System.out.print("(" +i +"," + (j+1) +")->");
			trace_optimal_path(i, j+1, mem);
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
			System.out.println(Arrays.toString(in[i]));
		}
		System.out.println();
		//System.out.println(maxSum1(in));
		//System.out.println(maxSum2(in));
		//System.out.println(maxSum3(in));
		System.out.println(maxSum4(in));

	}

}
