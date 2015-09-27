package com.collections.test;

/**
 * @author	Srinivas Reddy
 * @Email	srinivas96alluri@gmail.com
 */

import java.util.Arrays;

import com.collections.SinglyLinkedList;

public class SLLApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] elements = { 15, 12, 21, 6, 7, 16, 11, 18, 23, 98 };

		SinglyLinkedList<Integer> sll;
		sll = new SinglyLinkedList<>();

		for (int i = 0; i < elements.length; i++) {
			sll.addElement(elements[i]);
		}
		
		System.out.println("Array form = " + Arrays.toString(elements));

		sll.removeElement(9);
		System.out.println("Array form = " + sll.toString());

		sll.removeElement(9);
		System.out.println("Array form = " + sll.toString());

		System.out.println("Linked list form = " + sll.toString());

		sll.addElement(59, 3);
		System.out.println("\nsll.addElement(59, 3) => \nLinked list = "
				+ sll.toString());

		System.out.println(sll.addElement(60, 25));
		System.out.println("\nsll.addElement(60, 25) => \nLinked list = "
				+ sll.toString());

		sll.addElement(49, 0);
		System.out.println("\nsll.addElement(49, 0) => \nLinked list = "
				+ sll.toString());
	}
}
