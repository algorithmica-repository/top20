package com.alg.top20.cache;

class DListNode {
	DListNode prev;
	String key;
	Integer value;
	DListNode next;
	
	public DListNode() {
		prev = next = this;
	}
	public DListNode(String key, Integer value) {
		this.key = key;
		this.value = value;
		prev = next = this;
	}	
}
public class DoublyLinkedList {
	private DListNode head;
	private int size;
	
	public DoublyLinkedList() {
		head = new DListNode();
		size = 0;
	}
	//O(1)
	public void removeAddLast(DListNode tmp) {
		//unlink the node
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		//add tmp node at last position
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
	}
	
	//O(1)
	public DListNode removeFirst() {
		DListNode tmp = head.next;
		tmp.next.prev = head;
		head.next = tmp.next;
		--size;
		return tmp;
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
	
	public void display() {
		for(DListNode current = head.next; current != head; current = current.next) {
			System.out.print("(" + current.key + "," + current.value + ")");
		}
		System.out.println();
	}
	
	public int size() {
		return size;
	}
}
