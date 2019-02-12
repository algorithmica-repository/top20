package com.alg.top20.ll;

import java.util.Random;

public class RandomNode {
	private static int length(ListNode head) {
		int count  = 0;
		for(ListNode current = head.next; current != null; current = current.next) 
			++count;
		return count;
	}
	public static ListNode randomNode1(ListNode head) {
		int n = length(head);
		Random r = new Random();
		int tmp = r.nextInt(n);
		ListNode current = head;
		for(int i = 0; i <= tmp; ++i) {
			current = current.next;
		}
		return current;
	}
	
	public static ListNode randomNode2(ListNode head) {
		ListNode random = head.next, current;
		Random r = new Random();
		for(current = random.next; current != null; current = current.next) {
			if(r.nextInt(2) == 1)
				random = current;				
		}
		return random;
	}
	public static ListNode randomNode3(ListNode head) {
		ListNode random = head.next, current;
		Random r = new Random();
		int n = 1;
		for(current = random.next; current != null; current = current.next) {
			++n;
			if(r.nextInt(n) == 0)
				random = current;				
		}
		return random;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
