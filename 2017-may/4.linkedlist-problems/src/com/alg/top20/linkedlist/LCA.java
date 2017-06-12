package com.alg.top20.linkedlist;

public class LCA {

	private static int length(ListNode head) {
		int len = 0;
		for(ListNode current = head.next; current != null; current = current.next)
			++len;
		return len;
	}
	public static ListNode findLCA1(ListNode head1, ListNode head2) {
		int n = length(head1);
		int m = length(head2);
		
		ListNode current1 = head1;
		ListNode current2 = head2;
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
	
	public static ListNode findLCA2(ListNode head1, ListNode head2) {
		ListNode current1 = head1;
		ListNode current2 = head2;
		while(current1 != current2) {
			if(current1 == null)
				current1 = head2;
			if(current2 == null)
				current2 = head1;
			current1 = current1.next;
			current2 = current2.next;
		}
		return current1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
