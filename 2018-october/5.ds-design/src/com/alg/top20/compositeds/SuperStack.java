package com.alg.top20.compositeds;

import java.util.Stack;

public class SuperStack {
	private Stack<Integer> st_elements;
	private Stack<Integer> st_min;
	
	public SuperStack() {
		st_elements = new Stack<Integer>();
		st_min = new Stack<Integer>();
	}

	public void push(int x) {
		st_elements.push(x);
		if(st_min.isEmpty() || x < st_min.peek())
			st_min.push(x);
	}
	
	public int pop() {
		if(st_elements.isEmpty()) return Integer.MIN_VALUE;
		int tmp = st_elements.pop();
		if(tmp == st_min.peek())
			st_min.pop();
		return tmp;
	}
	
	public int findMin() {
		if(st_elements.isEmpty()) return Integer.MIN_VALUE;
		return st_min.peek();
	}
}
