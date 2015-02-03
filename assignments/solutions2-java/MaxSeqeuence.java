/*Given a single linked list that consists of ‘R’ and ‘B’ values only, 
write an efficient function to find the maximum sequence length of 
any color. What are the time and space complexities of your solution?
Function prototype:
     int  findMaxSeq(Node head)
Input:    R B R B B R R R R B B B R
Output:  4
 * */
package com.assignments.linkedlists;

public class MaxSeqeuence {

	public static void main(String[] args) {
		Node a = new Node('R');
		Node b = new Node('B');
		Node c = new Node('R');
		Node d = new Node('B');
		Node e = new Node('B');
		Node f = new Node('R');
		Node g = new Node('R');
		Node h = new Node('R');
		Node i = new Node('R');
		Node j = new Node('B');
		Node k = new Node('B');
		Node l = new Node('B');
		Node m = new Node('R');

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		h.next = i;
		i.next = j;
		j.next = k;
		k.next = l;
		l.next = m;

		Node head = new Node("head");
		head.next = a;
		System.out.println("lenght of max sequence is: " + findMaxSeq(head));

	}

	static int findMaxSeq(Node head) {
		int maxCount = 1;
		Node previous = head;
		int count = 1;

		for (Node current = head.next; current != null; current = current.next) {
			if (previous.data == current.data) {
				count++;
			} else if (maxCount < count) {
				maxCount = count;
				count = 1;

			}
			previous = current;
		}
		if (maxCount < count)
			maxCount = count;
		return maxCount;

	}
}

class Node {
	Object data;
	Node next;

	Node(Object data) {
		this.data = data;
		this.next = null;
	}
}
