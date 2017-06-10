package com.alg.top20.linkedlist;

public class ReverseList {

	public static void reverseList1(ListNode head) {
		ListNode current = head.next;
		ListNode prev = null;
		ListNode tmp;
		while (current != null) {
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		head.next = prev;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		reverseList1(head);
		//display(head);
	}

}
