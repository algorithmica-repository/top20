package com.alg.top20.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedQueue implements IQueue {
	private LinkedList<Integer> list;
	
	public LinkedQueue() {
		list = new LinkedList<Integer>();
	}

	@Override
	public void add(Integer e) {
		list.addLast(e);
	}

	@Override
	public Integer remove() {
		return list.removeFirst();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void display() {
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
	}

}
