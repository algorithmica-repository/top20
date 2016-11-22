package com.alg.top20.pqueue;

import java.util.Random;

public class Driver {

	public static void testPQueue(IPQueue pq, int size) {
		Random r = new Random(100);
		for(int i = 0; i < size; ++i) {
			pq.add(r.nextInt(100) + 1);
			pq.display();
			System.out.println();
		}
		for(int i = 1; i <=3; ++i) {
			System.out.println(pq.removeMax());
			pq.display();
			System.out.println();
		}

	}
	public static void main(String[] args) {
		testPQueue(new HeapPQueue(), Integer.parseInt(args[0]));

	}

}
