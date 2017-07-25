package com.alg.top20.file;

import java.util.LinkedList;
import java.util.Queue;


public class CircularBuffer {
	private Queue<String> buffer;
	private int capacity;
	
	public CircularBuffer(int k) {
		capacity = k;
		buffer = new LinkedList<String>();
	}
	
	public void add(String line) {
		if(buffer.size() == capacity) {
			buffer.remove();
		}
		buffer.add(line);
	}
	
	public String getFirst() {
		return buffer.peek();
	}
}
