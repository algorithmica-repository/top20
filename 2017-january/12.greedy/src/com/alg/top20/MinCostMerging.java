package com.alg.top20;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

import javax.print.attribute.standard.Finishings;

import com.google.common.collect.TreeMultiset;

public class MinCostMerging {

	// explore all possible mergings and return optimal one
	//TC:O()  SC:O(1)
	public static int minCostMerge1(int[] in) {
		return 0;
	}

	//TC:O(n ^ 2 log n)  SC:O(n)
	public static int minCostMerge2(int[] in) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int e : in)
			list.add(e);
		int totMergeCost = 0;

		while (list.size() > 1) {
			Collections.sort(list);
			int s1 = list.removeFirst();
			int s2 = list.removeFirst();
			int tmp = s1 + s2;
			totMergeCost += tmp;
			list.add(tmp);
		}
		return totMergeCost;
	}
	
	private static int mergeTwoSmallest(LinkedList<Integer> list) {
		int s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
		for(int e: list) {
			if(e < s1) {
				s2 = s1;
				s1 = e;
			} else if(e < s2){
				s2 = e;
			}				
		}
		//System.out.println(list);
		//System.out.println(s1 + " " + s2);
		list.removeFirstOccurrence(s1);
		list.removeFirstOccurrence(s2);
		return s1+s2;		
	}
	//TC:O(n ^ 2) SC:O(n)
	public static int minCostMerge3(int[] in) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int e : in)
			list.add(e);
		int totMergeCost = 0;

		while (list.size() > 1) {			
			int tmp = mergeTwoSmallest(list);
			totMergeCost += tmp;
			list.add(tmp);
		}
		return totMergeCost;
	}
	
	//TC:O(n log n) SC:O(n)
	public static int minCostMerge4(int[] in) {
		TreeMultiset<Integer> tree_bag = TreeMultiset.create();
		for (int e : in)
			tree_bag.add(e);
		int totMergeCost = 0;

		while (tree_bag.size() > 1) {
			//System.out.println(tree_bag);
			int val1 = tree_bag.firstEntry().getElement();
			tree_bag.remove(val1, 1);
			int val2 = tree_bag.firstEntry().getElement();
			tree_bag.remove(val2, 1);
			int tmp = val1 + val2;
			totMergeCost += tmp;
			tree_bag.add(tmp);
		}
		return totMergeCost;
	}
	//TC:O(n log n) SC:O(n)
	public static int minCostMerge5(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int e : in)
			pq.add(e);
		int totMergeCost = 0;

		while (pq.size() > 1) {
			int val1 = pq.remove();
			int val2 = pq.remove();
			int tmp = val1 + val2;
			totMergeCost += tmp;
			pq.add(tmp);
		}
		return totMergeCost;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];

		Random r = new Random();
		for (int i = 0; i < in.length;++i)
			in[i] = r.nextInt(10) + 1;
		
		//System.out.println(Arrays.toString(in));
		//System.out.println(minCostMerge2(in));
		System.out.println(minCostMerge3(in));
		System.out.println(minCostMerge4(in));
		//System.out.println(minCostMerge5(in));

	}

}
