package com.alg.top20.set;

import java.util.Random;

public class Driver {

	public static void testSet1(ISet set, int limit) {		
		Random r = new Random();
		
		for(int i = 1; i <= limit; ++i) {
			set.add(r.nextInt(1000) + 1);
		}
		System.out.println(set.size());
		set.display();
	}
	
	public static void testSet2(ISortedSet set, int limit) {		
		Random r = new Random();
		
		for(int i = 1; i <= limit; ++i) {
			set.add(r.nextInt(1000) + 1);
		}
		System.out.println(set.size());
		set.display();
		System.out.println(set.findMin());
		System.out.println(set.select(10));
		System.out.println(set.select(30));
	}
	public static void main(String[] args) {
		int limit = Integer.parseInt(args[0]);
		testSet2(new TreeSet(), limit);		
	}

}
