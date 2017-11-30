package com.alg.top20.heap;

import java.util.Random;

public class MinHeap {
	private int[] array;
	private int size;
	
	public MinHeap(int[] array) {
		this.array = array;
		this.size = array.length;
	}
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	private void adjustMinHeapUp(int i) {
		int current = i;
		while (current > 0) {
			if (array[current] < array[current / 2]) {
				swap(array, current, current / 2);
				current = current / 2;
			} else
				break;
		}
	}
	//TC:O(n log n)
	public void buildMinHeapIncr() {
		for (int i = 1; i < array.length; ++i)
			adjustMinHeapUp(i);
	}

	// TC:O(n)
	public void buildMinHeapBatch() {
		for(int i = size/2-1; i >= 0; --i)
			adjustHeapDown(i);
	}
	//batch heap construction with recursion
	public void buildMinHeapBatchR() {
		auxBatchR(0);
	}
	private boolean isLeaf(int i) {
		return 2*i+1 >= size;
	}
	private void auxBatchR(int i) {
		if(isLeaf(i)) return;
		auxBatchR(2*i+1);
		auxBatchR(2*i+2);
		adjustHeapDown(i);
	}

	public void adjustHeapDown(int i) {
		int current = i;

		while (! isLeaf(current)) {
			int leftChild = 2 * current + 1;
			int minChild = leftChild;
			if (leftChild + 1 < size && array[leftChild + 1] < array[minChild])
				minChild = leftChild + 1;

			// compare the minchild value with parent
			if (array[minChild] < array[current]) {
				swap(array, minChild, current);
				current = minChild;
			} else
				break;
		}
	}

	public int removeMin() {
		int res = array[0];
		array[0] = array[--size];
		adjustHeapDown(0);
		return res;
	}

	public void display() {
		for (int i = 0; i < size; ++i)
			System.out.print(array[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random(100);
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n)+1;
		MinHeap heap = new MinHeap(in);
		heap.display();
		heap.buildMinHeapIncr();
		heap.display();
		heap.removeMin();
		heap.display();
	}

}
