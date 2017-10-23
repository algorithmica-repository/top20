package com.alg.top20.ll.kthnodefromend;

import java.util.Stack;

import com.alg.top20.ll.ListNode;

public class KthNodeEnd {

	//TC:2n - k
	//SC:O(1)
	public static ListNode findKthNodeFromEnd1(ListNode head, int k) {
		//TODO
		return null;
	}
	
	//TC:n + k
	//SC:O(n)
	public static ListNode findKthNodeFromEnd2(ListNode head, int k) {
		Stack<ListNode> stack = new Stack<ListNode>();
		for(ListNode current = head.next; current != null; current = current.next) {
			stack.push(current);
		}
		if(stack.size() < k) return null;
		ListNode res = null;
		while(k > 0) {
			res = stack.pop();
			--k;
		}
		return res;
	}
	
	//TC:2n - k
	//SC:O(1)
	public static ListNode findKthNodeFromEnd3(ListNode head, int k) {
		ListNode start, end;
		start = end = head;
		while(k > 1) {
			end = end.next;
			--k;
		}
		while(end != null) {
			start = start.next;
			end = end.next;
		}
		return start;
	}
}
