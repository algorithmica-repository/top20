package com.alg.top20.greedy.filemerge;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

public class MinMergeCost {

	//TC:O(n^2 log n)
	//SC:O(n)
	public static int findMinMergeCost1(int[] in) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int e : in)
			list.add(e);
		int totcost = 0;
		while (list.size() > 1) {
			Collections.sort(list);
			int smallest1 = list.removeFirst();
			int smallest2 = list.removeFirst();
			totcost += (smallest1 + smallest2);
			list.add(smallest1 + smallest2);
		}
		return totcost;
	}
	
	//TC:O(n log n)
	//SC:O(n)
	//bug: how to retrieve duplicates correctly?
	public static int findMinMergeCost2(int[] in) {
		SortedMultiset<Integer> mset = TreeMultiset.create();
		for (int e : in)
			mset.add(e);
		int totcost = 0;

		while (mset.size() > 1) {
			System.out.println("iter:");
			int smallest1 = mset.pollFirstEntry().getElement();
			System.out.println("s1:" + smallest1);
			int smallest2 = mset.pollFirstEntry().getElement();
			System.out.println("s2:" + smallest2);
			totcost += (smallest1 + smallest2);
			mset.add(smallest1 + smallest2);
			System.out.println(mset);
		}
		return totcost;
	}
	
	//TC:O(n log n)
	//SC:O(n)
	public static int findMinMergeCost3(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int e : in)
			pq.add(e);
		int totcost = 0;

		while (pq.size() > 1) {
			int smallest1 = pq.poll();
			int smallest2 = pq.poll();
			totcost += (smallest1 + smallest2);
			pq.add(smallest1 + smallest2);
		}
		return totcost;
	}


	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		int [] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n)+1;
		System.out.println(Arrays.toString(in));
		System.out.println(findMinMergeCost1(in));
		System.out.println(findMinMergeCost3(in));

	}

}
