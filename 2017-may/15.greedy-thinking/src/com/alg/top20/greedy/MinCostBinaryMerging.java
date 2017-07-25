package com.alg.top20.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class MinCostBinaryMerging {

	// TC: n + <= (3 * log n * n-1)
	// TC:O(n log n)  SC:O(n)
	public static long minCostMerge1(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < in.length; ++i)
			pq.add(in[i]);
		long mincost = 0;
		while (pq.size() > 1) {
			int min1 = pq.remove();
			int min2 = pq.remove();
			mincost += (min1 + min2);
			pq.add(min1 + min2);
		}
		return mincost;
	}

	// TC: n + <= (n-1 * n log n)
	// TC:O(n^2 log n) SC:O(n)
	public static long minCostMerge2(int[] in) {
		long mincost = 0;
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < in.length; ++i)
			list.add(in[i]);

		while (list.size() > 1) {
			Collections.sort(list);
			int min1 = list.removeFirst();
			int min2 = list.removeFirst();
			mincost += (min1 + min2);
			list.add(min1 + min2);
		}
		return mincost;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i) {
			in[i] = r.nextInt(n) + 1;
		}
		System.out.println(Arrays.toString(in));
		System.out.println(minCostMerge1(in));
		System.out.println(minCostMerge2(in));
	}

}
