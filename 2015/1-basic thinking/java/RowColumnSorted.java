package com.algorithmica.arrays;

/*Each row is sorted & each column is sorted in a given 2D array and an element x is given
 * write a method to determine whether x is present or not
 * */
public class RowColumnSorted {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = { { 1, 2, 3, 5 }, { 4, 6, 8, 11 }, { 5, 10, 12, 15 },
				{ 9, 15, 18, 20 } };
		System.out.println(findElement(a, 9));

	}

	static boolean findElement(int a[][], int x) {
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

}
