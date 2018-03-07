package com.alg.top20.ll.random;

import java.util.Random;

import com.alg.top20.ll.ListNode;

public class RandomNode2 {
	public RandomNode2(ListNode head) {
		
	}
	public ListNode getRandom(ListNode head) {
		ListNode res = head;
		Random r = new Random();
		for(ListNode current = head.next; current != null; current = current.next) {
			if(r.nextInt(2) == 0) 
				res = current;
		}
		return res;
	}
}
