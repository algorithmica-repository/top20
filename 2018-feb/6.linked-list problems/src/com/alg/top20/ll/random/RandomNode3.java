package com.alg.top20.ll.random;

import java.util.Random;

import com.alg.top20.ll.ListNode;

public class RandomNode3 {
	public RandomNode3() {
		
	}
	public ListNode getRandom(ListNode head) {
		ListNode res = head;
		Random r = new Random();
		int n = 1;
		for(ListNode current = head.next; current != null; current = current.next) {
			++n;
			if(r.nextInt(n) == 0) 
				res = current;
		}
		return res;
	}
}
