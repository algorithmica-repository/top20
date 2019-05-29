package com.alg.top20.ll;

public class ListReversal {

	public static void reverseList1(ListNode head) {
		ListNode prev = null, current = head.next;
		while (current != null) {
			ListNode tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		head.next = prev;
	}
	
	public static void swap1(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
	}
	private static void swap(ListNode first, ListNode second) {
		first = first ^ second;
		second = first ^ second;
		first = first ^ second;
	}
	public static void reverseList2(ListNode head) {
		ListNode prev = null, current = head.next;
		while (current != null) {
			swap(current.next, prev);
			swap(current, prev);
		}
		head.next = prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
