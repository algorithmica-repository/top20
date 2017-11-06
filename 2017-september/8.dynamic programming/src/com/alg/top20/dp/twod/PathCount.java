package com.alg.top20.dp.twod;

public class PathCount {

	//TC:O(2 ^ 2n)
	//SC:O(n)
	//Adhoc: explore all paths
	public static int countPaths1(int n) {
		MyInteger counter = new MyInteger(0);
		auxPaths1(0, 0, n, counter);
		return counter.get();
	}
	private static void auxPaths1(int i, int j, int n, MyInteger counter) {
		if(i >= n || j >= n) return;
		if(i == n-1 && j == n-1) {
			counter.set(counter.get()+1);
			return;
		}
		auxPaths1(i, j+1, n, counter);
		auxPaths1(i+1, j, n, counter);
	}
	
	//TC:O(2 ^ 2n)
	//SC:O(n)
	//Recursion
	public static int countPaths2(int n) {
		return auxPaths2(n, n);
	}
	private static int auxPaths2(int i, int j) {
		if(i == 1 && j == 1) return 1;
		if(i == 0 || j == 0) return 0;
		int topCount = auxPaths2(i-1, j);
		int leftCount = auxPaths2(i, j-1);
		return topCount + leftCount;
	}
	
	//TC:O(n ^ 2)
	//SC:O(n ^ 2)
	//Memoization : Recursion with memory
	public static int countPaths3(int n) {
		int[][] mem = new int[n+1][n+1];
		return auxPaths3(n, n, mem);
	}
	private static int auxPaths3(int i, int j, int[][] mem) {
		if(i == 1 && j == 1) return 1;
		if(i == 0 || j == 0) return 0;
		if(mem[i][j] != 0) return mem[i][j];
		int topCount = auxPaths3(i-1, j, mem);
		int leftCount = auxPaths3(i, j-1, mem);
		mem[i][j] = topCount + leftCount;
		return mem[i][j];
	}
	
	//TC:O(n ^ 2)
	//SC:O(n ^ 2)
	//Dynamic programming
	public static int countPaths4(int n) {
		int[][] mem = new int[n+1][n+1];
		mem[1][1] = 1;
		for(int i = 1; i <= n; ++i) {
			for(int j = 1; j <= n; ++j) {
				if(i == 1 && j == 1) continue;
				mem[i][j] = mem[i-1][j] + mem[i][j-1];
			}
		}
		return mem[n][n];
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(countPaths4(n));
	}

}
