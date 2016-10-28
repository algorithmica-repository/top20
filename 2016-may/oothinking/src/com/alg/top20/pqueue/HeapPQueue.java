package com.alg.top20.pqueue;

import java.util.ArrayList;

public class HeapPQueue implements IPQueue {
	private ArrayList<Integer> heap;
	
	public HeapPQueue() {
		heap = new ArrayList<Integer>();
	}

	private void swap(int current, int parent) {
		Integer tmp = heap.get(current);
		heap.set(current, heap.get(parent));
		heap.set(parent,tmp);
	}

	@Override
	public void add(Integer key) {
		heap.add(key);
		int current = heap.size() - 1;
		while (current > 0) {
			int parent = (current - 1) / 2;
			int res = heap.get(current).compareTo(heap.get(parent));
			if (res < 0) {
				swap(current, parent);
				current = parent;
			} else
				break;
		}

	}

	@Override
	public Integer removeMin() {
		//Fill the logic 
		return null;
	}

	@Override
	public Integer findMin() {
		if (heap.isEmpty())
			return null;
		return heap.get(0);
	}

	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public void display() {
		System.out.println(heap);
	}

}
