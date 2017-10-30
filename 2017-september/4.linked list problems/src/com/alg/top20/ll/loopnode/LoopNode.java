package com.alg.top20.ll.loopnode;

import java.util.HashSet;

import com.alg.top20.ll.ListNode;

public class LoopNode {

	// TC:O(n)
	// SC:O(n)
	public static ListNode findLoopNode1(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		for(ListNode current = head.next; current != null; current = current.next) {
			if(set.contains(current))
				return current;
			else
				set.add(current);
		}
		return null;
	}

	// TC:O(n)
	// SC:O(1)
	public static ListNode findLoopNode2(ListNode head) {
		//bring a pointer inside loop
		ListNode slow, fast;
		slow = fast = head;
		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return null;
			fast = fast.next.next;
		} while (slow != fast);
		
		//find loop length
		int loopsize = 0;
		ListNode slow2 = slow;
		do {
			++loopsize;
			slow2 = slow2.next;
		} while(slow2 != slow);
		
		//find looplength node from end
		ListNode start, end;
		start = end = head;
		while(loopsize > 1) {
			end = end.next;
			--loopsize;
		}
		while(end != null) {
			start = start.next;
			end = end.next;
		}
		return start;
	}
	
	// TC:O(n)
	// SC:O(1)
	public static ListNode findLoopNode3(ListNode head) {
		//detect loop: meeting point has significance
		ListNode slow, fast;
		slow = fast = head;
		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return null;
			fast = fast.next.next;
		} while (slow != fast);
		
		//the distance from meeting point to loop node = distance from head to loop node
		ListNode slow2 = head;
		while(slow != slow2) {
			slow = slow.next;
			slow2 = slow2.next;
		}
		return slow;		
	}
}
