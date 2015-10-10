/*Given two linked lists such that they share a few common nodes. Fine the intersecting node.
 * 
 */
package com.algorithmica.linkedlists;

import java.util.HashSet;

public class FindFirstCommonNode1 {
	public static void main(String[] args) {
		LinkedListNode head1 = createList();
		LinkedListNode head2 = createList();
		// corrupt both the lists
		LinkedListNode current = head2;
		while (current.next != null)
			current = current.next;
		current.next = head1.next.next.next;
		LinkedListNode node = findFirstCommonNode(head1, head2);
		if (node != null) {
			System.out.println("first common node is " + node.data);
		}

	}

	private static LinkedListNode createList() {
		LinkedListNode a = new LinkedListNode(10);
		LinkedListNode b = new LinkedListNode(20);
		LinkedListNode c = new LinkedListNode(30);
		LinkedListNode d = new LinkedListNode(40);
		LinkedListNode e = new LinkedListNode(50);
		LinkedListNode f = new LinkedListNode(60);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		return a;
	}

	static LinkedListNode findFirstCommonNode(LinkedListNode l1,
			LinkedListNode l2) {
		HashSet<Object> h = new HashSet<Object>();
		while (l1 != null) {
			h.add(l1);
			l1 = l1.next;
		}
		while (l2 != null) {
			if (h.contains(l2))
				return l2;
		}
		return null;
	}

}
