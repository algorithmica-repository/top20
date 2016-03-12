package com.alg.top20.pqueue;

import java.util.ArrayList;
import java.util.List;

public class HeapPrqueue implements IPriorityQueue {
	private List<Integer> heap;

	public HeapPrqueue() {
		heap = new ArrayList<Integer>();
	}
	
	private void adjustHeap(int i) {
		int current = i;

		while ( (2*current+1) < heap.size()) {
			int minchild = 2 * current + 1;
			if (minchild+1 < heap.size() && heap.get(minchild+1) < heap.get(minchild))
				++minchild;
			if (heap.get(minchild) < heap.get(current)) {
				int tmp1 = heap.get(minchild);
				heap.set(minchild, heap.get(current));
				heap.set(current, tmp1);
				current = minchild;
			} else
				break;
		}
	}
	
	public HeapPrqueue(List<Integer> in) {
		heap = in;
		for(int i = (heap.size()-2)/2; i >= 0; --i) {
			adjustHeap(i);
		}
	}

	@Override
	public int size() {
		return heap.size();
	}

	@Override
	public void display() {
		System.out.println(heap);
	}

	@Override
	public void add(Integer e) {
		heap.add(e);
		int current = heap.size() - 1;
		while (true) {
			int curdata = heap.get(current);
			int pardata = heap.get((current - 1) / 2);
			if (curdata < pardata) {
				heap.set(current, pardata);
				heap.set((current - 1) / 2, curdata);
				current = (current - 1) / 2;
			} else
				break;
		}
	}

	@Override
	public Integer findMin() {
		if (heap.isEmpty())
			return null;
		return heap.get(0);
	}

	@Override
	public Integer removeMin() {
		if (heap.isEmpty())
			return null;
		int tmp = heap.get(0);
		heap.set(0, heap.remove(heap.size() - 1));
		int current = 0;

		while ( (2*current+1) < heap.size()) {
			int minchild = 2 * current + 1;
			if (minchild+1 < heap.size() && heap.get(minchild+1) < heap.get(minchild))
				++minchild;
			if (heap.get(minchild) < heap.get(current)) {
				int tmp1 = heap.get(minchild);
				heap.set(minchild, heap.get(current));
				heap.set(current, tmp1);
				current = minchild;
			} else
				break;
		}
		return tmp;
	}

}
