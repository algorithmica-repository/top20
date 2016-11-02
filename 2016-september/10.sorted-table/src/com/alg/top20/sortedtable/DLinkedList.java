package com.alg.top20.sortedtable;

public class DLinkedList {
	private DListNode head;
	private int size;
	
	public DLinkedList() {
		head = new DListNode();
		size = 0;
	}
	
	public void removeAndAdd(DListNode current) {
		//unlinking the node referred by current
		current.next.prev = current.prev;
		current.prev.next = current.next;
		//Adding at last position
		addLast(current);
	}
	
	private void addLast(DListNode current) {
		current.prev = head.prev;
		current.next = head;
		head.prev.next  = current;
		head.prev = current;
	}
	public DListNode addLast(Employee value) {
		DListNode tmp = new DListNode(value);
		addLast(tmp);
		return tmp;
	}
	
	public DListNode removeFirst() {
		DListNode  first = head.next;
		first.next.prev = head;
		head.next = first.next;
		--size;
		return first;
	}
	
	public void print() {
		DListNode current = head.next;
		while(current != head) {
			System.out.print(current.value + ",");
			current = current.next;
		}
		System.out.println();
	}

}
