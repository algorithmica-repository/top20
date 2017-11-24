package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

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
	public static void sort2(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int e:in) 
			pq.add(e);
		int i = 0;
		while(! pq.isEmpty())
			in[i++] = pq.remove();
	}
	
	//TC: O(n^2)
	//SC:O(1)
	public static void sort3(int[] in) {
		for(int i = 1; i < in.length; ++i) {
			int tmp = in[i];
			for(int j = i-1; j >= 0; --j) {
				if(in[j] > tmp)
					in[i] = in[j];
				else
					break;
			}
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		//System.out.println(Arrays.toString(in));
	
		long start = System.currentTimeMillis();
		sort2(in);
		long end = System.currentTimeMillis();
		//System.out.println(Arrays.toString(in));
		System.out.println("Time taken:" + (end - start) / 1000.0 + " seconds");


	}

}
