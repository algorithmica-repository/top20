package com.alg.top20.dsdesign.queue;

import java.util.Random;

public class TestQueue {

	public static void main(String[] args) {
		Queue q = new Queue();
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		for(int i = 0; i < n; ++i) {
			q.enqueue(r.nextInt(n));
			q.display();
		}
		q.dequeue();
		q.display();
	}

}
