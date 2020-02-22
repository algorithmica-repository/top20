package com.alg.top20.ll;

import java.util.HashSet;

public class LoopNode {

	// TC:O(n) SC:O(n)
	public static ListNode loopNode1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for (ListNode current = head.next; current != null; current = current.next) {
			if (hset.contains(current))
				return current;
			hset.add(current);
		}
		return null;
	}

	// TC:O(n) SC:O(1)
	public static LisNode loopNode2(ListNode head) {
		for (ListNode current = head.next; current != null; current = current.next) {
			if (current.next < 0)
				return current;
			current.next *= -1;
		}
		return null;
	}

	// TC:O(n) SC:O(1)
	public static ListNode loopNode3(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;

		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return null;
			fast = fast.next.next;
		} while (slow != fast);
		ListNode slow2 = head;
	    while(slow != slow2) {
	    	slow = slow.next;
	    	slow2 = slow2.next;
	    }
	    return slow;
	}
	
	public static boolean detectLoop32(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;

		do {
			if (fast == null || fast.next == null || fast.next.next == null)
				return false;
			if(fast.next == slow || fast.next.next == slow) return true;
			fast = fast.next.next.next;
			slow = slow.next;
		} while (slow != fast);
		return true;
	}


	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createListwithLoop(n);
		LinkedListUtils.displayWithLoop(head);
		System.out.println(detectLoop1(head));
		System.out.println(detectLoop31(head));
		System.out.println(detectLoop32(head));
		
		head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		System.out.println(detectLoop1(head));
		System.out.println(detectLoop31(head));
		System.out.println(detectLoop32(head));
		

	}

}
