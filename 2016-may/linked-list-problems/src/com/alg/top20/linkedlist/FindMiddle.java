package com.alg.top20.linkedlist;

public class FindMiddle {

	public static ListNode findMiddle(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
