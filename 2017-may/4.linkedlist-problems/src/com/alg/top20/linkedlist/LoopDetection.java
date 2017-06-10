package com.alg.top20.linkedlist;

import java.util.HashSet;

public class LoopDetection {

	public static boolean detectLoop1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		ListNode current = head.next;
		while (current != null) {
			if (hset.contains(current))
				return true;
			else
				hset.add(current);
			current = current.next;
		}
		return false;
	}

	public static boolean detectLoop2(ListNode head) {
	/*	ListNode current = head.next;
		while (current != null) {
			if (current.next < 0)
				return true;
			else
				current.next *= -1;
			current = current.next * -1;
		}*/
		return false;
	}

	public static boolean detectLoop3(ListNode head) {
		ListNode current = head.next;
		ListNode prev = head;
		ListNode tmp;
		while (current != null && current != head) {
			tmp = current.next;
			current.next = prev;
			prev = current;
			current = tmp;
		}
		if (current == null)
			return false;
		return true;
	}

	public static boolean detectLoop4(ListNode head) {
		ListNode tortoise = head, rabbit = head;
		do {
			tortoise = tortoise.next;
			if (rabbit == null || rabbit.next == null)
				return false;
			rabbit = rabbit.next.next;
		} while (tortoise != rabbit);
				
		return true;
	}

}
