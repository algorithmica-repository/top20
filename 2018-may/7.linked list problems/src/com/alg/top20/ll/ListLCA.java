package com.alg.top20.ll;

import java.util.HashSet;

public class ListLCA {

	public static ListNode firstCommonNode1(ListNode head1, ListNode head2) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		for (ListNode current = head1; current != null; current = current.next)
			set.add(current);
		for (ListNode current = head2; current != null; current = current.next)
			if (set.contains(current))
				return current;
		return null;
	}

	public static ListNode firstCommonNode2(ListNode head1, ListNode head2) {
		ListNode first = head1, second = head2;
		int count = 0;
		while (count < 3 && first != second) {
			first = first.next;
			if (first == null) {
				++count;
				first = head2;
			}
			second = second.next;
			if (second == null) {
				++count;
				second = head1;
			}
		}
		if(count >= 2)
			return null;
		return first;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
