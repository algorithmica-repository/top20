package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class Sorting {

	public static void treeSort(int[] in) {
		TreeSet<Integer> bbst = new TreeSet<Integer>();
		int i ;
		for(i = 0; i  < in.length; ++i)
			bbst.add(in[i]);
		i =0;
		for(int e:bbst)
			in[i++] = e;	
	}
	
	public static void pqSort(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int i ;
		for(i = 0; i  < in.length; ++i)
			pq.add(in[i]);
		i = 0;
		while(!pq.isEmpty())
			in[i++] = pq.remove();	
	}
	
	private static void merge(int[] in, int ls, int le, int re, int[] aux) {
		int rs = le + 1;
		int k = 0;
		int tmp = ls;
		while(ls <= le && rs <= re) {
			if(in[ls] < in[rs]) {
				aux[k++] = in[ls++];
			} else {
				aux[k++] = in[rs++];
			}				
		}
		while(ls <= le)
			aux[k++] = in[ls++];
		while(rs <= re)
			aux[k++] = in[rs++];
		for(int i = 0; i < k; ++i) 
			in[tmp++] = aux[i];
	}
	
	private static void auxMergeSort(int[] in, int l, int r, int[] aux) {
		if(l >= r) return;
		int m = (l + r)/2;
		auxMergeSort(in, l, m, aux);
		auxMergeSort(in, m+1, r, aux);
		merge(in, l, m, r, aux);
	}
	
	public static void mergeSort(int[] in) {
		int[] aux = new int[in.length];
		auxMergeSort(in, 0, in.length-1, aux);
	}
	
	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	private static int partition(int[] in, int l, int r) {
		int current, lastmin;
		//swap(in, l, pickrandom(l, r));	
		//swap(in, l, medianof3(l,(l+r)/2,r));	
		for(current = l+1, lastmin = l; current <= r; ++current) {
			if(in[current] < in[l]) {
				swap(in, ++lastmin, current);
			} 
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	private static void auxQuickSort(int[] in, int l, int r) {
		if(l >= r) return;
		int p  = partition(in, l, r);
		auxQuickSort(in, l, p-1);
		auxQuickSort(in, p+1, r);
	}
	public static void quickSort(int[] in) {
		auxQuickSort(in, 0, in.length-1);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			in[i] = r.nextInt(100000);
		}		
		long start = System.currentTimeMillis();
		//System.out.println(Arrays.toString(in));
		pqSort(in);
		//System.out.println(Arrays.toString(in));
		long end = System.currentTimeMillis();
		System.out.println("Tree based sorting time:"+ (float) (end - start) / 1000 + " seconds");


	}

}
