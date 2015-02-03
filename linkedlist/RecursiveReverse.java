/*Given a single linked list reverse it using recursion*/
package com.algorithmica.linkedlists;

public class RecursiveReverse {
	public static void main(String[] args) {
		LinkedListNode head=LinkedListNode.createList();
		System.out.println("initial list");
		LinkedListNode.printList(head);
		head.next=recursiveReverse(head.next);
		System.out.println("\nlist after reversing");
		LinkedListNode.printList(head);

	}

	public static LinkedListNode recursiveReverse(LinkedListNode root) {
		if(root==null || root.next==null ) return root;
		LinkedListNode rest=root.next;
		LinkedListNode reversedList=recursiveReverse(rest);
		root.next=null;
		rest.next=root;
		return reversedList;

	}

}
