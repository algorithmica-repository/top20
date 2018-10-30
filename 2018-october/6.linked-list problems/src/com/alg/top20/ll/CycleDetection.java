package com.alg.top20.ll;

import java.util.HashSet;

public class CycleDetection {

	//TC:O(n)   SC:O(n)
	public static boolean hasCycle1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for (ListNode current = head.next; current != null; current = current.next) {
			if (hset.contains(current))
				return true;
			hset.add(current);
		}
		return false;
	}

	//TC:O(n)   SC:O(1)
	public static boolean hasCycle2(ListNode head) {
		ListNode slow, fast;
		slow = head;
		fast = head;
		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return false;
			fast = fast.next.next;
		} while (slow != fast);
		return true;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createListWithLoop(n);
		//LinkedListUtils.display(head);
		System.out.println(hasCycle1(head));
		System.out.println(hasCycle2(head));
	}

}
