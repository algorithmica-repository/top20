package com.alg.top20.ll.random;

import java.util.Random;

import com.alg.top20.ll.LinkedListUtils;
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
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		System.out.println(randomNode2(head));
	}
}
