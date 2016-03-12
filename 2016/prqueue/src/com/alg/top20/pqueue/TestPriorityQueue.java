package com.alg.top20.pqueue;

import java.util.Random;

public class TestPriorityQueue {

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		IPriorityQueue pq = new HeapPrqueue();
		Random r = new Random();
		for(int i = 0; i < size; ++i) {
			int tmp = r.nextInt(1000000) + 1;
			System.out.print(tmp + " ");
			pq.add(tmp);
		}
		System.out.println();
		pq.display();
	}

}
