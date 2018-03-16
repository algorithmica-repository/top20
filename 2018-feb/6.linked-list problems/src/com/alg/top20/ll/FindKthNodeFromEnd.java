package com.alg.top20.ll;

public class FindKthNodeFromEnd {

	public static ListNode findKthNodeFromEnd1(ListNode head, int k) {
		int length = 0;
		for(ListNode current = head; current != null; current = current.next)
			++length;
		int i = 1;
		while( i <= length-k)
		    head = head.next;
		return head;
	}
	
	public static ListNode findKthNodeFromEnd2(ListNode head, int k) {
		ListNode forward, back;
		forward = back = head;
		int i = 1;
		while( i <= k)
		    forward = forward.next;
		while(forward != null) {
			forward = forward.next;
			back = back.next;
		}
		return back;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
