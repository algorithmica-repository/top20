package com.alg.top20.pqueue;

import java.util.ArrayList;

public class HeapPQueue implements IPQueue {
	private ArrayList<Integer> heap;

	public HeapPQueue() {
		heap = new ArrayList<Integer>();
	}

	private void swap(int i, int j) {
		int tmp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, tmp);
	}
	//O(log n)
	@Override
	public void add(Integer e) {
		heap.add(e);
		int current = heap.size() - 1;

		//adjust the last element move up to right position
		while (current > 0) {
			int parent = (current - 1) / 2;
			if (heap.get(parent) < heap.get(current)) {
				swap(parent, current);
				current = parent;
			} else
				break;
		}
	}

	//O(1)
	@Override
	public Integer findMax() {
		return heap.get(0);
	}

	//O(log n)
	@Override
	public Integer removeMax() {
		Integer tmp = heap.get(0);
		heap.set(0, heap.remove(heap.size()-1));
		int current = 0;
		
		//adjust heap by moving root element down to the right position
		while(true) {
			int lc_ind = 2*current+1;
			int rc_ind = 2*current+2;
			if(lc_ind >= heap.size())
				break;
			int max_ind = lc_ind;
			if(rc_ind < heap.size() && heap.get(rc_ind) > heap.get(lc_ind))
				max_ind = rc_ind;
			
			if (heap.get(current) < heap.get(max_ind)) {
				swap(current, max_ind);
				current = max_ind;
			} else
				break;
		}
		
		return tmp;
	}

	//O(1)
	@Override
	public int size() {
		return heap.size();
	}

	//O(n)
	@Override
	public void display() {
		for (int i = 0; i < heap.size(); ++i)
			System.out.print(heap.get(i) + " ");

	}

}
