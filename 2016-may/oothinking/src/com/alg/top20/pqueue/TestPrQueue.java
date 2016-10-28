package com.alg.top20.pqueue;

import java.util.Random;

public class TestPrQueue {

	public static void test1(IPQueue pq, int size) {
		Random r= new Random(100);
		for(int i = 0; i < size; ++i){
			int re = r.nextInt(10) + 1;
			System.out.println(re);
			pq.add(re);
			pq.display();
		}
		//pq.display();
	}
	
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
	    IPQueue pq = new HeapPQueue();
	    test1(pq, size);
	}

}
