package com.alg.top20.ll;

import java.util.HashSet;

public class FirstCommonNode {

	public static ListNode firstCommonNode1(ListNode head1, ListNode head2) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for(ListNode current = head1.next; current != null; current = current.next)
			hset.add(current);
		for(ListNode current = head2.next; current != null; current = current.next)
			if(hset.contains(current)) return current;
		return null;
	}
	
	private static int length(ListNode head) {
		int n = 0;
		for(ListNode current = head.next; current != null; current = current.next)
			++n;
		return n;
	}
	public static ListNode firstCommonNode21(ListNode head1, ListNode head2) {
		int m = length(head1);
		int n = length(head2);
		ListNode current1=head1, current2=head2;
		while(m > n) {
			current1 = current1.next;
			--m;
		}
		while(n > m) {
			current2 = current2.next;
			--n;
		}
		while(current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
		}
		return current1;
	}
	
	public static ListNode firstCommonNode22(ListNode head1, ListNode head2) {
		ListNode current1=head1, current2=head2;
		
		while(current1 != current2) {
			current1 = current1.next;
			if(current1 == null)
				current1 = head2;
			current2 = current2.next;
			if(current2 == null)
				current2 = head1;
		}
		return current1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
