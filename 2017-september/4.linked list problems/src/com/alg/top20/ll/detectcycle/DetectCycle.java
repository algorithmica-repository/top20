package com.alg.top20.ll.detectcycle;

import java.util.HashSet;

import com.alg.top20.ll.ListNode;

public class DetectCycle {

	// TC:O(n)
	// SC:O(n)
	public static boolean hasCycle1(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		for(ListNode current = head.next; current != null; current = current.next) {
			if(set.contains(current))
				return true;
			else
				set.add(current);
		}
		return false;
	}

	// TC:O(n)
	// SC:O(1)
	public static boolean hasCycle2(ListNode head) {
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
}
