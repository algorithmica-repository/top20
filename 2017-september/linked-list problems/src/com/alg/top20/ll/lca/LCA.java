package com.alg.top20.ll.lca;

import java.util.HashSet;

public class LCA {

	public static ListNode findLCA1(ListNode head1, ListNode head2) {
		//fill up logic
		return null;
	}
	
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
}
