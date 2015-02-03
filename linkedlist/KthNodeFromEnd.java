/*Given a single linked list find the kth node from end
 * */
package com.algorithmica.linkedlists;

import java.util.Scanner;

public class KthNodeFromEnd {

	public static void main(String[] args) {
		LinkedListNode root = LinkedListNode.createList();
		System.out.println("Elements in the list are...");
		LinkedListNode.printList(root);
		System.out.println("\nenter the kth node u want from end..");
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		LinkedListNode kthNode = findkthToLast(root, k);
		if (kthNode == null)
			System.out.println("k is not a valid value");
		else
			System.out.println("\n kth node is " + kthNode.data);

	}

	public static LinkedListNode findkthToLast(LinkedListNode root, int k) {
		LinkedListNode current, kthNode;
		int i;

		/*
		 * Advance current k elements from beginning, checking for the end of
		 * the list
		 */
		current = root;
		for (i = 0; i < k; i++) {
			if (current.next != null) {
				current = current.next;
			} else {
				return null;
			}
		}

		/*
		 * Start kthNode at beginning and advance pointers together until
		 * current hits last element
		 */
		kthNode = root;
		while (current.next != null) {
			current = current.next;
			kthNode = kthNode.next;
		}

		/*
		 * kthNode now points to the element we were searching for, so return it
		 */
		return kthNode;
	}
}
