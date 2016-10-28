package com.alg.top20.genericlist;

public class LinkedList<T> implements IList<T> {
	private ListNode first;
	private int size;

	public LinkedList() {
		size = 0;
		first = null;
	}

	class ListNode {
		T element;
		ListNode next;
	}

	@Override
	public void add(T e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int ind, T e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int ind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

	
}
