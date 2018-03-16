package com.alg.top20.ll;

import java.util.Random;

public class RandomNode {
	ListNode[]  nodes;
	int length;
	public RandomNode(ListNode head) {
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
