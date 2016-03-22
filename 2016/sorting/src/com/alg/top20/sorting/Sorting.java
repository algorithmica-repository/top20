package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Sorting {
	private static Random r = new Random(100);

	public static void insertionSort(int[] in) {
		int tmp = 0, i, j;
		for (i = 1; i < in.length; ++i) {
			tmp = in[i];
			for (j = i - 1; j >= 0; --j) {
				if (in[j] > tmp) {
					in[j + 1] = in[j];
				} else {
					in[j + 1] = tmp;
					break;
				}
			}
			if (j == -1)
				in[j + 1] = tmp;
		}
	}

	private static void merge(int[] in, int ls, int le, int re, int[] tmp) {
		int i = ls, j = le + 1, k = 0;
		while (i <= le && j <= re) {
			if (in[i] < in[j])
				tmp[k++] = in[i++];
			else
				tmp[k++] = in[j++];
		}
		while (i <= le) {
			tmp[k++] = in[i++];
		}
		while (j <= re) {
			tmp[k++] = in[j++];
		}
		i = 0;
		while (i < k) {
			in[ls++] = tmp[i++];
		}
	}

	private static void auxMergeSort(int[] in, int l, int r, int[] tmp) {
		if (l == r)
			return;
		int m = (l + r) / 2;
		auxMergeSort(in, l, m, tmp);
		auxMergeSort(in, m + 1, r, tmp);
		merge(in, l, m, r, tmp);
	}

	public static void mergeSort(int[] in) {
		int[] tmp = new int[in.length];
		auxMergeSort(in, 0, in.length - 1, tmp);
	}
	
	public static void heapSort(Integer[] in) {
		List<Integer> in1 = Arrays.asList(in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(in1);
		for(int i = 0; i < in.length; ++i) {
			in[i] = pq.remove();
		}
	}
	private static int custom_rand(int l, int r) {
		return l;
	}
	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	
	private static int partition(int[] in , int l, int r) {
		int lastmin, current;
		swap(in,l,custom_rand(l,r));
		for(lastmin=l, current=l+1; current <= r; ++current) {
			if(in[current] <  in[l]) {
				swap(in,++lastmin,current);
			}
		}
		swap(in, lastmin, l);
		return lastmin;
	}
	
	private static void auxquicksort(int[] in, int l, int r) {
		if(l>=r) return;
		int p = partition(in,l,r);
		auxquicksort(in, l, p-1);
		auxquicksort(in, p+1, r);
	}

	public static void quickSort(int[] in) {
		auxquicksort(in,0,in.length-1);
	}
	public static void main(String[] args) {
		Random r = new Random();
		int size = Integer.parseInt(args[0]);
		int[] in = new int[size];
		for (int i = 0; i < size; ++i) {
			in[i] = r.nextInt(100000000) + 1;
		}
		/*for(int i  = size; i >= 1; --i)
			in[size-i] = i;*/
		//for(int e:in) System.out.print(e + " ");
		//System.out.println();
		long start = System.currentTimeMillis();
		quickSort(in);
		long end = System.currentTimeMillis();
		
		//for(int e:in) System.out.print(e + " ");
		 
		// System.out.println();
		System.out.println((float)(end - start) / 1000);
	}

}
