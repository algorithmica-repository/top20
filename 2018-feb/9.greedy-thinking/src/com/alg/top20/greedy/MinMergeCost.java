package com.alg.top20.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

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
		while(pq.size() > 1) {
			int f1 = pq.remove();
			int f2 = pq.remove();
			pq.add(f1+f2);
			totcost += (f1+f2);
		}
		return totcost;
	}
	//TC:O(n log n)  SC:O(n)
	//TODO: fix for duplicate access
	public static int findMinMergeCost3(int[] in) {
		SortedMultiset<Integer> tset = TreeMultiset.create();
		for(int e:in)
			tset.add(e);
		int totcost = 0;
		while(tset.size() >= 1) {
			int f1 = tset.pollFirstEntry().getElement();
			int f2 = tset.pollFirstEntry().getElement();
			tset.add(f1+f2);
			totcost += (f1+f2);
		}
		return totcost;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i) {
			in[i]= r.nextInt(100) + 1;
		}
		System.out.println(Arrays.toString(in));
		System.out.println(findMinMergeCost1(in));
		System.out.println(findMinMergeCost2(in));
		System.out.println(findMinMergeCost3(in));
		
	}

}
