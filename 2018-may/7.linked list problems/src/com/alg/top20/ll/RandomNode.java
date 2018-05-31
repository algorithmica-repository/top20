package com.alg.top20.ll;

import java.util.Random;

public class RandomNode {

	public static ListNode getRandom(ListNode head) {
		Random r = new Random();
		int length = 0;
		ListNode current;
		for(current = head; current != null; current = current.next )
			++length;
		int rindex = r.nextInt(length);
		current = head;
		for(int i = 0; i <= rindex; ++i)
			current = current.next;
		return current;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		for(int i = 1; i <= 10; ++i)
			System.out.println(getRandom(head.next));
	}

}
