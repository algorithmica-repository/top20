package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

class Mycomparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return -o1.compareTo(o2);
	}

}

public class MinCostMerging {

	public static int minCostMerging11(int[] in) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int x : in)
			list.add(x);
		Collections.sort(list);
		int tot = 0;
		while (list.size() > 1) {
			int smallest1 = list.remove(0);
			int smallest2 = list.remove(0);
			list.add(smallest1 + smallest2);
			tot += (smallest1 + smallest2);
			Collections.sort(list);
		}
		return tot;
	}
	
	public static int minCostMerging12(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		int tot = 0;
		while (pq.size() > 1) {
			int smallest1 = pq.remove();
			int smallest2 = pq.remove();
			pq.add(smallest1 + smallest2);
			tot += (smallest1 + smallest2);
		}
		return tot;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; ++i) 
			in[i] = r.nextInt(10)+1;
		System.out.println(Arrays.toString(in));
		System.out.println(minCostMerging11(in));
		System.out.println(minCostMerging12(in));


	}

}
