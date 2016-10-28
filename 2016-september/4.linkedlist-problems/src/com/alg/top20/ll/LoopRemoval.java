package com.alg.top20.ll;

import java.util.HashSet;

public class LoopRemoval {

	public static boolean removeCycle1(ListNode head) {
		ListNode prev = null;
		HashSet<ListNode> hset = new HashSet<ListNode>();
		// n * 2 * c
		for (ListNode current = head.next; current != null; prev = current, current = current.next) {
			if (hset.contains(current)) {
				prev.next = null;
				return true;
			}
			hset.add(current);
		}
		return false;
	}

	public static boolean removeCycle2(ListNode head) {
		ListNode rabbit, tortoise;
		rabbit = tortoise = head;

		do {
			tortoise = tortoise.next;
			if (rabbit == null || rabbit.next == null)
				return false;
			rabbit = rabbit.next.next;
		} while (tortoise != rabbit);
		
		//Distance from head to loop node = c * Distance from meeting node to loop node
		ListNode tortoise2 = head;
		ListNode prev = null;
		while(tortoise2 != tortoise) {
			tortoise2 = tortoise2.next;
			prev = tortoise;
			tortoise = tortoise.next;
		}	
		prev.next = null;
		return true;
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		
		ListNode head = new ListNode();
		ListNode last = head;
		System.out.print(head + "->");
		for(int i = 1; i <= size; ++i) {
			ListNode tmp = new ListNode(i);
			last.next = tmp;
			last = tmp;
			System.out.print(tmp + "->");
		}
		last.next = head.next;
		System.out.println();
		
		System.out.println(last.next);
		System.out.println(removeCycle2(head));	
		System.out.println(last.next);
		
	}

}
