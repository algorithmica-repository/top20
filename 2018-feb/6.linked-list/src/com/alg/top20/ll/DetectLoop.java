package com.alg.top20.ll;

import java.util.HashSet;

public class DetectLoop {

	public static boolean hasLoop1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for (; head != null; head = head.next) {
			if (hset.contains(head))
				return true;
			hset.add(head);
		}
		return false;
	}

	public static boolean hasLoop2(ListNode head) {
		if(null == head) return false;
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
	
	public static boolean hasLoop3(ListNode head) {
		ListNode tmp;
		for (; head != null; head = tmp) {
			if(head.next < 0) return true;
			tmp = head.next;
			head.next *= -1;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
