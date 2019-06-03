package com.alg.top20.ll;

import java.util.Random;

public class RandomNode {

	public static ListNode random1(ListNode head) {
		int n = 0;
		ListNode current;
		for(current = head.next; current != null; current = current.next) 
			++n;
		Random r = new Random();
		int tmp = r.nextInt(n) + 1;
		current = head;
		for(int i = 1; i <= tmp; ++i)
			current = current.next;
		return current;
	}
	
	public static ListNode random3(ListNode head) {
		ListNode r = head.next;
		Random random = new Random();
		int n = 2;
		for(ListNode current =  r.next; current != null; current = current.next) {
			if(random.nextInt(n) == 1)
				r = current;
			++n;
		}
		return r;
	}
	
	public static ListNode random2(ListNode head) {
		ListNode r = head.next;
		Random random = new Random();
		for(ListNode current =  r.next; current != null; current = current.next)
			if(random.nextInt(2) == 1)
				r = current;
		return r;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		for(int i = 1;i <= 24; ++i)
			System.out.println(random3(head));
	}

}
