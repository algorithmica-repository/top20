package com.alg.top20.dsdesign.superqueue;

import java.util.Random;

import com.alg.top20.dsdesign.superstack.SuperStack;

public class TestSuperQueue {

	public static void main(String[] args) {
		SuperQueue sq = new SuperQueue();
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		for(int i = 0; i < n; ++i) {
			sq.enqueue(r.nextInt(n));
			sq.display();
		}
		System.out.println(sq.findMin());
		sq.dequeue();
		sq.display();
		System.out.println(sq.findMin());

	}

}
