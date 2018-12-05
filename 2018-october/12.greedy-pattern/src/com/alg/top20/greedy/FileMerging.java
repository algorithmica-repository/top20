package com.alg.top20.greedy;

import java.util.PriorityQueue;

public class FileMerging {

	// naive
	public static int minMergeCost1(int[] in) {
		return 0;
	}

	// greedy
	public static int minMergeCost2(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		int totcost = 0;
		while (pq.size() > 1) {
			int smallest1 = pq.remove();
			int smallest2 = pq.remove();
			totcost += (smallest1 + smallest2);
			pq.add(smallest1 + smallest2);
		}
		return totcost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
