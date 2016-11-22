package com.alg.top20.sorting;

import java.util.Iterator;
import java.util.PriorityQueue;
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
}
