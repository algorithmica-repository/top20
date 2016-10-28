package com.alg.top20.ll;

import java.util.HashSet;

public class LoopDetection {

	public static boolean hasCycle1(ListNode head) {
		HashSet<ListNode> hset = new HashSet<ListNode>();
		// n * 2 * c
		for (ListNode current = head.next; current != null; current = current.next) {
			if (hset.contains(current))
				return true;
			hset.add(current);
		}
		return false;
	}

	public static boolean hasCycle2(ListNode head) {
		ListNode rabbit, tortoise;
		rabbit = tortoise = head;

		do {
			tortoise = tortoise.next;
			if (rabbit == null || rabbit.next == null)
				return false;
			rabbit = rabbit.next.next;
		} while (tortoise != rabbit);
		
		return true;
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		
		ListNode head = new ListNode();
		ListNode last = head;
		for(int i = 1; i <= size; ++i) {
			ListNode tmp = new ListNode(i);
			last.next = tmp;
			last = tmp;
		}
		last.next = head.next;
		
		long start = System.currentTimeMillis();
		System.out.println(hasCycle1(head));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 + "seconds");

		start = System.currentTimeMillis();
		System.out.println(hasCycle2(head));
		end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 + "seconds");

		
	}

}
