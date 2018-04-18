package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

public class Sorting {

	public static void treeSort(int[] in) {
		SortedMultiset<Integer> oset = TreeMultiset.create();
		for(int e:in) 
			oset.add(e);
		int i = 0;
		for(int e: oset)
			in[i++] = e;
	}
	public static void selectionSort(int[] in) {
		for(int i = 0; i < in.length; ++i) {
			int min_ind = i;
			for(int j = i+1; j < in.length; ++j) {
				if(in[j] < in[min_ind])
					min_ind = j; 
			}
			swap(in, i, min_ind);
		}
	}

	
	public static void heapSort1(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int e:in) 
			pq.add(e);
		for(int i = 0; i < in.length; ++i)
			in[i] = pq.remove();
	}
	
	public static void heapSort2(int[] in) {
		//make_heap(in);
		//sort elements in heap
	}
	public static void mergeSort(int[] in) {
		int[] aux = new int[in.length];
		auxMergeSort(in, 0, in.length-1, aux);
	}
	private static void auxMergeSort(int[] in, int l, int r, int[] aux) {
		if(l >= r) return;
		int m = (l + r)/2;
		auxMergeSort(in, l, m, aux);
		auxMergeSort(in, m+1, r, aux);
		merge(in, l, m, r, aux);
	}
	private static void merge(int[] in, int ls, int le, int re, int[] aux) {
		int i = ls, j = le + 1, k = 0;
		while(i <= le && j <= re) {
			if(in[i] < in[j])
				aux[k++] = in[i++];
			else
				aux[k++] = in[j++];
		}
		while(i <= le)
			aux[k++] = in[i++];
		while(j <= re)
			aux[k++] = in[j++];
		i = 0;
		while(i < k)
			in[ls++] = aux[i++];
	}
	
	public static void quickSort(int[] in) {
		auxQuickSort(in, 0, in.length-1);
	}
	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	private static int partition(int[] in, int l, int r) {
		int lastmin, current;
		//todo: try random pivot, median of three pivot
		for(lastmin = l, current = l+1; current <= r; ++current) {
			if(in[current] < in[l])
				swap(in, ++lastmin, current);
		}	
		swap(in, l, lastmin);
		return lastmin;
	}
	private static void auxQuickSort(int[] in, int l, int r) {
		if(l >= r) return;
		int p = partition(in, l, r);
		auxQuickSort(in, l, p-1);
		auxQuickSort(in, p+1, r);
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];

		Random r = new Random();
		for(int i = 0; i < in.length; ++i)
			in[i] = r.nextInt(n) + 1;
		boolean debug = Boolean.parseBoolean(args[1]);
		if(debug == true)
			System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		selectionSort(in);		
		long end = System.currentTimeMillis();
		if(debug == true)
			System.out.println(Arrays.toString(in));
		System.out.println("Time:" + (end-start)/1000.0 +"seconds");

	}

}
