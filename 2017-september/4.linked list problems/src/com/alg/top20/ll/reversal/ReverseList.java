package com.alg.top20.ll.reversal;

import com.alg.top20.ll.ListNode;

public class ReverseList {

	//TC:O(n)
	//SC:O(1)
	public static void reverseList1(ListNode head) {
		ListNode current = head.next;
		ListNode prev = null;
		while (current != null) {
			ListNode tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		head.next = prev;
	}
	private static void swap(ListNode first, ListNode second) {
		first = first ^ second;
		second = first ^ second;
		first = first ^ second;
	}
	public static void reverseList2(ListNode head) {
		ListNode current = head.next;
		ListNode prev = null;
		while (current != null) {
			swap(current.next, prev);
			swap(prev, current);
		}
		head.next = prev;
	}
}
