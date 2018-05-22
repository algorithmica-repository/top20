package com.alg.top20.divideprune;
import java.util.Arrays;

public class GridSearch {

	public static boolean searchGrid1(int[][] in, int x) {
		int m = in.length;
		int n = in[0].length;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (in[i][j] == x)
					return true;
			}
		}
		return false;
	}

	public static boolean searchGrid2(int[][] in, int x) {
		int m = in.length;
		for (int i = 0; i < m; ++i) {
			if (Arrays.binarySearch(in[i], x) >= 0)
				return true;
		}
		return false;
	}

	public static boolean searchGrid3(int[][] in, int x) {
		int m = in.length;
		int n = in[0].length;
		int l = 0;
		int r = m * n - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int tmp = in[mid / n][mid % n];
			if (x == tmp)
				return true;
			if (x < tmp)
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
