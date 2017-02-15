package com.alg.top20.linkedlist;

import java.util.Random;

public class FindKthfromEnd {
	
	public static ListNode findKthElementfromEnd1(ListNode head, int k) {
		int size = 0;
		ListNode current;
		for(current = head.next; current != null;current = current.next )
			++size;
		int i = 1;
		current = head.next;
		while(i++ <= (size-k)) {			
			current = current.next;
		}
		return current;
	}
	
	public static ListNode findKthElementfromEnd2(ListNode head, int k) {
		ListNode first = head, second = head;
		for(int i = 1; i <= k; ++i)
			second = second.next;
		while(second != null) {
			first = first.next;
			second = second.next;
		}
		return first;
	}
	
	public static void main(String[] args) {
		Random r = new Random(100);
		int n = Integer.parseInt(args[0]);
		
		ListNode head = new ListNode();
		for(int i = 1; i <= n; ++i) {
			TestLinkedList.addFirst(head, r.nextInt(n) + 1);
		}
		//System.out.println((1<<31)-1);
		//System.out.println(Integer.MAX_VALUE);
		System.out.println("Data generation complete");
		//display(head);
		long start = System.currentTimeMillis();
		ListNode res = FindKthfromEnd.findKthElementfromEnd1(head, 101);
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end-start)/1000.0 + " seconds");
		System.out.println(res);
	}

}
