package com.alg.top20.parallelism.mt.sorting;

import java.util.Arrays;
import java.util.Random;

class SubSorter extends Thread {
	private int start;
	private int end;
	private int[] array;
	
	public SubSorter(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	public void run() {
		for(int i = start; i < end; ++i) {
			int min_ind = i;
			for(int j = i+1; j <= end; ++j) {
				if(array[j] < array[min_ind])
					min_ind = j;
			}
			swap(array, i, min_ind);
		}
	}
	
}


public class ParallelSorter {
	
	public static void merge() {
		//merge k sorted arrays into one using priority queue
	}
	
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];

		Random r = new Random();
		for (int i = 0; i < in.length;++i)
			in[i] = r.nextInt(5*n) + 1;
		
		//System.out.println(Arrays.toString(in));
		//sort the parts of the array in parallel
		int nthreads = 5;
		int size = n / nthreads;
		Thread[] threads = new Thread[nthreads];
		for(int i = 0; i < nthreads; ++i) {
			int start = i * size;
			int end = start + size - 1;
			//System.out.println(start + ":"+end);
			threads[i] = new SubSorter(in, start, end);
			threads[i].start();
		}
		for(int i = 0; i < nthreads; ++i) 
			threads[i].join();
		//System.out.println(Arrays.toString(in));
		//merge the parts of the array in sequential fashion
		merge();		
	}

}
