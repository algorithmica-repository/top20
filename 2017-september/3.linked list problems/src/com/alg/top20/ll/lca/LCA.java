package com.alg.top20.ll.lca;

import java.util.HashSet;

import com.alg.top20.ll.ListNode;

public class LCA {

	//TC:O(nm)
	//SC:O(1)
	public static ListNode findLCA1(ListNode head1, ListNode head2) {
		//fill up logic
		return null;
	}
	//TC;O(n+m)
	//SC:O(m)
	public static ListNode findLCA2(ListNode head1, ListNode head2) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		for(ListNode current = head2.next; current != null; current = current.next) 
			set.add(current);
		for(ListNode current = head1.next; current != null; current = current.next) {
			if(set.contains(current))
				return current;
		}
		return null;
	}
	private static int size(ListNode head) {
		int n = 0;
		for(ListNode current = head.next; current != null; current = current.next)
			++n;
		return n;
	}
	//TC:O(n + m)
	//SC:O(1)
	public static ListNode findLCA31(ListNode head1, ListNode head2) {
		ListNode current1 = head1;
		ListNode current2 = head2;
		int n = size(current1);
		int m = size(current2);
		while(n > m) {
			current1 = current1.next;
			--n;
		}
		while(m > n) {
			current2 = current2.next;
			--m;
		}
		while(current1 != current2) {
			current1 = current1.next;
			current2 = current2.next;
		}
		return current1;	
	}
	//TC:O(n + m)
	//SC:O(1)
	public static ListNode findLCA32(ListNode head1, ListNode head2) {
		ListNode current1 = head1;
		ListNode current2 = head2;
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
}
