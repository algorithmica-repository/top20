package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

import com.google.common.collect.Multiset.Entry;
import com.google.common.collect.TreeMultiset;

public class Sorting {

	//using tree-set/tree-multiset
	//TC:O(n log n)  SC:O(n)
	public static void sort1(int[] in) {
		TreeMultiset<Integer> tmset = TreeMultiset.create();
		for(int e: in) {
			tmset.add(e);
		}
		int k = 0;
		for(Entry<Integer> e:tmset.entrySet()) {
			for(int i = e.getCount(); i > 0; --i)
			   in[k++] = e.getElement();	
		}
	}
	
	//using priority queue
	//TC:O(n log n)  SC:O(n)
	//theoritically, we can reuse input array as heap tree, SC:O(1)
	public static void sort2(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int e:in)
			pq.add(e);
		int k = 0;
		while(! pq.isEmpty())
			in[k++] = pq.remove();
	}
	//merge using aux array: O(n)
	private static void merge(int l, int m, int r, int[] in, int[] aux) {
		int ls = l, rs = m+1, k = 0;
		while(ls <= m && rs <= r) {
			if(in[ls] < in[rs])
				aux[k++] = in[ls++];
			else 
				aux[k++] = in[rs++]; 
		}
		while(ls <= m)
			aux[k++] = in[ls++];
		while(rs <= r)
			aux[k++] = in[rs++];
		int i = 0;
		while(i < k)
			in[l++] = aux[i++];
	}
	private static void auxSort3(int l, int r, int[] in, int[] aux) {
		if(l >= r) return;
		int m = (l+r)/2;
		auxSort3(l, m, in, aux);
		auxSort3(m+1, r, in, aux);
		merge(l, m, r, in, aux);
	}
	//using D&C Recursion
	//TC:O(n log n)  SC:O(log n + n) = O(n)
	public static void sort3(int[] in) {
		int[] aux = new int[in.length];
		auxSort3(0, in.length-1, in, aux);		
	}
	
	private static void swap(int[] in, int l, int r) {
		int tmp = in[l];
		in[l] = in[r];
		in[r] = tmp;
	}
	private static int med3Partition(int l, int r, int[] in) {
		int lastmin, current;
		int first = l, middle = (l+r)/2, last = r, p = 0;
		if(in[first] < in[middle])
			if(in[middle] < in[last])
				p = middle;
			else if(in[first] < in[last])
				p = last;
			else
				p = first;				
		swap(in, l, p);
		for(lastmin = l, current = l+1; current <= r; ++current) {
			if(in[current] < in[l])
				swap(in, ++lastmin, current);
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	private static int rPartition(int l, int r, int[] in) {
		int lastmin, current;
		int rand = new Random().nextInt(r-l) + l;
		swap(in, l, rand);
		for(lastmin = l, current = l+1; current <= r; ++current) {
			if(in[current] < in[l])
				swap(in, ++lastmin, current);
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	private static int partition(int l, int r, int[] in) {
		int lastmin, current;
		for(lastmin = l, current = l+1; current <= r; ++current) {
			if(in[current] < in[l])
				swap(in, ++lastmin, current);
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	private static void auxSort4(int l, int r, int[] in) {
		if(l >= r) return;
		int p = partition(l,r,in);
		auxSort4(l, p-1, in);
		auxSort4(p+1, r, in);
	}
	//using D&C Recursion
	//TC:O(n log n)  SC:O(log n)
	public static void sort4(int[] in) {
		auxSort4(0, in.length-1, in);		
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];

		Random r = new Random();
		for (int i = 0; i < in.length;++i)
			in[i] = r.nextInt(5*n) + 1;
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		sort4(in);
		//System.out.println(Arrays.toString(in));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + " seconds");

	}

}
