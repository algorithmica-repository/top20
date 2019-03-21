package com.alg.top20.sortedds;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class Selection {

	// TC:O(kn) SC:O(1)
	public static int selection1(int[] in, int k) {
		int mini = 0;
		for (int i = 1; i <= k; ++i) {
			mini = 0;
			for (int j = 1; j < in.length; ++j)
				if (in[j] < in[mini])
					mini = j;
			if(i == k) break;
			in[mini] = Integer.MAX_VALUE;
		}
		return in[mini];
	}

	// TC:O(n log n) SC:O(1)
	public static int selection2(int[] in, int k) {
		if (k > in.length)
			return Integer.MIN_VALUE;
		Arrays.sort(in);
		return in[k - 1];
	}

	// TC:O(n log n) SC:O(n)
	public static int selection3(int[] in, int k) {
		if (k > in.length)
			return Integer.MIN_VALUE;
		TreeSet<Integer> tset = new TreeSet<Integer>();
		for (int x : in)
			tset.add(x);
		int count = 0;
		for (int x : tset) {
			++count;
			if (count == k)
				return x;
		}
		return Integer.MIN_VALUE;
	}

	// TC:O(n log n) SC:O(n)
	public static int selection4(int[] in, int k) {
		if (k > in.length)
			return Integer.MIN_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		for (int i = 1; i < k; ++i)
			pq.remove();
		return pq.remove();
	}

	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}

	
	private static int partitions(int[] in, int l, int r) {
		int lastmin, current;
		//int ind = getRandom(l, r);
		//ind = medionofthree(l, r);
		//swap(in, l, ind);
		for (lastmin = l, current = l; current <= r; ++current) {
			if (in[current] < in[l])
				swap(in, ++lastmin, current);
		}
		swap(in, lastmin, l);
		return lastmin;
	}
	private static int partition(int[] in, int l, int r) {
		int lastmin, current;
		for (lastmin = l, current = l; current <= r; ++current) {
			if (in[current] < in[l])
				swap(in, ++lastmin, current);
		}
		swap(in, lastmin, l);
		return lastmin;
	}

	// TC:O(n) expected SC:O(log n) expected
	public static int selection5(int[] in, int k) {
		int l = 0, r = in.length - 1;
		while (l <= r) {
			int p = partition(in, l, r);
			if (k == p + 1)
				return in[p];
			if (k < p + 1)
				r = p - 1;
			else {
				l = p + 1;
				k = k - (p - l + 1);
			}
		}
		return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random(100);
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n);
		int k = n/2;
		System.out.println(Arrays.toString(in));
		System.out.println(k);
		System.out.println();
		//System.out.println(selection1(in, k));
		//System.out.println(selection2(in, k));
		System.out.println(selection3(in, k));
		System.out.println(selection4(in, k));
		System.out.println(selection5(in, k));

	}

}
