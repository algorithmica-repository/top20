package com.alg.top20.ll;

import java.util.HashSet;

public class CommonNode {

	public static ListNode firstCommonNode1(ListNode head1, ListNode head2) {
		for(ListNode first = head1.next; first != null; first = first.next) {
			for(ListNode second = head2.next; second!= null; second = second.next)
				if(first == second) return first;
		}
		return null;
	}
	
	public static ListNode firstCommonNode2(ListNode head1, ListNode head2) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for(ListNode first = head1.next; first != null; first = first.next) {
				hset.add(first);
		}
		for(ListNode second = head2.next; second != null; second = second.next) {
			if(hset.contains(second))
				return second;
		}
		return null;
	}
	
	private static int length(ListNode head) {
		return 0;
	}
	public static ListNode firstCommonNode31(ListNode head1, ListNode head2) {
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
	
	public static ListNode firstCommonNode32(ListNode head1, ListNode head2) {
		ListNode first = head1, second = head2;
		while(first != second) {
			first = first.next;
			if(first == null)
				first = head2;
			second = second.next;
			if(second == null)
				second = head1;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
