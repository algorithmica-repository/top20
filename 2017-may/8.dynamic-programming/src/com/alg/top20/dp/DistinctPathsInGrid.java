package com.alg.top20.dp;

public class DistinctPathsInGrid {

	public static int distinctPaths1(int n) {
		MyInteger total = new MyInteger();
		total.set(0);
		auxPaths1(0, 0, n, total);
		return total.get();
	}
	private static void auxPaths1(int i, int j, int n, MyInteger total) {
		if(i >= n) return;
		if(j >= n) return;
		if(i == n-1 && j == n-1) {
			total.set(total.get() + 1);
			return;
		}
		auxPaths1(i+1, j, n, total);
		auxPaths1(i, j+1, n, total);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(distinctPaths1(n));
	}

}
