package com.alg.top20.ll;

public class KthNodeFromEnd {

	public static ListNode kthNodeFromEnd1(ListNode head, int k) {
		int size = 0;
		for (ListNode current = head.next; current != null; current = current.next)
			++size;
		ListNode current = head;
		for (int i = 1; i <= (size - k + 1); ++i)
			current = current.next;
		return current;
	}

	public static ListNode kthNodeFromEnd2(ListNode head, int k) {
		ListNode forward, backward;
		forward = backward = head;
		for (int i = 1; i <= k; ++i)
			forward = forward.next;
		while (forward != null) {
			forward = forward.next;
			backward = backward.next;
		}
		return backward;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
