package com.alg.top20.sorted;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class Selection {

	public static int selection1(int[] in, int k) {
		if (in.length < k)
			return Integer.MAX_VALUE;
		Arrays.sort(in);
		return in[k - 1];
	}

	public static int selection2(int[] in, int k) {
		if (in.length < k)
			return Integer.MAX_VALUE;
		TreeSet<Integer> tset = new TreeSet<Integer>();
		for (int x : in)
			tset.add(x);
		int count = 0;
		for (int x : tset) {
			++count;
			if (count == k)
				return x;
		}
		return Integer.MAX_VALUE;
	}

	public static int selection3(int[] in, int k) {
		if (in.length < k)
			return Integer.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= k; ++i)
			res = pq.remove();
		return res;
	}

	private static void swap(int[] in, int l, int r) {
		int tmp = in[l];
		in[l] = in[r];
		in[r] = tmp;
	}
	private static int partition1(int[] in, int l, int r) {
		int lastmin = l;
		for(int current = l+1; current <= r; ++current)
			if(in[current] < in[l])
				swap(in, current, ++lastmin);
		swap(in, lastmin, l);
		return lastmin;
	}

	public static int selection4(int[] in, int k) {
		if (in.length < k)
			return Integer.MAX_VALUE;
		int l = 0, r = in.length - 1;
		while (l <= r) {
			int p = partition1(in, l, r);
			if (k == p - l + 1)
				return in[p];
			if (k < p - l + 1)
				r = p - 1;
			else {
				l = p + 1;
				k = k - (p - l + 1);
			}
		}
		return Integer.MAX_VALUE;
	}
	
	private static void shuffle(int[] in) {
		
	}
	public static int[] testcase1(int n) {
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i+1;
		shuffle(in);
		return in;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int[] in = testcase1(n);
		System.out.println(Arrays.toString(in));
		System.out.println(selection1(in, k));
		System.out.println(selection2(in, k));
		System.out.println(selection3(in, k));
		System.out.println(selection4(in, k));
	}

}
