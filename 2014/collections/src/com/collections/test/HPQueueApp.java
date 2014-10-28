package com.collections.test;

import com.collections.HPriorityQueue;
import com.collections.PriorityQueue;


/**
 * @author Srinivas Reddy
 * @email srinivas96alluri@gmail.com
 */
//HeapPriorityQueue
public class HPQueueApp{

	public static void main(String[] args) {

		PriorityQueue<Integer> pqueue = new HPriorityQueue<Integer>();
		
		for (int index = 9; index <= 24; ++index) {
			System.out.print(index + " ");
			pqueue.add(index);
		}
		
		
		System.out.println("\n === HPriorityQueue display() ===");
		pqueue.display();
		
		System.out.println(" === HPriorityQueue remove() ===> " + pqueue.remove());
		pqueue.display();
		
		System.out.println(" === HPriorityQueue remove() ===> " + pqueue.remove());
		pqueue.display();
	}

}
