package com.alg.top20.dsdesign.superqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SuperQueue {
	private Queue<Integer> dataQueue;
	private Deque<Integer> minDq;
	
	public SuperQueue() {
		dataQueue = new LinkedList<Integer>();
		minDq = new LinkedList<Integer>();
	}
	//O(1) am
	public void enqueue(int e) {
		dataQueue.add(e);
		while(! minDq.isEmpty()) {
			if( e < minDq.peekLast())
				minDq.removeLast();
			else
				break;
		}
		minDq.addLast(e);
	}
	
	//O(1)
	public Integer findMin() {
		if(minDq.isEmpty()) return null;
		return minDq.peekFirst();
	}
	
	//O(1)
	public Integer dequeue() {
		if(dataQueue.isEmpty()) return null;
		int res = dataQueue.remove();
		if(minDq.peekFirst() == res)
			minDq.removeFirst();
		return res;
	}
	
	public void display() {
		System.out.println("queue:" + dataQueue.toString());
		System.out.println("mindq:" + minDq.toString());
	}
}
