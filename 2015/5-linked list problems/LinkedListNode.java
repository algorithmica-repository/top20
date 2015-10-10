package com.algorithmica.linkedlists;

public class LinkedListNode {
	Object data;
	LinkedListNode next;

	public LinkedListNode() {
		this.data = null;
		this.next = null;
	}

	public LinkedListNode(Object n) {
		this.data = n;
		this.next = null;
	}

	public static void printList(LinkedListNode header) {

		for (LinkedListNode current = header.next; current != null; current = current.next)
			System.out.print(current.data + " ");
	}

	public static LinkedListNode createList() {
		LinkedListNode a = new LinkedListNode(10);
		LinkedListNode b = new LinkedListNode(20);
		LinkedListNode c = new LinkedListNode(30);
		LinkedListNode d = new LinkedListNode(40);
		LinkedListNode e = new LinkedListNode(50);
		LinkedListNode f = new LinkedListNode(60);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		LinkedListNode header = new LinkedListNode();
		header.next = a;
		return header;
	}

}
