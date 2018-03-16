package com.alg.top20.ll;

import java.util.HashSet;

public class FirstNodeOfLoop {

	public static ListNode firstNodeOfLoop1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for (; head != null; head = head.next) {
			if (hset.contains(head))
				return head;
			hset.add(head);
		}
		return null;
	}

	public static ListNode firstNodeOfLoop2(ListNode head) {
		if(null == head) return null;
		//detect loop in a list
		ListNode slow, fast;
		slow = fast = head;
		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return null;
			fast = fast.next.next;
		} while (slow != fast);
		
		//find loop length
		int length = 1;
		ListNode slow1 = slow.next;
		while(slow1!= slow) 
			++length;
		
		//find length node from end of list
		ListNode forward, back;
		forward = back = head;
		int i = 1;
		while( i <= length)
		    forward = forward.next;
		while(forward != back) {
			forward = forward.next;
			back = back.next;
		}
		return back;
	}
	public static ListNode firstNodeOfLoop3(ListNode head) {
		if(null == head) return null;
		ListNode slow, fast;
		slow = fast = head;
		
		do {
			slow = slow.next;
			if (fast == null || fast.next == null)
				return null;
			fast = fast.next.next;
		} while (slow != fast);
		
		while(head != slow) {
			head = head.next;
			slow = slow.next;
		}
		return slow;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
