package com.alg.top20.ll;

public class ReverseList {

	public static ListNode reverseList1(ListNode head) {
		ListNode current, prev, tmp;
		prev = null;
		current = head;
		while(current != null) {
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		return prev;
	}
	
	private static void swap(ListNode a, ListNode b) {
		//unsigned int x = (unsigned int)a;
		//unsigned int y = (unsigned int)y;
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
	}
	public static ListNode reverseList2(ListNode head) {
		ListNode current, prev;
		prev = null;
		current = head;
		while(current != null) {
			swap(current.next, prev);
			swap(current, prev);
		}
		return prev;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
