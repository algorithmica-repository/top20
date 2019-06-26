package com.alg.top20.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class FileMerging {

	public static int minCost1(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		int totcost = 0;
		while (pq.size() > 1) {
			int min1 = pq.remove();
			int min2 = pq.remove();
			totcost += (min1 + min2);
			pq.add(min1 + min2);
		}
		return totcost;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for (int i = 0; i < n; ++i)
			in[i] = r.nextInt(10);
		//System.out.println(Arrays.toString(in));
		System.out.println(minCost1(in));

	}

}
