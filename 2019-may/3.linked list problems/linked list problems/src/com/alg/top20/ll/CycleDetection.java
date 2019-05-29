package com.alg.top20.ll;

import java.util.HashSet;

public class CycleDetection {

	public static boolean hasCycle1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		ListNode current = head.next;
		while (current != null) {
			if (hset.contains(current))
				return true;
			hset.add(current);
			current = current.next;
		}
		return false;
	}
	
	public static boolean hasCycle2(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		while (current != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
