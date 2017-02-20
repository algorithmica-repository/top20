package com.alg.top20.cache;

public class DoublyLinkedList {
	private DListNode head;
	private int size;
	
	public DoublyLinkedList() {
		head = new DListNode();
		size = 0;
	}
	
	//O(1)
	public void removeAndAdd(DListNode current) {
		//unlink node from list
		current.prev.next = current.next;
		current.next.prev = current.prev;
		
		//attach node at end
		current.prev = head.prev;
		current.next = head;
		head.prev.next = current;
		head.prev = current;
		
	}
	
	//O(1)
	public DListNode addLast(String key, Integer value) {
		DListNode tmp = new DListNode(key,value);
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
		++size;
		return tmp;
	}
	
	public void display() {
		for(DListNode current = head.next; current != head; current = current.next) {
			System.out.println("(" +current.key+","+current.value+")");
		}
	}
	
	public int size() {
		return size;
	}
	
	//O(1)
	public DListNode removeFirst() {
		DListNode tmp = head.next;
		tmp.next.prev = head;
		head.next = tmp.next;
		--size;
		return tmp;
	}

}
