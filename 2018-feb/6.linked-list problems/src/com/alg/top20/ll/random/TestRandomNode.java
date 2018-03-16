package com.alg.top20.ll.random;

import java.util.Random;

import com.alg.top20.ll.ListNode;

public class TestRandomNode {

	public static ListNode createList(int n) {
		ListNode head = new ListNode();
		Random r = new Random();
		for(int i = 0; i < n; ++i)  {
			ListNode tmp = new ListNode(r.nextInt(n));
			tmp.next = head.next;
			head.next = tmp;
		}
		return head;
	}
	public static void display(ListNode head) {
		for(ListNode current = head; current != null; current = current.next)
			System.out.print(current +"->");
		System.out.println();
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = createList(n);
		display(head);
		for(int i = 0; i < 10; ++i)
			System.out.println(new RandomNode3().getRandom(head));
	}

}
