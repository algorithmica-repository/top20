/*Write a program to reverse a single linked list*/
package com.algorithmica.linkedlists;

public class LinkedListReversal {
	public static void main(String[] args) {
		LinkedListNode head = LinkedListNode.createList();
		System.out.println("initial list");
		LinkedListNode.printList(head);
		listreversal(head);
		System.out.println("\nlist after reversing");
		LinkedListNode.printList(head);
	}

	public static LinkedListNode listreversal(LinkedListNode head) {
		LinkedListNode current, previous, temp;
		current = head.next;
		previous = null;
		while (current != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		head.next = previous;
		return head;

	}
}
