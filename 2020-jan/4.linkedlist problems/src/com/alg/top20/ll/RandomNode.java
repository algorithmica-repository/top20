package com.alg.top20.ll;

import java.util.HashMap;
import java.util.Random;

public class RandomNode {

	public static ListNode randomNode1(ListNode head) {
		int size = 0;
		for (ListNode current = head.next; current != null; current = current.next)
			++size;
		Random r = new Random();
		int rand_index = r.nextInt(size) + 1;
		ListNode current = head;
		for (int i = 0; i < rand_index; ++i)
			current = current.next;
		return current;
	}

	public static ListNode randomNode2(ListNode head) {
		ListNode random = head.next;
		Random r = new Random();
		for (ListNode current = random.next; current != null; current = current.next) {
			if (r.nextInt(2) == 0)
				random = current;
		}
		return random;
	}
	
	public static ListNode randomNode3(ListNode head) {
		ListNode random = head.next;
		Random r = new Random();
		int n = 1;
		for (ListNode current = random.next; current != null; current = current.next) {
			++n;
			if (r.nextInt(n) == 0)
				random = current;
		}
		return random;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		ListNode head = LinkedListUtils.createList(n);
		LinkedListUtils.display(head);
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		for(int i = 1; i <= 10000; ++i) {
			ListNode random = randomNode1(head);
			String s = random.toString().split("@")[1];
			if(hmap.get(s) == null)
				hmap.put(s, 1);
			else
				hmap.put(s, hmap.get(s)+1);
			System.out.println(s);
		}
		System.out.println(hmap);
	}

}
