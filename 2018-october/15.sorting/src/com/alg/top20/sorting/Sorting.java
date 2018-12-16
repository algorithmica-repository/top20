package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

import com.google.common.collect.TreeMultiset;

public class Sorting {

	public static void sort1(int[] in) {
		TreeMultiset<Integer> tset = TreeMultiset.create();
		for (int x : in)
			tset.add(x);
		int i = 0;
		Iterator<Integer> iterator = tset.iterator();
		while(iterator.hasNext())
			in[i++] = iterator.next();
	}
	
	public static void sort2(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		for (int i = 0; i < in.length; ++i)
			in[i] = pq.remove();
	}

	public static void sort3(int[] in) {
		int[] aux = new int[in.length];
		auxSort3(0, in.length - 1, in, aux);
	}

	private static void merge(int[] in, int l, int m, int r, int[] aux) {
		int ls = l, rs = m + 1, k = 0;
		while (ls <= m && rs <= r) {
			if (in[ls] < in[rs])
				aux[k++] = in[ls++];
			else
				aux[k++] = in[rs++];
		}
		while(ls <= m)
			aux[k++] = in[ls++];
		while(rs <= r)
			aux[k++] = in[rs++];
		for(int i = 0; i < k; ++i)
			in[l++] = aux[i];
	}

	private static void auxSort3(int l, int r, int[] in, int[] aux) {
		if (l == r)
			return;
		int m = l + (r - l) / 2;
		auxSort3(l, m, in, aux);
		auxSort3(m + 1, r, in, aux);
		merge(in, l, m, r, aux);
	}

	public static void sort4(int[] in) {
		Random random = new Random();
		auxSort4(0, in.length - 1, in, random);
	}
	private static void swap(int[] in, int l, int r) {
		int tmp = in[l];
		in[l] = in[r];
		in[r] = tmp;
	}
	private static int getRandomIndex(int l, int r, Random random) {
		int tmp =  random.nextInt(r-l+1) + l;
		//System.out.println(l + " " + r + " " +tmp);
		return tmp;
	}
	private static int partition(int[] in, int l, int r, Random random) {
		//int rindex = getRandomIndex(l, r, random);
		//swap(in, l, rindex);
		int pivot = in[l];
		int boundary=l, current=l+1;
		for(; current <= r; ++current) {
			if(in[current] < pivot)
				swap(in, ++boundary, current);
		}
		swap(in, boundary, l);
		return boundary;
	}
	private static void auxSort4(int l, int r, int[] in, Random random) {
		if (l >= r)
			return;
		int p = partition(in, l, r, random);
		auxSort4(l, p-1, in, random);
		auxSort4(p + 1, r, in, random);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random();
		int[] in = new int[n];
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(3*n) + 1;
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		sort4(in);
		long end = System.currentTimeMillis();
		//System.out.println(Arrays.toString(in));
		System.out.println("Time:" + (end - start) / 1000.0 + "secs");
	}

}
