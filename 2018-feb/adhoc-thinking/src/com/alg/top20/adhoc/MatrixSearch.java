package com.alg.top20.adhoc;

import java.util.Arrays;

public class MatrixSearch {

	// binary search on each row
	public static boolean matrixSearch1(int[][] in, int target) {
		int m = in.length;
		for (int i = 0; i < m; ++i) {
			if (Arrays.binarySearch(in[i], target) >= 0)
				return true;
		}
		return false;
	}

	// find the required row by linear search
	// along last column
	// binary search on that row
	public static boolean matrixSearch2(int[][] in, int target) {
		int m = in.length;
		int n = in[0].length;
		int i;
		for (i = 0; i < m; ++i) {
			if (target <= in[i][n - 1])
				break;
		}
		return Arrays.binarySearch(in[i], target) >= 0;
	}

	public static boolean matrixSearch3(int[][] in, int target) {
		int m = in.length;
		int n = in[0].length;

		int left = 0, right = n * m - 1;

		while (left <= right) {
			int mid = (left + right) / 2;
			int element = in[mid / n][mid % n];
			if (element == target)
				return true;
			if (target < element)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		
		

	}

}
