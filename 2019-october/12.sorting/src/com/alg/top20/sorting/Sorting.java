package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.PriorityBlockingQueue;

public class Sorting {

	public static void sort1(int[] in) {
		TreeSet<Integer> tset = new TreeSet<Integer>();
		for (int x : in)
			tset.add(x);
		int i = 0;
		for (int x : tset)
			in[i++] = x;
	}

	public static void sort2(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		int i = 0;
		while (!pq.isEmpty())
			in[i++] = pq.remove();
	}

	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}

	public static void sort3(int[] in) {
		int[] aux = new int[in.length];
		auxSort3(0, in.length - 1, in, aux);
	}

	private static void merge(int l, int m, int r, int[] in, int[] aux) {
		int i = l, j = m + 1, k = 0;
		while (i <= m && j <= r) {
			if (in[i] < in[j])
				aux[k++] = in[i++];
			else
				aux[k++] = in[j++];
		}
		while (i <= m)
			aux[k++] = in[i++];
		while (j <= r)
			aux[k++] = in[j++];
		for(int p = 0; p < k; ++p)
			in[l++] = aux[p];
	}

	private static void auxSort3(int l, int r, int[] in, int[] aux) {
		if (l >= r)
			return;
		int m = (l + r) / 2;
		auxSort3(l, m, in, aux);
		auxSort3(m + 1, r, in, aux);
		merge(l, m, r, in, aux);
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
		while (i <= j) {
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
		while (i <= j) {
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
		while (i <= j) {
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
	public static void sort4(int[] in) {
		auxSort4(0, in.length-1, in);
	}
	private static void auxSort4(int l, int r, int[] in) {
		if(l >= r) return;
		//for(int i = l; i <= r; ++i)
		//	System.out.print(in[i] +" ");
		//System.out.println();
		int p = partition_randomelem(in, l, r);
		auxSort4(l, p-1, in);
		auxSort4(p+1, r, in);
	}

	public static int[] testCase1(int n) {
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = n - i;
		return in;
	}
	private static void shuffle(int[] in) {
		int  n = in.length;
		Random r = new Random();
		for(int i = n-1; i > 0;  --i)
			swap(in, i, r.nextInt(i));
	}
	public static int[] testCase2(int n) {
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = n - i;
		shuffle(in);
		return in;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		boolean debug = Boolean.parseBoolean(args[1]);
		int[] in = testCase2(n);
		if (debug)
			System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		//sort4(in);
		Arrays.sort(in);
		///int p = partition_firstelem(in, 0, in.length-1);
		long end = System.currentTimeMillis();
		if (debug)
			System.out.println(Arrays.toString(in));
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");
	}

}
