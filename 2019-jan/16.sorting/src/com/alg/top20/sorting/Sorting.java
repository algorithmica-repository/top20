package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.TreeSet;

public class Sorting {

	private static void swap(int[] in, int i , int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}
	public static void sort1(int[] in) {
		for(int i = 0; i < in.length; ++i) {
			int mini = i;
			for(int j = i + 1; j < in.length; ++j) {
				if(in[j] < in[mini])
					mini = j;
			}
			swap(in, i, mini);
		}
	}
	public static void sort2(int[] in) {
		TreeSet<Integer> tset = new TreeSet<Integer>();
		for(int i = 0; i < in.length; ++i)
			tset.add(in[i]);
		int i = 0;
		for(int x:tset)
			in[i++] = x;
	}
	
	public static void sort3(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < in.length; ++i)
			pq.add(in[i]);
		for(int i = 0; i < in.length; ++i)
			in[i] = pq.remove();
	}
	
	public static void sort4(int[] in) {
		int[] aux = new int[in.length];
		auxsort4(in, 0, in.length-1, aux);
	}
	private static void merge(int[] in, int l, int m, int r, int[] aux) {
		int i = l, j = m+1, k = 0;
		while(i <= m && j <= r) {
			if(in[i] < in[j])
				aux[k++] = in[i++];
			else
				aux[k++] = in[j++];
		}
		while(i <= m)
			aux[k++] = in[i++];
		while(j <= r)
			aux[k++] = in[j++];
		for(i = 0 ; i < k; ++i)
			 in[l++] = aux[i];
	}
	private static void auxsort4(int[] in, int l, int r, int[] aux) {
		if(l >= r) return;
		int m = l + (r-l)/2;
		auxsort4(in, l, m, aux);
		auxsort4(in, m+1, r, aux);
		merge(in, l, m, r, aux);
	}
	
	private static int partition(int[] in, int l, int r) {
		int lastmin, current;
		for (lastmin = l, current = l; current <= r; ++current) {
			if (in[current] < in[l])
				swap(in, ++lastmin, current);
		}
		swap(in, lastmin, l);
		return lastmin;
	}
	public static void sort5(int[] in) {
		auxsort5(in, 0, in.length-1);
	}
	private static void auxsort5(int[] in, int l, int r) {
		if(l >= r) return ;
		int p = partition(in, l, r);
		auxsort5(in, l, p-1);
		auxsort5(in, p+1, r);		
	}

	public static void shuffle(int[] in) {
		Random r = new Random();
		for(int i = in.length-1; i > 0; --i) {
			int tmp = r.nextInt(i+1);
			swap(in, i, tmp);
		}
	}
	
	public static void sort6(int[] in) {
		int k = findNumberOfPasses(in);
		int divisor = 1;
		for(int d = 0; d < k; ++d) {
			auxsort6(in, d, divisor);
			//System.out.println(Arrays.toString(in));
			divisor *= 10;
		}
	}
	private static int findNumberOfPasses(int[] in) {
		int max = 0;
		for(int i = 0; i < in.length; ++i)
			max = Math.max(max, in[i]);
		int k = 0;
		while(max > 0) {
			max = max / 10;
			++k;
		}
		return k;
	}
	private static void auxsort6(int[] in, int d, int divisor) {
		int[] aux = new int[10];
		int[] out = new int[in.length];
		for(int i = 0; i < in.length; ++i) {
			int index = (in[i] / divisor) % 10;
			++aux[index];
		}
		for(int i = 1; i < 10; ++i)
			aux[i] += aux[i-1];
		for(int i = in.length-1; i >= 0; --i) {
			int index = (in[i] / divisor) % 10;
			out[--aux[index]] = in[i];
		}
		for(int i = 0; i < in.length; ++i)
			in[i] = out[i];
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i + 1;
		shuffle(in);
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		sort6(in);
		long end = System.currentTimeMillis();
		//System.out.println(Arrays.toString(in));
		System.out.println("Time:" + (end-start)/1000.0 + " secs");
	}

}
