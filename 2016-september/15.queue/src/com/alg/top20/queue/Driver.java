package com.alg.top20.queue;

import java.util.Random;

public class Driver {

	public static void testQueue(IQueue queue, int size) {
		Random r = new Random(100);
		for(int i = 0; i < size; ++i) {
			queue.add(r.nextInt(100) + 1);
		}
		queue.display();
		System.out.println();
		System.out.println(queue.size());
		System.out.println(queue.remove());
		queue.display();
	}
	public static void main(String[] args) {
		testQueue(new LinkedQueue(), Integer.parseInt(args[0]));

	}

}
