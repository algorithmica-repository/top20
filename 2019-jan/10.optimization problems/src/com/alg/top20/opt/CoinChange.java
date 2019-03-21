package com.alg.top20.opt;

public class CoinChange {

	public static int coinChange1(int[] in, int s) {
		MyInteger gmin = new MyInteger(Integer.MAX_VALUE);
		auxChange1(0, s, in,0, gmin);
		return gmin.get();
		
	}
	private static void auxChange1(int i, int j, int[] in, int csum, MyInteger gmin) {
		if(j == 0) {
			gmin.set(Math.min(gmin.get(), csum));
			return;
		}
		if(i == in.length || in[i] > j ) return;
		auxChange1(i, j-in[i], in, csum+1, gmin);
		auxChange1(i+1, j, in, csum, gmin);
	}
	public static int coinChange2(int[] in, int s) {
		return auxChange2(0, s, in);
	}
	private static int auxChange2(int i, int j, int[] in) {
		if(j == 0) return 0;
		if(i == in.length || in[i] > j ) return Integer.MAX_VALUE;
		int inclusive = auxChange2(i, j-in[i], in);
		int exclusive = auxChange2(i+1, j, in);
		return Math.min(inclusive==Integer.MAX_VALUE?inclusive:inclusive+1, exclusive);
	}
	
	public static int coinChange3(int[] in, int s) {
		int[][] mem = new int[in.length][s];
		return auxChange3(0, s, in, mem);
	}
	private static int auxChange3(int i, int j, int[] in, int[][] mem) {
		if(j == 0) return 0;
		if(i == in.length || in[i] > j ) return Integer.MAX_VALUE;
		if(mem[i][j] != 0) return mem[i][j];
		int inclusive = auxChange2(i, j-in[i], in);
		int exclusive = auxChange2(i+1, j, in);
		mem[i][j] = Math.min(inclusive == Integer.MAX_VALUE?inclusive:inclusive+1, exclusive);
		return mem[i][j];
	}
	
	public static int coinChange4(int[] in, int s) {
		int[][] mem = new int[in.length+1][s];
		for(int i = 0; i <= in.length; ++i)
			mem[i][0] = 0;
		for(int j = 1; j <= s; ++j)
			mem[in.length][j] = Integer.MAX_VALUE;
		for(int i = in.length-1; i >= 0; --i) {
			for(int j = 1; j <= s; ++j) {
				if(in[i] > j)
					mem[i][j] = Integer.MAX_VALUE;
				else {
					int inclusive  = mem[i][j-in[i]];
					int exclusive = mem[i+1][j];
					mem[i][j] = Math.min(inclusive == Integer.MAX_VALUE?inclusive:inclusive+1, exclusive);
				}
			}
		}
		return mem[0][s];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
