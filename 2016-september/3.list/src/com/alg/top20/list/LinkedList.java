package com.alg.top20.list;

public class LinkedList extends AbstractList {

	private class ListNode {
		Integer data;
		ListNode next;

		public ListNode() {

		}
	}

	private final ListNode head;
	private ListNode last;

	public LinkedList() {
		head = new ListNode();
		last = head;
	}

	@Override
	public int get(int ind) {
		ListNode current = head.next;
		for (int i = 0; i < ind; ++i)
			current = current.next;
		return current.data;
	}

	@Override
	public void add(int e) {
		// O(1)
		ListNode tmp = new ListNode();
		tmp.data = e;
		tmp.next = null;
		last.next = tmp;
		last = tmp;
		++size;
	}

	@Override
	public void add(int ind, int e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(int ind) {

	}

	@Override
	public void set(int ind, int e) {
		// O(n)
		ListNode current = head.next;
		for (int i = 0; i < ind; ++i)
			current = current.next;
		current.data = e;
	}

	@Override
	public void display() {
		// O(n)
		ListNode current = head.next;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}

	@Override
	public boolean contains(int e) {
		// O(n)
		ListNode current = head.next;
		while (current != null) {
			if (current.data == e)
				return true;
			current = current.next;
		}
		return false;
	}

	public void reverse() {
		//O(n)
		ListNode prev, current, tmp;

		current = head.next;
		prev = null;
		while (current != null) {
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		head.next = prev;
	}

}
