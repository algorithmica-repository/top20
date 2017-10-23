package com.alg.top20.ll.random;

import java.util.Random;

import com.alg.top20.ll.ListNode;

public class RandomNode {
	
	public static ListNode randomNode1(ListNode head) {
		ListNode current, rnode;
		
		Random r = new Random();
		rnode = head.next;
		for(current = rnode.next; current != null; current = current.next) {
			if(r.nextInt(2) == 0)
				rnode = current;
		}
		return rnode;
	}
	
	public static ListNode randomNode2(ListNode head) {
		ListNode current, rnode;
		int n = 1;
		Random r = new Random();
		rnode = head.next;
		for(current = rnode.next; current != null; current = current.next) {
			++n;
			if(r.nextInt(n) == 0)
				rnode = current;
		}
		return rnode;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode();
		for(int i = 0; i < 5; ++i) {
			ListNode tmp = new ListNode();
			tmp.next = head.next;
			head.next = tmp;
		}
		for(ListNode current = head; current != null; current = current.next)
			System.out.print(current + "->");
		System.out.println();
		System.out.println(randomNode2(head));
	}
}
