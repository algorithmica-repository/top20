package com.alg.top20.array;

import java.util.Arrays;

public class MatrixSearch {

	//TC:O(mn)   SC:O(1)
	public static boolean matrixSearch1(int[][] in, int x) {
		int m = in.length;
		int n = in[0].length;
		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				if(in[i][j] == x) return true;
			}
		}
		return false;
	}
	
	//TC:O(m log n)   SC:O(1)
	public static boolean matrixSearch2(int[][] in, int x) {
		int m = in.length;
		for(int i = 0; i < m; ++i) {
			if(Arrays.binarySearch(in[i], x) >= 0) return true;
		}
		return false;
	}
	
	private static int floor(int[][] in, int x) {
		//TODO
		return 0;
	}
	//TC:O(log mn)   SC:O(1)
	public static boolean matrixSearch3(int[][] in, int x) {
		int i = floor(in, x);
		return Arrays.binarySearch(in[i], x) >= 0;
	}
	
	//TC:O(log mn)   SC:O(1)
	public static boolean matrixSearch4(int[][] in, int x) {
		int m = in.length;
		int n = in[0].length;
		int l = 0;
		int r = m*n-1;
		while(l <= r) {
			int mid = (l+r)/2;
			int tmp = in[mid/n][mid%n];
			if(tmp == x) return true;
			if(x < tmp) r = m-1;
			else l = m+1;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
