package com.alg.top20.mt;


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Sorting {

	public static void insertionSort(int[] in,int l, int r) {
		int tmp = 0, i, j;
		for (i = l+1; i <= r; ++i) {
			tmp = in[i];
			for (j = i - 1; j >= l; --j) {
				if (in[j] > tmp) {
					in[j + 1] = in[j];
				} else {
					in[j + 1] = tmp;
					break;
				}
			}
			if (j == l-1)
				in[j + 1] = tmp;
		}
	}
	
	public static class SortingThread extends Thread {
		private int[] in;
		private int l;
		private int r;
		
		public SortingThread(int[] in, int l, int r) {
			this.in = in;
			this.l = l;
			this.r = r;
		}

		@Override
		public void run() {
			insertionSort(in, l, r);
		}
		
	}
	
	public static void testParallel(int[] in) throws Exception {
		long start = System.currentTimeMillis();
		int l = 0, part = in.length / 4;
		Thread[] t = new SortingThread[4];
		for(int i = 0; i < 4; ++i) {
			t[i] = new SortingThread(in,l,l+part-1);
			l = l + part;
		}
		for(int i = 0; i < 4; ++i) {
			t[i].start();
		}
		for(int i = 0; i < 4; ++i) {
			t[i].join();
		}
		//merge the sorted arrays
		long end = System.currentTimeMillis();
		System.out.println((float)(end - start) / 1000);
		//System.out.println(Arrays.toString(in));
	}
	
	public static void testSequential(int[] in) {
		long start = System.currentTimeMillis();
		insertionSort(in,0,in.length-1);
		long end = System.currentTimeMillis();
		System.out.println((float)(end - start) / 1000);
		//System.out.println(Arrays.toString(in));
	}

	public static void main(String[] args) throws Exception {
		int size = Integer.parseInt(args[0]);
		int[] in = new int[size];
		for(int i  = size; i >= 1; --i)
			in[size-i] = i;
		//testSequential(in);
		testParallel(in);
	}

}
