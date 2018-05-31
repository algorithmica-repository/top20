package com.alg.top20.ll;

public class ReverseList {

	public static ListNode reverseList1(ListNode head) {
		ListNode current = head;
		ListNode prev = null;

		while (current != null) {
			ListNode tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		return prev;
	}
	
	public static void swap(ListNode first, ListNode second) {
		first = first ^ second;
		second = first ^ second;
		first = first ^ second;
	}
	public static ListNode reverseList2(ListNode head) {
		ListNode current = head;
		ListNode prev = null;

		while (current != null) {
			swap(current.next, prev);
			swap(prev, current);
		}
		return prev;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
