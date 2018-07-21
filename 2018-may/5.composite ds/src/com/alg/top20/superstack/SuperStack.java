package com.alg.top20.superstack;

import java.util.Stack;

public class SuperStack {
	private Stack<Integer> st_data;
	private Stack<Integer> st_max;
	
	public SuperStack() {
		st_data = new Stack<Integer>();
		st_max = new Stack<Integer>();
	}
	public void push(int x) {
		st_data.push(x);
		if(st_max.isEmpty() || x >= st_max.peek())
			st_max.push(x);
	}
	
	public int pop() {
		if(st_data.isEmpty()) return Integer.MIN_VALUE;
		int res = st_data.pop();
		if(res == st_max.peek())
			st_max.pop();
		return res;			
	}
	
	public int max() {
		if(st_max.isEmpty()) return Integer.MIN_VALUE;
		return st_max.peek();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
