package com.alg.top20.recursion;

public class BinomicalCoeff {

	public static int binomial1(int n, int r) {
		if(r == 1) return n;
		if(r == n) return 1;
		int top = binomial1(n-1, r);
		int diag = binomial1(n-1, r-1);
		return top + diag;
	}
	
	public static int binomial2(int n, int r) {
		int[][] mem = new int[n+1][r+1];
		auxBinomial2(n, r, mem);
		return mem[n][r];
	}	
	private static int auxBinomial2(int n, int r, int[][] mem) {
		if(r == 1) return n;
		if(r == n) return 1;
		if(mem[n][r] != 0) return mem[n][r];
		int top = auxBinomial2(n-1, r, mem);
		int diag = auxBinomial2(n-1, r-1, mem);
		return mem[n][r] = top + diag;
	}
	
	public static int binomial3(int n, int r) {
		int[][] mem = new int[n+1][r+1];
		for(int i = 1; i <= n; ++i)
			mem[i][1] = i;
		for(int i = 2; i <= r; ++i)
			mem[i][i] = 1;
		for(int i = 3; i <= n; ++i) {
			for(int j = 2; j <= Math.min(i-1,r); ++j) {
				mem[i][j] = mem[i-1][j] + mem[i-1][j-1];
			}
		}
		return mem[n][r];
	}	
	public static void main(String[] args) {
		int n =  Integer.parseInt(args[0]);
		int r =  Integer.parseInt(args[1]);
		//System.out.println(binomial2(n, r));
		System.out.println(binomial3(n, r));

	}

}
