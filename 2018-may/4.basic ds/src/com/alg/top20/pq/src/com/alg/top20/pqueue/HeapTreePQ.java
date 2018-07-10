package com.alg.top20.pqueue;

import java.util.ArrayList;

public class HeapTreePQ implements IPQueue {
	private ArrayList<Integer> heaptree;

	public HeapTreePQ() {
		heaptree = new ArrayList<Integer>();
	}
	//batch construction of priority queue from input array 
	public HeapTreePQ(int[] in) {
		heaptree = new ArrayList<Integer>();
		//todo
	}

	// O(1)
	public Integer findMin() {
		if (isEmpty())
			return null;
		return heaptree.get(0);
	}

	//O(log n)
	public Integer removeMin() {
		if (isEmpty())
			return null;
		Integer res = heaptree.get(0);
		heaptree.set(0, heaptree.remove(heaptree.size() - 1));

		int current = 0;
		while (true) {
			int lchild = 2 * current + 1;
			int min_child_ind = lchild;
			int tmp;
			
			// if left child does not exist then break out
			if (lchild >= heaptree.size())
				break;
			// check for right child
			if (lchild + 1 < heaptree.size()) {
				// find min element among children
				tmp = heaptree.get(lchild).compareTo(
						heaptree.get(lchild + 1));
				if (tmp > 0)
					min_child_ind = lchild + 1;
			}

			// find whether order property satisfied or not
			tmp = heaptree.get(current).compareTo(heaptree.get(min_child_ind));
			if (tmp > 0) {
				swap(current, min_child_ind);
				current = min_child_ind;
			} else
				break;
		}

		return res;
	}

	// O(n)
	public void display() {
		System.out.println(heaptree);
	}

	// O(1)
	public int size() {
		return heaptree.size();
	}

	private void swap(int i, int j) {
		Integer tmp = heaptree.get(i);
		heaptree.set(i, heaptree.get(j));
		heaptree.set(j, tmp);
	}

	// TC:O(log n)
	public void add(Integer e) {
		heaptree.add(e);
		int current = heaptree.size() - 1;
		while (current > 0) {
			int res = heaptree.get(current).compareTo(
					heaptree.get((current - 1) / 2));
			if (res < 0) {
				swap(current, (current - 1) / 2);
				current = (current - 1) / 2;
			} else
				break;
		}
	}

	@Override
	public boolean isEmpty() {
		return heaptree.isEmpty();
	}

}
