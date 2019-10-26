package com.alg.top20.linkedlist;

import java.util.HashSet;

public class DetectCycle {

	public static boolean detectCycle1(ListNode head) {

	}

	public static boolean detectCycle2(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for (ListNode current = head.next; current != null; current = current.next) {
			if (hset.contains(current))
				return true;
			hset.add(current);
		}
		return false;
	}

	public static boolean detectCycle3(ListNode head) {
		ListNode tmp;
		for (ListNode current = head.next; current != null; current = tmp) {
			if (current.next < 0)
				return true;
			tmp = current.next;
			current.next *= -1;
		}
		return false;
	}

	public static boolean detectCycle41(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return false;
			fast = fast.next.next;
		} while (slow != fast);
		return true;
	}
	
	public static boolean detectCycle42(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		do {
			slow = slow.next;
			if (fast == null || fast.next == null || fast.next.next == null)
				return false;
			fast = fast.next.next.next;
		} while (slow != fast);
		return true;
	}


	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createListwithLoop(n);
		LinkedListUtils.displayWithLoop(head);
		System.out.println(detectCycle2(head));
		System.out.println(detectCycle41(head));
		System.out.println(detectCycle42(head));
	}

}
