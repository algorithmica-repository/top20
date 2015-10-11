package com.alg.basic;

public class RowColumnSorted {

	public static boolean findElement(int a[][], int x) {
		int row = 0;
		int col = a[0].length - 1;
		int len = a.length;
		while (row <= len - 1 && col >= 0) {
			if (a[row][col] == x) {
				return true;
			} else if (x > a[row][col])
				++row;
			else
				--col;
		}

		return false;
	}
	
	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3, 5 }, { 4, 6, 8, 11 }, { 5, 10, 12, 15 },
				{ 9, 15, 18, 20 } };
		System.out.println(findElement(a, 9));

	}

}
