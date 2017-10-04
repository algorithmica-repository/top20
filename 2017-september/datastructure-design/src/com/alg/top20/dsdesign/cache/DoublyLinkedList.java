package com.alg.top20.dsdesign.cache;

public class DoublyLinkedList {
	private DListNode head;
	private int size;
	
	public DoublyLinkedList() {
		head = new DListNode();
		size = 0;
	}
	//O(1)
	public void removeAddLast(DListNode tmp) {
		//unlink the node from list
		tmp.next.prev = tmp.prev;
		tmp.prev.next = tmp.next;
		//add the node at last
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
	}
	//O(1)
	public DListNode addLast(String key, Integer value) {
		DListNode tmp = new DListNode(key, value);
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
		++size;
		return tmp;
	}
	//O(1)
	public DListNode removeFirst() {
		--size;
		DListNode tmp = head.next;
		head.next.next.prev = head;
		head.next = head.next.next;
		return tmp;
	}
	//O(1)
	public int size() {
		return size;
	}
	
	public void display() {
		for(DListNode current = head.next; current != head; current = current.next) {
			System.out.print("(" + current.key + "," + current.value + ")");
		}
		System.out.println();
	}
}
