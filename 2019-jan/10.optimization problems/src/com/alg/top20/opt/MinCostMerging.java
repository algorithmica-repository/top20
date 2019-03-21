package com.alg.top20.opt;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinCostMerging {

	public static int merge11(int[] in) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int x : in)
			list.add(x);
		int totcost = 0;
		while (list.size() > 1) {
			Collections.sort(list);
			int smallest1 = list.removeFirst();
			int smallest2 = list.removeFirst();
			list.add(smallest1 + smallest2);
			totcost += (smallest1 + smallest2);
		}
		return totcost;
	}

	public static int merge12(int[] in) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int x : in)
			list.add(x);
		int totcost = 0;
		Collections.sort(list);
		while (list.size() > 1) {
			int smallest1 = list.removeFirst();
			int smallest2 = list.removeFirst();
			int tmp = smallest1 + smallest2;
			for(int i = 0; i < list.size(); ++i) {
				if(tmp > list.get(i)) {
					list.add(i, tmp);
					break;
				}
			}
			totcost += tmp;
		}
		return totcost;
	}
	
	public static int merge13(int[] in) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int x : in)
			pq.add(x);
		int totcost = 0;
		while (pq.size() > 1) {
			int smallest1 = pq.remove();
			int smallest2 = pq.remove();
			int tmp = smallest1 + smallest2;
			pq.add(tmp);
			totcost += tmp;
		}
		return totcost;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
