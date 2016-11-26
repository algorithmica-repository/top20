package com.alg.top20.file;

import java.util.LinkedList;

public class BoundedBuffer {
	private LinkedList<String> buffer;
	private int capacity;
	
	public BoundedBuffer(int n) {
		buffer = new LinkedList<String>();
		capacity = n;
	}
	
	public void add(String line) {
		if(buffer.size() >= capacity)
			buffer.removeFirst();
		buffer.add(line);
	}
	
	public String get(int ind) {
		return buffer.get(ind);
	}
	
	public int size() {
		return buffer.size();
	}
}
