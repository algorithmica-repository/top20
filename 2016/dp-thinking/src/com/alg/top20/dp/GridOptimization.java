package com.alg.top20.dp;

import java.util.Random;

public class GridOptimization {

	private static int auxMaxItems1(int i, int j, int[][] in) {
		if(0 == i || 0 == j) return 0;
		int topCell = auxMaxItems1(i-1, j, in);
		int leftCell = auxMaxItems1(i, j-1, in);
		return Math.max(topCell, leftCell) + in[i-1][j-1];
	}
	public static int findMaxItems1(int[][] in) {
		return auxMaxItems1(in.length,in.length,in);
	}
	
	private static int auxMaxItems2(int i, int j, int[][] in,int[][] mem) {
		if(0 == i || 0 == j) return 0;
		if(mem[i][j] != 0) return mem[i][j];
		int topCell = auxMaxItems2(i-1, j, in, mem);
		int leftCell = auxMaxItems2(i, j-1, in, mem);
		mem[i][j] = Math.max(topCell, leftCell) + in[i-1][j-1];
		return mem[i][j];
	}
	public static int findMaxItems2(int[][] in) {
		int[][] mem = new int[in.length+1][in.length+1];
		auxMaxItems2(in.length,in.length,in,mem);
		return mem[in.length][in.length];
	}
	
	public static void main(String[] args) {
	/*	int[][] in = { {2,5,4}, {4,4,3}, {6,2,1}};
		System.out.println(findMaxItems2(in));*/
		
		Random r = new Random(100);
		int size = Integer.parseInt(args[0]);
		int[][] in = new int[size][size];
		for(int i = 0; i < size; ++i) {
			for(int j = 0; j < size; ++j) {
				in[i][j] = r.nextInt(10) + 1;
				//System.out.print(in[i][j] + " ");
			}
			//System.out.println();
		}
		System.out.println(findMaxItems2(in));
	}

}
