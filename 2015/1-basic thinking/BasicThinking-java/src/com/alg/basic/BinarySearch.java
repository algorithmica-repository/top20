package com.alg.basic;

public class BinarySearch {
	
	public static int binarysearch(int a[], int n) {
		int l = 0;
		int r = a.length;
		int m;
		while (l <= r) {
			m = l + (r - l) / 2;
			if (a[m] == n)
				return m;
			if (a[m] > n)
				r = m - 1;
			else
				l = m + 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		int a[] = { 10, 20, 30, 40, 50 };
		int n = 30;
		System.out.println(BinarySearch.binarysearch(a, n));
	}

}
