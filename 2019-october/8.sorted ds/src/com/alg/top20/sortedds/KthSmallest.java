package com.alg.top20.sortedds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class KthSmallest {

	public static int kthSmallest1(int[] in, int k) {
		return 0;
	}

	public static int kthSmallest2(int[] in, int k) {
		if (k > in.length)
			return Integer.MIN_VALUE;
		Arrays.sort(in);
		return in[k - 1];
	}

	public static int kthSmallest3(int[] in, int k) {
		if (k > in.length)
			return Integer.MIN_VALUE;
		SortedSet<Integer> oset = new TreeSet<Integer>();
		for (int x : in)
			oset.add(x);
		int count = 0;
		for (int x : oset) {
			++count;
			if (count == k)
				return x;
		}
		return Integer.MIN_VALUE;
	}

	public static int kthSmallest4(int[] in, int k) {
		if (k > in.length)
			return Integer.MIN_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < k; ++i)
			res = pq.remove();
		return res;
	}

	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	
	private static int medianof3(int[] in, int l, int r) {
		if(r-l < 2) return l;
		int mid = (l+r)/2;
		int smallest1, smallest2;
		if(in[l] < in[mid]) {
			smallest1 = in[l];
			smallest2 = in[mid];
		} else {
			smallest1 = in[mid];
			smallest2 = in[l];
		}		
		if(in[r] > smallest2)
			return smallest2;
		else if(in[r] > smallest1)
			return in[r];
		else return smallest1;		
	}
	private static int partition_medianof3(int[] in, int l, int r) {
		int i = l + 1, j = r;
		int median = medianof3(in, l, r);
		swap(in, l, median);
		while (i < j) {
			while (i <= r && in[i] < in[l])
				++i;
			while (j > l && in[j] > in[l])
				--j;
			if (i < j)
				swap(in, i, j);
		}
		swap(in, l, j);
		return j;
	}


	private static int partition_randomelem(int[] in, int l, int r) {
		int i = l + 1, j = r;
		int rand = new Random().nextInt(r - l + 1) + l;
		swap(in, l, rand);
		while (i < j) {
			while (i <= r && in[i] < in[l])
				++i;
			while (j > l && in[j] > in[l])
				--j;
			if (i < j)
				swap(in, i, j);
		}
		swap(in, l, j);
		return j;
	}

	private static int partition_firstelem(int[] in, int l, int r) {
		int i = l + 1, j = r;
		while (i < j) {
			while (i <= r && in[i] < in[l])
				++i;
			while (j > l && in[j] > in[l])
				--j;
			if (i < j)
				swap(in, i, j);
		}
		swap(in, l, j);
		return j;
	}

	public static int kthSmallest5(int[] in, int k) {
		if (k > in.length)
			return Integer.MIN_VALUE;
		int l = 0, r = in.length - 1, p = 0;
		while (l <= r) {
			for (int i = l; i <= r; ++i)
				System.out.print(in[i] + " ");
			System.out.println();
			p = partition_medianof3(in, l, r);
			if (k == p - l + 1)
				break;
			if (k < p - l + 1)
				r = p - 1;
			else {
				k = k - (p - l + 1);
				l = p + 1;
			}
		}
		return in[p];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = n - i;
		System.out.println(Arrays.toString(in));
		int k = new Random().nextInt(n) + 1;
		System.out.println(k);
		// System.out.println(kthSmallest2(in, k));
		// System.out.println(kthSmallest3(in, k));
		System.out.println(kthSmallest5(in, k));
	}

}
