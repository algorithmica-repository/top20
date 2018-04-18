package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.Random;

public class Selection {
	// TC:O(n log n)
	// SC:O(1)
	public static int kthSmallest1(int[] in, int k) {
		if(k > in.length) return Integer.MIN_VALUE;
		Arrays.sort(in);
		return in[k - 1];
	}	
	//TC:O(n), SC:O(log n) if right pivot selection is used
	public static int kthSmallest2(int[] in, int k) {
		return auxSmallest(in, 0, in.length - 1, k);
	}
	private static int auxSmallest(int[] in, int l, int r, int k) {
		if (l > r)
			return Integer.MIN_VALUE;
		int p = partition1(in, l, r);
		//p-l+1 is the rank of element at index p
		if (p - l + 1 == k)
			return in[p];
		if (k < p - l + 1)
			return auxSmallest(in, l, p - 1, k);
		else
			return auxSmallest(in, p + 1, r, k - (p - l + 1));
	}
	private static int partition1(int[] in, int l, int r) {
		int lastmin, current;
		int pivot = in[l];
		for (lastmin = l, current = l + 1; current <= r; ++current) {
			if (in[current] < pivot)
				swap(in, ++lastmin, current);
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	// TC:O( n log n + k log n)
	// SC:O(1)
	public static int kthSmallest3(int[] in, int k) {
		return 0;
	}



	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int[] in = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n)+1;
		System.out.println(Arrays.toString(in));
		System.out.println(kthSmallest1(in, k));
		System.out.println(kthSmallest2(in, k));
	}

}
