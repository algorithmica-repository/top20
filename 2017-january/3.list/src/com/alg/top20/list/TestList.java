package com.alg.top20.list;

import java.util.Random;

public class TestList {
	public static void testList(IList list, int n) {
		//get method call will be attached to either ArrayList's get or LinkedList's get at runtime
		Random r = new Random(100);
		long start = System.currentTimeMillis();
		for(int i = 0; i < n; ++i)
			list.add(r.nextInt(n) + 1);
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end-start)/1000.0 + " seconds");
		//list.display();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testList(new ArrayList(), n);
		//testList(new LinkedList(), n);
	}

}
