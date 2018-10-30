package com.alg.top20.ll;

import java.util.Random;

public class RandomNode {

	public static ListNode randomNode1(ListNode head) {
		ListNode current;
		int length = 0;
		for(current = head.next; current != null; current = current.next)
			++length;
		Random r = new Random();
		int tmp = r.nextInt(length)+1;
		current = head.next;
		for(int i = 1; i <= tmp; ++i)
			current = current.next;
		return current;
	}
	
	public static ListNode randomNode2(ListNode head) {
		ListNode current, random;
		current = random = head.next;
		Random r = new Random();
		for(current = current.next; current != null; current = current.next) {
			if(r.nextInt(2) == 0)
				random = current;
		}
		return random;
	}
	
	public static ListNode randomNode3(ListNode head) {
		int n = 1;
		ListNode current, random;
		current = random = head.next;
		Random r = new Random();
		for(current = current.next; current != null; current = current.next) {
			++n;
			if(r.nextInt(n) == 0)
				random = current;
		}
		return random;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		for(int i = 1; i <= 10; ++i)
			System.out.println(randomNode3(head));
	}

}
