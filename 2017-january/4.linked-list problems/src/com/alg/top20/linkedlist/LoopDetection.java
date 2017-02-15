package com.alg.top20.linkedlist;

import java.util.HashSet;

public class LoopDetection {

	public static boolean hasLoop1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		// tc:2*n*c - O(n)
		// sc:O(n)
		for (ListNode current = head.next; current != null; current = current.next) {
			if (hset.contains(current))
				return true;
			else
				hset.add(current);
		}
		return false;
	}

	public static boolean hasLoop2(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		//<=3n - O(n)
		do {
			slow = slow.next;
			if(fast == null || fast.next == null) return false;
			fast = fast.next.next;
		} while (slow != fast);
		return true;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		ListNode head = new ListNode();
		for(int i = 0; i < n; ++i) {
			TestLinkedList.addFirst(head, i);
		}
		//TestLinkedList.display(head);
		TestLinkedList.getLastNode(head).next = head.next;
		
		long start = System.currentTimeMillis();
		System.out.println(hasLoop2(head));
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000.0 + " seconds");

	}

}
