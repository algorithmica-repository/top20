package com.alg.top20.stackqueue;

import java.util.Random;
import java.util.Stack;

public class QueueWithStacks2 {
	private Stack<Integer> st1;
	private Stack<Integer> st2;
	
	public QueueWithStacks2() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}
	//O(1)
	public void enqueue(int x) {
		st1.push(x);
	}
	//O(1) am
	public int dequeue() {
		if(st2.isEmpty()) {
			if(st1.isEmpty()) return Integer.MIN_VALUE;
			while(! st1.isEmpty())
				st2.push(st1.pop());
		}
		int res = st2.pop();
		return res;
	}
	
	public void display() {
		System.out.print(st2 +" ");
		System.out.print(st1 +" ");
		System.out.println();
	}
	public static void main(String[] args) {
		QueueWithStacks2 q = new QueueWithStacks2();
		Random r = new Random(100);
		for(int i = 1; i <= 10; ++i) {
			q.enqueue(r.nextInt(100));
			q.display();
		}
		q.dequeue();
		q.display();
		q.dequeue();
		q.display();
	}

}
