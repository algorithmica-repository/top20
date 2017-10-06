package com.alg.top20.dsdesign.queue;

import java.util.Stack;

public class Queue {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public Queue() {
		stack1 = new Stack<Integer>();
		stack2 = new Stack<Integer>();
	}
	
	//O(1)
	public void enqueue(int e) {
		stack1.push(e);
	}
	
	//O(1) am
	public Integer dequeue() {
		if(stack2.isEmpty()) {
			while(! stack1.isEmpty())
				stack2.push(stack1.pop());
		}
		return stack2.pop();	
	}
	
	public void display() {
		System.out.println(stack2.toString() + stack1.toString());
	}
}
