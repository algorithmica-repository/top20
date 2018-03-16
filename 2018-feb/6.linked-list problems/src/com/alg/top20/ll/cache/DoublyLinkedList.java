package com.alg.top20.ll.cache;

public class DoublyLinkedList {
	private DListNode head;
	private int size;
	
	public DoublyLinkedList() {
		head = new DListNode();
		size = 0;
	}
	public void moveToEnd(DListNode p) {
		//unlink at current position
		p.next.prev = p.prev;
		p.prev.next = p.next;
		
		//add at last
		p.prev = head.prev;
		p.next = head;
		head.prev.next = p;
		head.prev = p;
	}
	
	public DListNode addEnd(String key, Integer value){
		DListNode p = new DListNode(key, value);
		p.prev = head.prev;
		p.next = head;
		head.prev.next = p;
		head.prev = p;
		++size;
		return p;
	}
	
	public void removeFirst() {
		DListNode p = head.next;
		p.next.prev = p.prev;
		p.prev.next = p.next;
		--size;
	}
	
	public int size() {
		return size;
	}
	
	public void display() {
		for(DListNode current = head.next; current != head; current = current.next)
			System.out.print("(" + current.key + "," + current.value + ")->");
		System.out.println();
	}
}
