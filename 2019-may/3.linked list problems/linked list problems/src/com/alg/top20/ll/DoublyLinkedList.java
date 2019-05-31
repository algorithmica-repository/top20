package com.alg.top20.ll;

public class DoublyLinkedList {
	private DListNode head;
	private int size;
	
	public DoublyLinkedList() {
		head = new DListNode();
		size = 0;
	}
	public int size() {
		return size;
	}
	
	public DListNode removeFirst() {
		DListNode tmp = head.next;
		tmp.next.prev = head;
		head.next = tmp.next;
		--size;
		return tmp;
	}
	public void removeAddLast(DListNode tmp) {
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
	}
	public DListNode addLast(String key, Integer value) {
		DListNode tmp = new DListNode(key, value);
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
		++size;
		return tmp;
	}
	public void display() {
		for(DListNode current = head.next; current != head; current = current.next)
			System.out.print("(" + current.key + "," + current.value+ ")->");
		System.out.println();
	}
}
