package com.alg.top20.dp.twod;

public class GridPaths {

	public static void displayPaths(int n) {
		auxPaths(0, 0, n, "");
	}
	private static void auxPaths(int i, int j, int n, String path) {
		if(i >= n || j >= n) return;
		if(i == n-1 && j == n-1) {
			System.out.println(path+"("+(n-1)+","+(n-1)+")");
			return;
		}
		auxPaths(i, j+1, n, path+"("+(i)+","+(j)+")");
		auxPaths(i+1, j, n, path+"("+(i)+","+(j)+")");
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		displayPaths(n);
	}


}
