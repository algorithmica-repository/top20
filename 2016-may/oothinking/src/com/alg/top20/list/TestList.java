package com.alg.top20.list;

import java.util.Random;

public class TestList {
	
	public static void test1(IList list, int size) {
		Random r= new Random(100);
		for(int i = 0; i < size; ++i){
			int re = r.nextInt(1000) + 1;
			System.out.println(re);
			list.add(re);
		}
		list.display();
	}

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
	    ArrayList al = new ArrayList();
	/*	al.add(10);
			al.add(20);
		al.display(); */
		
		LinkedList ll = new LinkedList();
		/*ll.add(40);
		ll.add(50);
		ll.display();*/
		test1(ll, size);
		//test1(ll);
	}

}
