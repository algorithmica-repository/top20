package com.alg.top20.recursion;

public class CountPaths {

	private static void auxCountPaths(int r, int c, int m, int n, MyInteger count) {
		if(r > m || c > n) return;
		if(r == m && c == n)  { 
			count.set(count.get()+1);
			return;
		}
		auxCountPaths(r, c+1, m, n, count);
		auxCountPaths(r+1, c, m, n, count);
	}
	public static int countPaths(int m, int n) {
		MyInteger count = new MyInteger(0);
		auxCountPaths(1, 1, m, n, count);
		return count.get();
	}
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.println(countPaths(m, n));
	}

}
