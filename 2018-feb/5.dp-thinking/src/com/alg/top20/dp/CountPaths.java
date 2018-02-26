package com.alg.top20.dp;

public class CountPaths {

	private static int count = 0;
	private static void auxCountPaths(int r, int c, int m, int n) {
		if(r > m || c > n) return;
		if(r == m && c == n)  { 
			++count;
			return;
		}
		auxCountPaths(r, c+1, m, n);
		auxCountPaths(r+1, c, m, n);
	}
	public static int countPaths(int m, int n) {
		auxCountPaths(1, 1, m, n);
		return count;
	}
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.println(countPaths(m, n));
	}

}
