package com.alg.top20.dp;

import java.util.Random;

public class FindMaxItemsInGrid {
	
	static class MyInteger  {
		int cost;
		MyInteger(int cost) { this.cost = cost; }
		public int get() { return cost; }
		public void set(int cost) { this.cost = cost;  }
	}
	private static void auxMaxItems1(int i, int j, int[][] in, int pathcost, MyInteger maxcost) {
		if(i >= in.length || j >= in.length) return;
		if(i == in.length-1 && j == in.length-1) {
			int totalpathcost = pathcost + in[in.length-1][in.length-1];
			System.out.println(totalpathcost);
			if(totalpathcost > maxcost.get())
				maxcost.set(totalpathcost);
			return;
		}
		auxMaxItems1(i, j+1, in,  pathcost+in[i][j], maxcost);
		auxMaxItems1(i+1, j, in, pathcost+in[i][j], maxcost);
	}
	
	public static int findMaxItems1(int[][] in) {
		MyInteger maxcost = new MyInteger(0);
		auxMaxItems1(0,0,in,0,maxcost);
		return maxcost.get();
	}
	
	private static int auxMaxItems2(int i, int j, int[][] in) {
		if(i < 0 || j < 0) return 0;
		int lc = auxMaxItems2(i - 1 , j, in);
		int uc = auxMaxItems2(i, j - 1, in);
		return Math.max(lc, uc) + in[i][j];
	} 
	
	public static int findMaxItems2(int[][] in) {
		return auxMaxItems2(in.length-1,in.length-1,in);
	}
	
	private static int auxMaxItems3(int i, int j, int[][] in, int[][] mem) {
		if(i < 0 || j < 0) return 0;
		if(mem[i][j] != 0) return mem[i][j];
		int lc = auxMaxItems3(i - 1 , j, in, mem);
		int uc = auxMaxItems3(i, j - 1, in, mem);
		mem[i][j] = Math.max(lc, uc) + in[i][j];
		return mem[i][j];
	} 
	
	public static int findMaxItems3(int[][] in) {
		int[][] mem = new int[in.length][in.length];
		return auxMaxItems3(in.length-1,in.length-1,in, mem);
	}
	
	public static int findMaxItems4(int[][] in) {
		int[][] mem = new int[in.length][in.length];
		for(int i = 0; i < in.length; ++i) {
			for(int j = 0; j < in.length; ++j) {
				mem[i][j] = Math.max(i<1?0:mem[i-1][j], j<1?0:mem[i][j-1]) + in[i][j];
			}
		}
		tracePath(in.length-1, in.length-1, mem);
		return mem[in.length-1][in.length-1];
	}
	
	private static void tracePath(int i, int j, int[][] mem)  {
		if(i < 0 || j < 0) return;
		if( (i<1?0:mem[i-1][j]) > (j<1?0:mem[i][j-1]) ) {
			tracePath(i-1, j, mem);
			System.out.println("(" + i + "," + j + ")");
		} else {
			tracePath(i, j-1, mem);
			System.out.println("(" + i + "," + j + ")");
		}
	}
	
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int[][] in = new int[size][size];
		Random r = new Random(100);
		for(int i = 0; i < size; ++i) {
			for(int j = 0; j < size; ++j) {
				in[i][j] = r.nextInt(10) + 1;
				System.out.print(in[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(findMaxItems4(in));
	}

}
