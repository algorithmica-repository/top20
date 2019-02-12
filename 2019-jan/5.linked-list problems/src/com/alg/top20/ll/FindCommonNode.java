package com.alg.top20.ll;

import java.util.HashSet;

public class FindCommonNode {

	public static ListNode findLCA1(ListNode head1, ListNode head2) {
		for(ListNode current1 = head1.next; current1 != null; current1 = current1.next) {
			for(ListNode current2 = head2.next; current2 != null; current2 = current2.next) {
				if(current1 == current2) return current1;
			}
		}
		return null;
	}
	
	public static ListNode findLCA2(ListNode head1, ListNode head2) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		for(ListNode current2 = head2.next; current2 != null; current2 = current2.next) 
			hset.add(current2);
		for(ListNode current1 = head1.next; current1 != null; current1 = current1.next) {
			if(hset.contains(current1)) return current1;
		}
		return null;
	}
	private static int length(ListNode head) {
		int count  = 0;
		for(ListNode current = head.next; current != null; current = current.next) 
			++count;
		return count;
	}
	public static ListNode findLCA3(ListNode head1, ListNode head2) {
		int n = length(head1);
		int m = length(head2);
		ListNode current1 = head1, current2 = head2;
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
