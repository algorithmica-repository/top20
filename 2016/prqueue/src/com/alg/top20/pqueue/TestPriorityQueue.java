package com.alg.top20.pqueue;

import java.util.Random;

public class TestPriorityQueue {

	public static void testIncrementalHeap(int size) {
		long start = System.nanoTime();
		IPriorityQueue pq = new HeapPrqueue();
		Random r = new Random();
		for (int i = 0; i < size; ++i) {
			int tmp = r.nextInt(1000000) + 1;
			pq.add(tmp);
		}
		System.out.println(pq.size());
		// pq.display();
		long end = System.nanoTime();
		System.out.println(end-start);
	}

	public static void testBatchHeap(int size) {
		long start = System.nanoTime();
		Integer[] in = new Integer[size];
		Random r = new Random();
		for (int i = 0; i < size; ++i) {
			int tmp = r.nextInt(1000000) + 1;
			in[i] = tmp;
		}
		IPriorityQueue pq = new HeapPrqueue(in);
		System.out.println(pq.size());
		// pq.display();
		long end = System.nanoTime();
		System.out.println(end-start);
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		testIncrementalHeap(size);
		//testBatchHeap(size);
	}

}
