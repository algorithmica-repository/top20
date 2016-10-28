package com.alg.top20.ll;

import java.util.Random;

public class ListRandomNode {

	private static int findLength(ListNode head) {
		ListNode current = head.next;
		int l = 0;
		while(current != null) {
			++l;
			current = current.next;
		}
		return l;
	}
	public static ListNode findRandom1(ListNode head) {
		int n = findLength(head);
		Random r = new Random();
		int tmp = r.nextInt(n);
		ListNode random = head.next;
		for(int i = 0; i < tmp; ++i) {
			random = random.next;
		}
		return random;
	}
	
	public static ListNode findRandom2(ListNode head) {
		Random r = new Random();
		ListNode current = head.next;
		ListNode random = current;
		while(current != null) {
			//tossing a coin
			int toss = r.nextInt(2);
			if(toss == 1)
				random = current;
			current = current.next;
		}
		return random;
	}
	
	public static ListNode findRandom3(ListNode head) {
		Random r = new Random();
		ListNode current = head.next;
		ListNode random = current;
		int n = 1;
		while(current != null) {
			//generate random number between 0 to n-1
			int tmp = r.nextInt(n);
			//give 1/n chance to current node
			if(tmp == n-1)
				random = current;
			current = current.next;
			++n;
		}
		return random;
	}
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		
		ListNode head = new ListNode();
		System.out.print(head + "->");
		ListNode last = head;
		for(int i = 1; i <= size; ++i) {
			ListNode tmp = new ListNode(i);
			System.out.print(tmp + "->");
			last.next = tmp;
			last = tmp;
		}
		System.out.println();
		System.out.println(findRandom3(head));

	}

}
