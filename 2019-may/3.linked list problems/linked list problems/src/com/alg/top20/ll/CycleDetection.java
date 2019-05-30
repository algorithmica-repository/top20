package com.alg.top20.ll;

import java.util.HashSet;

public class CycleDetection {
	
	//TC:O(n^2)  SC:O(1)
	public static boolean hasCycle1(ListNode head) {
		int l = 1;
		for(ListNode current = head.next; current != null; current = current.next) {
			ListNode tmp = head;
			for(int i = 1; i <= l; ++i)  {
				if(tmp == current) return true;
				tmp = tmp.next;
			}
			l = l + 1;
		}
		return false;
	}
	
	//TC:O(n)  SC:O(n)
	public static boolean hasCycle2(ListNode head) {
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
	//TC:O(n)   SC:(1)
	public static boolean hasCycle3(ListNode head) {
		ListNode slow, fast;
		slow = fast = head;
		do {
			slow = slow.next;
			if(fast == null || fast.next == null) return false;
			fast = fast.next.next;
		} while (slow != fast);
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
