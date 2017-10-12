package com.alg.top20.dsdesign.superstack;

import java.util.Stack;

public class SuperStack {
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;
	
	public SuperStack() {
		dataStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	//O(1)
	public void push(int e)  {
		dataStack.push(e);
		if(minStack.isEmpty() || e <= minStack.peek())
			minStack.push(e);
	}
	//O(1)
	public Integer pop() {
		if(dataStack.isEmpty()) return null;
		int tmp = dataStack.pop();
		if(tmp == minStack.peek())
			minStack.pop();
		return tmp;
	}
	//O(1)
	public Integer top() {
		if(dataStack.isEmpty()) return null;
		return dataStack.peek();
	}
	//O(1)
	public Integer findMin() {
		if(minStack.isEmpty()) return null;
		return minStack.peek();
	}
	
	public void display() {
		System.out.println("data stack:" + dataStack.toString());
		System.out.println("min stack:" + minStack.toString());
	}
	
}
