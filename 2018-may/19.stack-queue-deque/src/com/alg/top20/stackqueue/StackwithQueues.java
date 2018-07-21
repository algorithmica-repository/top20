package com.alg.top20.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class StackwithQueues {
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	private Queue<Integer> activeq;	
	
	public StackwithQueues() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
		activeq = q1;
	}
	//O(1)
	public void push(int x) {
		activeq.add(x);
	}
	//O(n) 
	public int pop() {
		int res = Integer.MIN_VALUE;
		Queue<Integer> alterq;	
		if(activeq == q1) alterq = q2;
		else alterq = q1;
		while(! activeq.isEmpty()) {
			if(activeq.size() == 1) {
				res = activeq.remove();
				break;
			}
			alterq.add(activeq.remove());
		}		
		activeq = alterq;
		return res;
	}
	
	public void display() {
		System.out.println(activeq);
	}
	public static void main(String[] args) {
		StackwithQueues s = new StackwithQueues();
		Random r = new Random(100);
		for(int i = 1; i <= 10; ++i) {
			s.push(r.nextInt(100));
			s.display();
		}
		s.pop();
		s.display();
		s.pop();
		s.display();
	}

}
