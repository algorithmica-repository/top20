package com.alg.top20.selection;
import java.util.Arrays;

public class KthSmallest {

	// TC:O(n log n) SC:O(1)
	public static int selection1(int[] in, int k) {
		Arrays.sort(in);
		return in[k - 1];
	}

	private static void adjustMaxHeap(int[] in, int i, int r) {
		int current = i;
		// adjust heap for order property
		while (2 * current + 1 <= r) {
			// find child with max value
			int maxChild = 2 * current + 1;
			if (maxChild + 1 <= r && in[maxChild + 1] > in[maxChild])
				++maxChild;

			// swap parent with max child
			if (in[maxChild] > in[current]) {
				swap(in, current, maxChild);
				current = maxChild;
			} else
				break;
		}
	}

	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}

	private static void buildMaxHeap(int[] in, int l, int r) {
		for (int i = l; i <= r; ++i) {
			int current = i;
			// adjust heap for order property
			while (current > l) {
				int parent = (current - 1) / 2;
				if (in[current] > in[parent]) {
					swap(in, current, parent);
					current = parent;
				} else
					break;
			}
		}
	}

	// use max heap
	// TC: (k log k) + (n-k) log k ~ O(n log k)
	// SC:O(1)
	public static int selection2(int[] in, int k) {
		buildMaxHeap(in, 0, k - 1);
		System.out.println(Arrays.toString(in));
		for (int i = k; i < in.length; ++i) {
			if (in[i] < in[0]) {
				in[0] = in[i];
				adjustMaxHeap(in, 0, k - 1);
			}
			System.out.println("after element at index-" + i + ":"
					+ Arrays.toString(in));
		}
		return in[0];
	}

	private static int partition(int[] in, int l, int r) {
		//first element as pivot
		int pivot = in[l];
		//use random element as pivot
		//swap(in, l, random(l, r))
		int lastmin, current;
		for(lastmin = l, current = l+1; current <= r; ++current) {
			if(in[current] < pivot)
				swap(in, ++lastmin, current);
		}
		swap(in, lastmin, l);
		return lastmin;
	}

	// use partitioning
	//case1: if partitioning is performed on first element in each pass,
	// TC:O(n) avg O(n^2)wc   SC:O(1)
	
	// case2: if partitioning is performed using median of medians in each pass,
	// TC:O(n) SC:O(1)
	public static int selection3(int[] in, int k) {
		int l = 0;
		int r = in.length - 1;
		while (l <= r) {
			int p = partition(in, l, r);
			System.out.println(Arrays.toString(in));
			if (k == p - l + 1)
				return in[p];
			else if (k < p - l + 1)
				r = p - 1;
			else {
				k = k - (p - l + 1);
				l = p + 1;				
			}
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = i + 1;
		Shuffle.shuffle2(in);
		int k = Integer.parseInt(args[1]);
		System.out.println(Arrays.toString(in));
		System.out.println(selection3(in, k));
	}

}
