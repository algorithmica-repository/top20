package com.assignments.linkedlists;

public class SortLinkedList1 {

	public static void main(String[] args) {
		LLnode head = createList();
		System.out.println("initial list is: ");
		printList(head);
		System.out.println("\nlist after sorting :");
		head = sortLinkedList(head);
		printList(head);

	}

	static LLnode sortLinkedList(LLnode head) {
		LLnode current = head.next;
		LLnode prev = null;
		LLnode nextNode;
		while (current != null) {
			LLnode temp = head;
			while (temp.next != current && temp.next.data <= current.data)
				temp = temp.next;

			nextNode = current.next;
			if (temp.next != current) {
				current.next = temp.next;
				temp.next = current;
				prev.next = nextNode;
				current = nextNode;

			} else {
				prev = current;
				current = nextNode;
			}
			

		}
		return head;

	}

	private static LLnode createList() {
		LLnode head = new LLnode(1000);
		LLnode a = new LLnode(1);
		LLnode b = new LLnode(3);
		LLnode c = new LLnode(5);
		LLnode d = new LLnode(7);
		LLnode e = new LLnode(0);
		LLnode f = new LLnode(4);
		LLnode g = new LLnode(6);
		LLnode h = new LLnode(8);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		g.next = h;
		head.next = a;

		return head;
	}

	private static void printList(LLnode head) {
		LLnode current = head.next;
		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
	}

}
