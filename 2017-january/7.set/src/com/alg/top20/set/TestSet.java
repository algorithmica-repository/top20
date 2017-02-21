package com.alg.top20.set;

import java.util.Random;

public class TestSet {
	public static void testSet(ISet set, int n) {
		//get method call will be attached to either ArrayList's get or LinkedList's get at runtime
		Random r = new Random(100);
		//long start = System.currentTimeMillis();
		for(int i = 0; i < n; ++i)
			set.add(r.nextInt(n) + 1);
		//long end = System.currentTimeMillis();
		//System.out.println("Time taken:" + (end-start)/1000.0 + " seconds");
		set.display();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testSet(new HashSet(), n);
		//testList(new LinkedList(), n);
	}

}
