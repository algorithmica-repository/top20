package com.alg.top20.list;

import java.util.Random;

public class ListDriver {
	
	public static void testList(IList list) {
		Random r = new Random(100);
		for(int i = 1; i <= 100; ++i)
			list.add(r.nextInt(50) + 1);
		list.display();
		System.out.println(list.get(0));
		System.out.println(list.get(5));
		System.out.println(list.size());
		list.remove(0);
		System.out.println(list.size());
		list.reverse();
		list.display();
	}
	public static void main(String[] args) {
		//testList(new ArrayList());
		testList(new LinkedList());
	}

}
