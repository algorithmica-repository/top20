package com.alg.top20.ll;

public class DoublyLinkedList {
	private DListNode head;
	private int size;
	
	public DoublyLinkedList() {
		head = new DListNode();
	}
	
	public void removeAddLast(DListNode tmp) {
		tmp.prev.next = tmp.next;
		tmp.next.prev = tmp.prev;
		
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
	}
	
	public int size() {
		return  size;
	}
	
	public DListNode addLast(Integer key, String value) {
		DListNode tmp = new DListNode(key, value);
		tmp.prev = head.prev;
		tmp.next = head;
		head.prev.next = tmp;
		head.prev = tmp;
		++size;
		return tmp;
	}
	
	public DListNode removeFirst() {
		DListNode tmp = head.next;
		tmp.next.prev = head;
		head.next = tmp.next;
		--size;
		return tmp;
	}
	
	public void display() {
		for(DListNode current = head.next; current != head; current = current.next) {
			System.out.print("(" + current.key + "," + current.value + ")" + "->");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
