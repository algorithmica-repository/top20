package com.alg.top20.list;

public class LinkedList implements IList {
	private final ListNode head;
	private ListNode last;
	private int size;

	public LinkedList() {
		size = 0;
		head = new ListNode();
		last = head;
	}

	class ListNode {
		Integer data;
		ListNode next;

		public ListNode(Integer data) {
			super();
			this.data = data;
		}

		public ListNode() {
			super();
		}

	}

	@Override
	public void add(Integer e) {
		ListNode tmp = new ListNode(e);
		last.next = tmp;
		last = tmp;
		++size;
	}

	/*public void add(Integer e) {
		ListNode tmp = new ListNode(e);
		if(last == null)
			last = tmp;
		else {
		last.next = tmp;
		last = tmp;
		}
		++size;
	}*/
	@Override
	public void add(int ind, Integer e) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer get(int ind) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display() {
		ListNode current;
		for(current = head.next; null != current; current = current.next) {
			System.out.print(current.data+ " ");
		}
		System.out.println();
	}

	@Override
	public void serialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deserialize() {
		// TODO Auto-generated method stub
		
	}
	
	

}
