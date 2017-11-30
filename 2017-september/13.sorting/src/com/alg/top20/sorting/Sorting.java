package com.alg.top20.sorting;

import java.util.PriorityQueue;
import java.util.Random;

import com.alg.top20.heap.MaxHeap;
import com.google.common.collect.TreeMultiset;

public class Sorting {

	//TC: O(n log n)
	//SC:O(n)
	public static void sort1(int[] in) {
		TreeMultiset<Integer> tree = TreeMultiset.create();
		for(int e:in) 
			tree.add(e);
		int i = 0;
		for(Integer e:tree)
			in[i++] = e;
	}
	
	//TC: O(n log n)
	//SC:O(n)
	//using priority queue of java.utils
	public static void sort21(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int e:in) 
			pq.add(e);
		int i = 0;
		while(! pq.isEmpty())
			in[i++] = pq.remove();
	}
	
	//TC: O(n log n)
	//SC:O(1)
	//using custom heap
	public static void sort22(int[] in) {
		MaxHeap heap = new MaxHeap(in);
		heap.buildMaxHeapIncr();
		//heap.display();
		heap.sort();
		//heap.display(in);
	}
	
	//TC: O(n^2)
	//SC:O(1)
	public static void sort3(int[] in) {
		int i, j;
		for(i = 1; i < in.length; ++i) {
			int tmp = in[i];
			for(j = i-1; j >= 0; --j) {
				if(in[j] > tmp)
					in[j+1] = in[j];
				else
					break;
			}
			in[j+1] = tmp;
		}
	}
	
	//TC: O(n log n)
	//SC:O(log n)
	//D&C Recursion
	public static void sort4(int[] in) {
		auxSort4(in, 0, in.length-1);
	}
	private static void auxSort4(int[] in, int l, int r) {
		if(l >= r) return;
		int p = partition2(in, l, r);
		auxSort4(in, l, p-1);
		auxSort4(in, p+1, r);		
	}
	
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	//pivot selection: first element
	private static int partition1(int[] in, int l, int r) {
		int lastmin, current;
		int pivot = in[l];
		for(lastmin = l, current = l+1; current <= r; ++current) {
			if(in[current] < pivot)
				swap(in, ++lastmin, current);
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	
	//pivot selection: random element
	//other choices: median of three, median of medians, etc.,
	private static int partition2(int[] in, int l, int r) {
		int lastmin, current;
		
		Random rand = new Random();
		int rindex = l + rand.nextInt(r-l+1);
		swap(in, l, rindex);
		
		int pivot = in[l];
		for(lastmin = l, current = l+1; current <= r; ++current) {
			if(in[current] < pivot)
				swap(in, ++lastmin, current);
		}
		swap(in, l, lastmin);
		return lastmin;
	}
	
	//TC: O(n log n)
	//SC:O()
	//D&C Recursion
	public static void sort5(int[] in) {
		int[] aux = new int [in.length];
		auxSort5(in, 0, in.length-1, aux);
	}
	private static void auxSort5(int[] in, int l, int r, int[] aux) {
		if(l >= r) return;
		int m = (l + r) / 2;
		auxSort5(in, l, m, aux);
		auxSort5(in, m+1, r, aux);
		merge(in, l, m, r, aux);
	}
	private static void merge(int[] in, int ls, int le, int re, int[] aux) {
		int rs = le + 1;
		int k = 0;
		int sp = ls;
		//merge the elements from both left and right parts
		while(ls <= le && rs <= re) {
			if(in[ls] < in[rs])
				aux[k++] = in[ls++];
			else
				aux[k++] = in[rs++];			
		}
		//copy the remaining elements of left part
		while(ls <= le)
			aux[k++] = in[ls++];
		//copy the remaining elements of right part
		while(rs <= re)
			aux[k++] = in[rs++];	
		//copy back from aux to in
		for(int i = 0; i < k;)
			in[sp++] = aux[i++];
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		sort5(in);
		
		long end = System.currentTimeMillis();
		//System.out.println(Arrays.toString(in));
		System.out.println("Time taken:" + (end - start) / 1000.0 + " seconds");


	}

}
