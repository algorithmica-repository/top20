package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import com.google.common.collect.TreeMultiset;

public class Sorting {

	public static void sorting1(int[] in) {
		TreeMultiset<Integer> tmset = TreeMultiset.create();
		for (int e : in)
			tmset.add(e);
		// System.out.println(tmset);
		int i = 0;
		for (int e : tmset)
			in[i++] = e;
	}

	public static void sorting2(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int e : in)
			pq.add(e);
		// System.out.println(pq);
		int i = 0;
		while (!pq.isEmpty())
			in[i++] = pq.remove();
	}

	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}

	private static int rpartition(int[] in, int l, int r) {
		int lastmin, current;
		int rand_ind = new Random().nextInt(r - l + 1) + l;
		swap(in, l, rand_ind);
		for (current = l + 1, lastmin = l; current <= r; ++current) {
			if (in[current] < in[l]) {
				swap(in, ++lastmin, current);
			}
		}
		swap(in, lastmin, l);
		return lastmin;
	}

	public static void sorting3(int[] in) {
		qsort(in, 0, in.length - 1);
	}

	private static void qsort(int[] in, int l, int r) {
		if (l >= r)
			return;
		int p = rpartition(in, l, r);
		qsort(in, l, p - 1);
		qsort(in, p + 1, r);
	}

	private static void merge(int[] in, int ls, int le, int re, int[] aux) {
		int i = ls, j = le + 1, k = 0;
		while (i <= le && j <= re) {
			if (in[i] < in[j])
				aux[k++] = in[i++];
			else
				aux[k++] = in[j++];
		}
		while(i <= le)
			aux[k++] = in[i++];
		while(j <= re)
			aux[k++] = in[j++];
		for(i = ls, j = 0; j < k; )
			in[i++] = aux[j++];

	}

	public static void sorting4(int[] in) {
		int[] aux = new int[in.length];
		msort(in, 0, in.length - 1, aux);
	}

	private static void msort(int[] in, int l, int r, int[] aux) {
		if (l >= r)
			return;
		int m = l + (r - l) / 2;
		msort(in, l, m, aux);
		msort(in, m + 1, r, aux);
		merge(in, l, m, r, aux);
	}
	private static int findMaxDigits(int[] in) {
		int max = 0;
		for(int e: in) 
			max = Math.max(max, e);
		int d = 0;
		while(max != 0) {
			++d;
			max = max/10;
		}
		return d;
	}
	private static int[] countingSort(int[] in, int div) {
		int[] tmp = new int[in.length];
		int[] counts = new int[10];
		for(int e: in) {
			int d = (e / div) % 10;
			++counts[d];
		}
		for(int i = 1; i < 10; ++i)
			counts[i] += counts[i-1];
		for(int i = in.length-1; i >= 0; --i) {
			int d = (in[i]/div) % 10;
			tmp[--counts[d]] = in[i];
		}
		return tmp;	
	}
	public static void sorting5(int[] in) {
		int d = findMaxDigits(in);
		int div = 1;
		for(int i = 1; i <= d; ++i) {
			in = countingSort(in, div);
			div *= 10;
			//System.out.println(Arrays.toString(in));
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		boolean debug = Boolean.parseBoolean(args[1]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		if (debug == true)
			System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		sorting5(in);
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end - start) / 1000.0 + " secs");
		if (debug == true)
			System.out.println(Arrays.toString(in));

	}

}