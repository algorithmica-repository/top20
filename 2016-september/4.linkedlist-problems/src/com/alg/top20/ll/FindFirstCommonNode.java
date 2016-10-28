package com.alg.top20.ll;

import java.util.HashSet;

public class FindFirstCommonNode {

	public static ListNode firstCommonNode1(ListNode head1, ListNode head2) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for (ListNode current = head1.next; current != null; current = current.next)
			hset.add(current);
		
		for (ListNode current = head2.next; current != null; current = current.next)
			if(hset.contains(current)) return current;
		
		return null; 
	}
	
	private static int computeLength(ListNode head) {
		int length = 0;
		for (ListNode current = head; current != null; current = current.next)
			++length;
		return length;
	}

	public static ListNode firstCommonNode2(ListNode head1, ListNode head2) {
		// n + m
		int n = computeLength(head1);
		int m = computeLength(head2);
		ListNode current1 = head1, current2 = head2;

		// <= n + m
		if (n > m) {
			for (int i = 1; i <= n - m; ++i)
				current1 = current1.next;
		} else {
			for (int i = 1; i <= m - n; ++i)
				current2 = current2.next;
		}

		while (current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
		}
		return current1;
	}

	//Aha! thoughts
	public static ListNode firstCommonNode3(ListNode head1, ListNode head2) {
		ListNode current1 = head1, current2 = head2;

		while (current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
			if (current1 == null)
				current1 = head2;
			if (current2 == null)
				current2 = head1;
		}
		return current1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
