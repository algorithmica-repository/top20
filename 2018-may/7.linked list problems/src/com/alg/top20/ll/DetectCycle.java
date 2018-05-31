package com.alg.top20.ll;

import java.util.HashSet;

public class DetectCycle {

	public static boolean hasLoop1(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		for (ListNode current = head; current != null; current = current.next) {
			if (set.contains(current))
				return true;
			set.add(current);
		}
		return false;
	}

	public static boolean hasLoop2(ListNode head) {
		ListNode slow = head, fast = head;
		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return false;
			fast = fast.next.next;
		} while (slow != fast);
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
