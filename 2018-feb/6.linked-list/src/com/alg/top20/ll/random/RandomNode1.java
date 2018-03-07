package com.alg.top20.ll.random;

import java.util.Random;

import com.alg.top20.ll.ListNode;

public class RandomNode1 {
	ListNode[]  nodes;
	int length;
	public RandomNode1(ListNode head) {
		ListNode current;
		for(current = head; current != null; current = current.next)
			++length;
		nodes = new ListNode[length];
		int i = 0;
		for(current = head; current != null; current = current.next)
			nodes[i++] = current;
	}
	public ListNode getRandom(ListNode head) {
		Random r = new Random();
		return nodes[r.nextInt(length)];
	}
}
