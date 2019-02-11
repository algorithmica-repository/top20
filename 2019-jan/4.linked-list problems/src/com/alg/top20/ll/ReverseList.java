package com.alg.top20.ll;

public class ReverseList {

	//TC:O(n)   SC:O(1)
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
	
	private static void swap(ListNode p1, ListNode p2) {
		p1 = p1 ^ p2;
		p2 = p1 ^ p2;
		p1 = p1 ^ p2;
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


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
