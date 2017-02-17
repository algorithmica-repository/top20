package com.alg.top20.linkedlist;

import java.util.Random;

public class TestLinkedList {
	
	public static void addFirst(ListNode head, Integer e) {
		ListNode tmp = new ListNode(e);
		tmp.next = head.next;
		head.next = tmp;
	}

	public static void display(ListNode head) {
		ListNode current;
		for(current = head.next;current!=null;current=current.next) {
			System.out.print(current+"->");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Random r = new Random(100);
		int n = Integer.parseInt(args[0]);
		
		ListNode head = new ListNode();
		for(int i = 1; i <= n; ++i) {
			addFirst(head, r.nextInt(n) + 1);
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
