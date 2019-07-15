package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class Sorting {

	public static void sort1(int[] in) {
		TreeSet<Integer> tset = new TreeSet<Integer>();
		for(int x:in)
			tset.add(x);
		int i = 0;
		for(int x:tset)
			in[i++] = x;
	}
	public static void sort2(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int x:in)
			pq.add(x);
		int i = 0;
		while(!pq.isEmpty())
			in[i++] = pq.remove();
	}
	public static void sort3(int[] in) {
		int[] aux = new int[in.length];
		auxsort3(0, in.length-1, in, aux);
	}
	private static void auxsort3(int l, int r, int[] in, int[] aux) {
		if(l >= r) return ;
		int m = l + (r-l)/2;
		auxsort3(l, m, in, aux);
		auxsort3(m+1, r, in, aux);
		merge(l, m, r, in, aux);
	}
	private static void merge(int l, int m, int r, int[] in, int[] aux) {
		int ls = l, le = m, rs = m+1, re = r, k = 0;
		while(ls <= le && rs <= re) {
			if(in[ls] < in[rs])
				aux[k++] = in[ls++];
			else
				aux[k++] = in[rs++];				
		}
		while(ls <= le)
			aux[k++] = in[ls++];
		while(rs <= re)
			aux[k++] = in[rs++];
		for(int i = 0; i < k; ++i)
			in[l++] = aux[i];
	}
	public static void sort4(int[] in) {
		auxsort4(0, in.length-1, in);
	}
	private static void auxsort4(int l, int r, int[] in) {
		if(l >= r) return;
		int p = partition(in, l, r);
		auxsort4(l, p-1, in);
		auxsort4(p+1, r, in);
	}
	private static void swap(int[] in, int l, int r) {
		int tmp = in[l];
		in[l] = in[r];
		in[r] = tmp;
	}
	private static int partition(int[] in, int l, int r) {
		int lastmin = l;
		for(int current = l+1; current <= r; ++current)
			if(in[current] < in[l])
				swap(in, current, ++lastmin);
		swap(in, lastmin, l);
		return lastmin;
	}

	private static void shuffle(int[] in) {
		Random r = new Random(100);
		for(int i = in.length-1; i >= 0; --i)
			swap(in, i, r.nextInt(i+1));
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i+1;
		shuffle(in);
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		sort1(in);
		long end = System.currentTimeMillis();
		//System.out.println(Arrays.toString(in));
		System.out.println("Time:" + (end-start)/1000.0 + "secs");
	}

}
