package com.alg.top20.ds.stack;

import java.util.Random;
import java.util.Stack;

public class SuperStack {
	private Stack<Integer> data_st;
	private Stack<Integer> max_st;
	
	public SuperStack() {
		data_st = new Stack<Integer>();
		max_st = new Stack<Integer>();
	}
	public void push(int e) {
		data_st.push(e);
		if(max_st.empty() || e >= max_st.peek())
			max_st.push(e);
	}
	public int pop() {
		int e = data_st.pop();
		if(e == max_st.peek())
			max_st.pop();
		return e;
	}
	public int max() {
		return max_st.peek();
	}	
	public void display() {
		System.out.println(data_st);
		System.out.println(max_st);
	}
	public static void main(String[] args) {
		SuperStack ss = new SuperStack();
		Random r = new Random(100);
		for(int i = 0; i < 10; ++i)
			ss.push(r.nextInt(100));
		ss.display();
		System.out.println(ss.max());
		System.out.println(ss.pop());
		ss.display();
	}

}
