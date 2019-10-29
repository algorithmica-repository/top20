package com.alg.top20.linkedlist;

import java.util.HashSet;

public class FindCommonNode {

	public static ListNode findCommonNode1(ListNode head1, ListNode head2) {
		for (ListNode current1 = head1.next; current1 != null; current1 = current1.next) {
			for (ListNode current2 = head2.next; current2 != null; current2 = current2.next) {
				if (current1 == current2)
					return current1;
			}
		}
		return null;
	}

	public static ListNode findCommonNode2(ListNode head1, ListNode head2) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for (ListNode current2 = head2.next; current2 != null; current2 = current2.next) {
			hset.add(current2);
		}
		for (ListNode current1 = head1.next; current1 != null; current1 = current1.next) {
			if (hset.contains(current1))
				return current1;
		}
		return null;
	}

	private static int length(ListNode head) {
		int n = 0;
		for (ListNode current = head.next; current != null; current = current.next) {
			++n;
		}
		return n;
	}

	public static ListNode findCommonNode41(ListNode head1, ListNode head2) {
		int n = length(head1);
		int m = length(head2);
		ListNode current1 = head1, current2 = head2;
		while (n > m) {
			current1 = current1.next;
			--n;
		}
		while (m > n) {
			current2 = current2.next;
			--m;
		}
		while (current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
		}
		return current1;
	}

	public static ListNode findCommonNode42(ListNode head1, ListNode head2) {
		ListNode current1 = head1, current2 = head2;

		while (current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
			if(current1 == null && current2 == null) break;
			if (current1 == null)
				current1 = head2;
			if (current2 == null)
				current2 = head1;			
		}
		return current1;
	}
	
	private static void testCase1(int n, int m) {
		ListNode head1 = LinkedListUtils.createList(n);
		ListNode head2 = LinkedListUtils.createList(m);
		System.out.println(findCommonNode42(head1, head2));
	}
	
	private static void testCase2(int n, int m) {
		ListNode head1 = LinkedListUtils.createList(n);
		ListNode head2 = LinkedListUtils.createList(m);
		ListNode tmp = RandomNode.randomNode3(head1);
		System.out.println(tmp);
		ListNode current;
		for(current = head2; current.next != null; current = current.next);
		current.next = tmp;			
		System.out.println(findCommonNode42(head1, head2));
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		testCase1(n, m);
		testCase2(n, m);
	}

}
