package com.alg.top20.set;

import java.util.Random;

public class Driver {

	public static void testSet(ISet set, int limit) {		
		Random r = new Random();
		
		for(int i = 1; i <= limit; ++i) {
			set.add(r.nextInt(1000) + 1);
		}
		System.out.println(set.size());
		set.display();

	}
	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);
		testSet(new TreeSet(), limit);		
	}

}
