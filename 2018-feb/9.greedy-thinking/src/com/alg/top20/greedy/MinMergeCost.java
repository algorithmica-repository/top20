package com.alg.top20.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import com.google.common.collect.SortedMultiset;

public class MinMergeCost {

	//TC:O(n^2 log n)  SC:O(n)
	public static int findMinMergeCost1(int[] in) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int e: in)
			list.add(e);
		int totcost = 0;
		Collections.sort(list);
		for(int i = 1; i < in.length; ++i) {
			int f1 = list.removeFirst();
			int f2 = list.removeFirst();
			list.add(f1+f2);
			totcost += (f1+f2);
			Collections.sort(list);
		}
		return totcost;	
	}
	
	//TC:O(n log n)  SC:O(n)
	public static int findMinMergeCost2(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int e:in)
			pq.add(e);
		int totcost = 0;
		for(int i = 1; i < in.length; ++i) {
			int f1 = pq.remove();
			int f2 = pq.remove();
			pq.add(f1+f2);
			totcost += (f1+f2);
		}
		return totcost;
	}
	//TC:O(n log n)  SC:O(n)
	public static int findMinMergeCost3(int[] in) {
		SortedMultiset<Integer> mset = null;
		for(int e:in)
			pq.add(e);
		int totcost = 0;
		for(int i = 1; i < in.length; ++i) {
			int f1 = pq.remove();
			int f2 = pq.remove();
			pq.add(f1+f2);
			totcost += (f1+f2);
		}
		return totcost;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
