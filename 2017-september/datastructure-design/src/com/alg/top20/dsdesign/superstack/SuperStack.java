package com.alg.top20.dsdesign.superstack;

import java.util.Stack;

public class SuperStack {
	private Stack<Integer> dataStack;
	private Stack<Integer> minStack;
	
	public SuperStack() {
		dataStack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}
	public void push(int e)  {
		dataStack.push(e);
		if(minStack.isEmpty() || e <= minStack.peek())
			minStack.push(e);
	}
	public Integer pop() {
		if(dataStack.isEmpty()) return null;
		int tmp = dataStack.pop();
		if(tmp == minStack.peek())
			minStack.pop();
		return tmp;
	}
	
	public Integer top() {
		if(dataStack.isEmpty()) return null;
		return dataStack.peek();
	}
	
	public Integer findMin() {
		if(minStack.isEmpty()) return null;
		return minStack.peek();
	}
	
	public void display() {
		System.out.println(dataStack.toString());
	}
	
}
