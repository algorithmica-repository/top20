package com.alg.top20.heap;

import java.util.Random;

public class MaxHeap {
	private int[] array;
	private int size;
	
	public MaxHeap(int[] array) {
		this.array = array;
		this.size = array.length;
	}
	private void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	private void adjustMaxHeapUp(int i) {
		int current = i;
		while (current > 0) {
			if (array[current] > array[current / 2]) {
				swap(array, current, current / 2);
				current = current / 2;
			} else
				break;
		}
	}

	// TC:O(n log n) ~ log 1 + log 2 +...+ log n-1
	public void buildMaxHeapIncr() {
		for (int i = 1; i < array.length; ++i)
			adjustMaxHeapUp(i);
	}
	// TC:O(n)
	public void buildMaxHeapBatch() {
		for(int i = size/2-1; i >= 0; --i)
			adjustHeapDown(i, size);
	}

	private boolean isLeaf(int i, int n) {
		return 2*i+1 >= n;
	}
	public void adjustHeapDown(int i, int n) {
		int current = i;

		while (! isLeaf(current, n)) {
			// find max children of node i
			int leftChild = 2 * current + 1;
			int maxChild = leftChild;
			if (leftChild + 1 < n && array[leftChild + 1] > array[maxChild])
				maxChild = leftChild + 1;

			// compare the maxchild value with parent
			if (array[maxChild] > array[current]) {
				swap(array, maxChild, current);
				current = maxChild;
			} else
				break;
		}

	}

	// TC:O(n log n)
	public void sort() {
		for (int i = size-1; i > 0; --i) {
			swap(array, 0, i);
			adjustHeapDown(0, i);
			display();
		}
	}
	public int size() {
		return size;
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
		MaxHeap heap = new MaxHeap(in);
		heap.display();
		heap.buildMaxHeapIncr();
		heap.display();
		heap.sort();
		//heap.display();
	}

}
