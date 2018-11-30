package com.alg.top20.sortedds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Selection {

	//sorting
	public static int selection1(int[] in, int k) {
		if(k > in.length) return Integer.MIN_VALUE;
		Arrays.sort(in);
		return in[k-1];
	}
	//treeset
	public static int selection2(int[] in, int k) {
		if(k > in.length) return Integer.MIN_VALUE;
		TreeSet<Integer> tset = new TreeSet<Integer>();
		for(int x:in) 
			tset.add(x);
		int x = 0;
		for(int i = 0; i < k; ++i)
			x = tset.pollFirst();
		return x;	
	}
	//min priority queue of size n
	public static int selection3(int[] in, int k) {
		if(k > in.length) return Integer.MIN_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int x:in) 
			pq.add(x);
		//System.out.println(pq);
		for(int i = 1; i < k; ++i)
			pq.remove();
		return pq.remove();
	}
	
	static class MyComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer e1, Integer e2) {
			return e2-e1;
		}
		
	}
	//max priority queue of size k
	public static int selection4(int[] in, int k) {
		if(k > in.length) return Integer.MIN_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new MyComparator());
		int i = 0;
		for(; i < k; ++i) 
			pq.add(in[i]);
		//System.out.println(pq);
		for(; i < in.length; ++i) {
			if(in[i] < pq.peek()) {
				pq.remove();
				pq.add(in[i]);
			}
		}
		return pq.peek();
	}
	
	//divide & prune with right pivot selection strategy
	public static int selection5(int[] in, int k) {
		return auxSelection(in, 0, in.length-1, k);
	}
	private static void swap(int[] in, int l, int r) {
		int tmp = in[l];
		in[l] = in[r];
		in[r] = tmp;
	}
	private static int partition(int[] in, int l, int r) {
		int pivot = in[l];
		int boundary=l, current=l+1;
		for(; current <= r; ++current) {
			if(in[current] < pivot)
				swap(in, ++boundary, current);
		}
		swap(in, boundary, l);
		return boundary;
	}
	private static int auxSelection(int[] in, int l, int r, int k) {
		if(l > r) return Integer.MIN_VALUE;
		int p = partition(in, l, r);
		if(k == p-l+1) return in[p];
		if(k < p-l+1) 
			return auxSelection(in, l, p-1, k);
		else
			return auxSelection(in, p+1, r, k-(p-l+1));
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= n; ++i)
			list.add(i);
		Collections.shuffle(list);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = list.remove(0);
		System.out.println(Arrays.toString(in));
		System.out.println(selection1(in, k));
		System.out.println(selection2(in, k));
		System.out.println(selection3(in, k));
		System.out.println(selection4(in, k));
		System.out.println(selection5(in, k));
	}

}
