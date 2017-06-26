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
	
	private static void swap(ListNode first, ListNode second) {
		first = first ^ second;
		second = first ^ second;
		first = first ^ second;;
	}
	public static void reverseList2(ListNode head) {
		ListNode current = head.next;
		ListNode prev = null;
		while (current != null) {
			swap(current.next, prev);
			swap(current, prev);
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
