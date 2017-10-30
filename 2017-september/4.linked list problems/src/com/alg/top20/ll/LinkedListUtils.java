package com.alg.top20.ll;

public class LinkedListUtils {	
	public static ListNode createList(int n) {
		ListNode head = new ListNode();
		for(int i = 0; i < n; ++i) {
			ListNode tmp = new ListNode();
			tmp.next = head.next;
			head.next = tmp;
		}
		return head;
	}
	public static void display(ListNode head) {
		for(ListNode current = head; current != null; current = current.next)
			System.out.print(current + "->");
		System.out.println();
	}
}
