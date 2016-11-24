package com.alg.top20.sorting;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class Sorting {

	//10 lakhs - 0.717  1 cr - 18.517
	public static void bst_tree_sort1(int[] in) {
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i =  0; i < in.length; ++i) {
			ts.add(in[i]);
		}
		int i = 0;
		Iterator<Integer> elements = ts.iterator();
		while(elements.hasNext()) {
			in[i++] = elements.next();
		}		
	}
	
	//10 lakhs - 0.64  1 cr - 14.009
	public static void heap_tree_sort2(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i =  0; i < in.length; ++i) {
			pq.add(in[i]);
		}
		int i= 0;
		while(!pq.isEmpty()) {
			in[i++] =pq.poll();
		}		
	}
	
	//1 lakhs - 3.5
	public static void insertion_sort3(int[] in) {
		for(int i = 1; i < in.length; ++i) {
			int celement = in[i];
			int j;
			for(j = i-1; j >= 0; --j) {
				if(in[j] > celement )
					in[j+1] = in[j];
				else {
					in[j+1] = celement;
					break;
				}
			}
			if(j == -1)
				in[j+1] = celement;
		}
	}
	
	private static void merge(int[] in, int ls, int le, int re, int[] tmp) {
		int rs = le + 1;
		int i = ls, j = rs, k = 0;
		while(i <= le && j <= re) {
			if(in[i] < in[j])
				tmp[k++] = in[i++];
			else
				tmp[k++] = in[j++];
		}
		//copy remaining elements of left array
		while(i <= le)
			tmp[k++] = in[i++];
		//copy remaining elements of right array
		while(j <= re)
			tmp[k++] = in[j++];
		//copy merged tmp array back to input array
		int p = 0;
		while(p < k)
			in[ls++] = tmp[p++];
	}
	private static void auxMergeSort(int[] in, int l, int r, int[] tmp) {
		if(l==r) return;
		int m = (l + r)/2;
		auxMergeSort(in, l, m, tmp);
		auxMergeSort(in, m+1, r, tmp);
		merge(in,l,m,r, tmp);
	}
	//10 lakhs - 0.156 1 cr - 1.669 10cr -19.04 
	public static void merge_sort4(int[] in) {
		int[] tmp = new int[in.length];
		auxMergeSort(in, 0, in.length-1, tmp);
	}
	
	private static void swap(int[] in, int l, int r) {
		int tmp = in[l];
		in[l] = in[r];
		in[r] = tmp;
	}
	private static int partition1(int[] in, int l, int r) {
		int pivot = in[l];
		int lastmin, current;
		for(lastmin=l, current=l+1; current <= r; ++current) {
			if(in[current] < pivot) 
				swap(in,++lastmin, current);
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	
	private static int rpartition(int[] in, int l, int r) {
		Random rand = new Random(100);
		int rindex = rand.nextInt(r-l+1) + l;
		swap(in, l, rindex);
		int pivot = in[l];
		int lastmin, current;
		for(lastmin=l, current=l+1; current <= r; ++current) {
			if(in[current] < pivot) 
				swap(in,++lastmin, current);
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	
	private static int median3(int[] in, int l, int r) {
		return 0;
	}
	private static int medianof3partition(int[] in, int l, int r) {
		int med3index = median3(in, l, r);
		swap(in, l, med3index);
		int pivot = in[l];
		int lastmin, current;
		for(lastmin=l, current=l+1; current <= r; ++current) {
			if(in[current] < pivot) 
				swap(in,++lastmin, current);
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	private static void auxQuickSort(int[] in, int l, int r) {
		if(l >= r) return;
		int p = medianof3partition(in, l, r);
		auxQuickSort(in, l, p-1);
		auxQuickSort(in, p+1, r);		
	}
	
	//10 lakhs - 0.109 1 cr - 1.155 10cr -12.792
	public static void quick_sort5(int[] in) {
		auxQuickSort(in, 0, in.length-1);
	}
	
	private static void auxHybridSort(int[] in, int l, int r) {
		if(r - l <= 100) {
			//insertionsort(in, l, r);
			return;
		}
		int p = medianof3partition(in, l, r);
		auxQuickSort(in, l, p-1);
		auxQuickSort(in, p+1, r);		
	}
	
	//10 lakhs - 0.109 1 cr - 1.155 10cr -12.792
	public static void hybrid_sort6(int[] in) {
		auxHybridSort(in, 0, in.length-1);
	}

}
