package com.alg.top20.divideprune;

import java.util.Arrays;

public class MatrixSearch {

	//TC:O(mn)   SC:O(1)
	public static boolean matrixSearch1(int[][] in, int target) {
		int m = in.length;
		int n = in[0].length;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (in[i][j] == target)
					return true;
			}
		}
		return false;
	}

	//TC:O(m log n)   SC:O(1)
	public static boolean matrixSearch2(int[][] in, int target) {
		int m = in.length;
		for (int i = 0; i < m; ++i) {
			if (Arrays.binarySearch(in[i], target) >= 0)
				return true;
		}
		return false;
	}

	//TC:O(log mn)   SC:O(1)
	public static boolean matrixSearch3(int[][] in, int target) {
		int m = in.length;
		int n = in[0].length;
		int l = 0, r = m * n - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			int value_at_mid = in[mid / n][mid % n];
			if (value_at_mid == target)
				return true;
			if (target < value_at_mid)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
