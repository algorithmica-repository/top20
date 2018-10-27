package com.alg.top20.ll;

public class ReverseList {

	public static void reverse1(ListNode head) {
		ListNode current, prev, tmp;
		current = head.next;
		prev = null;
		while (current != null) {
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		head.next = prev;
	}
	
	private static void swap(ListNode a, ListNode b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
	}
	public static void reverse2(ListNode head) {
		ListNode current, prev;
		current = head.next;
		prev = null;
		while (current != null) {
			swap(current.next, prev);
			swap(prev, current);
		}
		head.next = prev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
