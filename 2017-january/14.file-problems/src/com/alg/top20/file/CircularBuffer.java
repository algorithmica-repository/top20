package com.alg.top20.file;

import java.util.LinkedList;

public class CircularBuffer {
	private LinkedList<String> buffer;
	private int capacity;
	private int size;
	
	public CircularBuffer(int n) {
		buffer = new LinkedList<String>();
		size =  0;
		capacity = n;
	}
	
	public void add(String e) {
		if(size == capacity)
			buffer.removeFirst();
		else
			++size;
		buffer.addLast(e);
	}
	
	public String readFirst() {
		return buffer.getFirst();
	}

}
