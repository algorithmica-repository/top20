package com.collections;

import java.util.ArrayList;

/**
 * @author Srinivas Reddy
 * @email srinivas96alluri@gmail.com
 */

public class HPriorityQueue<T> implements PriorityQueue<T> {

	private ArrayList<T> heap;

	public HPriorityQueue() {
		heap = new ArrayList<T>();
	}

	@Override
	public boolean add(T data) {

		heap.add(data);
		int current = size() - 1;

		// Bottom-Up heap adjustment strategy
		while (current > 0) {

			int parent = (current - 1) >> 1;
			int maxChild = findMaxChild(parent);

			// compare the max child with parent
			if (getDiff(parent, maxChild) < 0) {
				// Swap max child node with parent
				swap(parent, maxChild);
			}
			current = parent;
		}

		return (current == 0);
	}

	private void swap(int node1, int node2) {

		T temp = heap.get(node1);
		heap.set(node1, heap.get(node2));
		heap.set(node2, temp);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private int getDiff(int index1, int index2) {
		return ((Comparable) heap.get(index1)).compareTo(heap.get(index2));
	}

	private int findMaxChild(int parent) {

		int lastIndex = size() - 1;
		int leftIndex = (parent << 1) + 1;

		if (lastIndex > leftIndex) {
			return (getDiff(leftIndex, leftIndex + 1) > 0 ? leftIndex
					: (leftIndex + 1));
		} else if (lastIndex == leftIndex) {
			return leftIndex;
		}
		return -1; // return -1 because it don't have any child
	}

	@Override
	public T remove() {

		int lastIndex = size() - 1;

		if (lastIndex < 0) {
			return null;
		}

		// Save root element to return
		T returnVal = heap.get(0);

		// Move last element to root
		// post decrement index because element is removing
		heap.set(0, heap.remove(lastIndex--));

		// adjust tree for balancing from root to leaf
		int parent = 0, lastParent = (lastIndex - 1) >> 1, maxChild;

		while (parent <= lastParent) {
			maxChild = findMaxChild(parent);

			// Swap the parent and max child if diff is less than zero
			if (getDiff(parent, maxChild) < 0) {
				swap(parent, maxChild);
				parent = maxChild;
			} else {
				break;
			}
		}

		return returnVal;
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
