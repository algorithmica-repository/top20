package com.alg.top20.cache;

public class DoublyLinkedList {
	private final DListNode head;
	private int size;
	
	public DoublyLinkedList() {
		head = new DListNode();
		size = 0;
	}
	public void removeAddEnd(DListNode tmp) {
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;		
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
	}
	
	public DListNode addEnd(String key, Integer value) {
		DListNode tmp = new DListNode(key, value);
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
		++size;
		return tmp;
	}
	
	public String removeFirst() {
		DListNode tmp = head.next;
		head.next = tmp.next;
		tmp.next.prev = head;
		--size;
		return tmp.key;
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
