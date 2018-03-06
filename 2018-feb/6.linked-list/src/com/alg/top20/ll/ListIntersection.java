package com.alg.top20.ll;

import java.util.HashSet;

public class ListIntersection {

	public static ListNode findIntersectingNode1(ListNode head1, ListNode head2) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for(ListNode current = head1; current != null; current = current.next) 
			hset.add(current);
		for(ListNode current = head2; current != null; current = current.next) { 
			if(hset.contains(current))
				return current;
		}
		return null;
	}
	
	private static int length(ListNode head) {
		int len = 0;
		for(ListNode current = head; current != null; current = current.next) 
			++len;
		return len;
	}
	public static ListNode findIntersectingNode2(ListNode head1, ListNode head2) {
		int n = length(head1);
		int m = length(head2);
		while(n > m) {
			head1 = head1.next;
			--n;
		}
		while(m > n) {
			head2 = head2.next;
			--m;
		}
		while(head1 != head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
		return head1;
	}
	
	public static ListNode findIntersectingNode3(ListNode head1, ListNode head2) {
		ListNode current1 = head1, current2 = head2;
		while(current1 != current2) {
			current1 = current1.next;
			if(current1 == null) current1 = head2;
			current2 = current2.next;
			if(current2 == null) current2 = head1;
		}
		return current1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
