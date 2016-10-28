package com.alg.top20.linkedlist;

public class RandomNode {

	public static ListNode randomNode1(ListNode head) {
		ListNode rnode = head.next;

		for (ListNode current = rnode.next; current != null; current = current.next) {
			if (Math.random() <= 0.5)
				rnode = current;
		}
		return rnode;
	}

	public static ListNode randomNode2(ListNode head) {
		ListNode rnode = head.next;
		int n=1; 

		for (ListNode current = rnode.next; current != null; current = current.next) {
			++n;
			if (Math.random() <= 1.0/n)
				rnode = current;
		}
		return rnode;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = new ListNode();
		ListNode last = head;
		for (int i = 0; i < n; ++i) {
			ListNode tmp = new ListNode();
			last.next = tmp;
			last = tmp;
			System.out.println(last);
		}
		System.out.println();
		for (int i = 1; i <= 20; ++i)
			System.out.println(randomNode1(head));
		System.out.println();
		for (int i = 1; i <= 20; ++i)
			System.out.println(randomNode2(head));

	}

}
