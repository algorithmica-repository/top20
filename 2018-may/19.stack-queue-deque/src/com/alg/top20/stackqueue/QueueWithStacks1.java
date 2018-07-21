package com.alg.top20.stackqueue;

import java.util.Random;
import java.util.Stack;

public class QueueWithStacks1 {
	private Stack<Integer> st1;
	private Stack<Integer> st2;
	
	public QueueWithStacks1() {
		st1 = new Stack<Integer>();
		st2 = new Stack<Integer>();
	}
	//O(1)
	public void enqueue(int x) {
		st1.push(x);
	}
	//O(n) ~ 4n operations
	public int dequeue() {
		if(st1.isEmpty()) return Integer.MIN_VALUE;
		while(! st1.isEmpty())
			st2.push(st1.pop());
		int res = st2.pop();
		while(! st2.isEmpty())
			st1.push(st2.pop());
		return res;
	}
	
	public void display() {
		System.out.println(st1);
	}
	public static void main(String[] args) {
		QueueWithStacks1 q = new QueueWithStacks1();
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
