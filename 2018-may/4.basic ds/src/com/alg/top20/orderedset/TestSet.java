package com.alg.top20.set;

import java.util.Random;

public class TestSet {

	public static void testSortedSet(ISortedSet set, int n) {
		Random r = new Random();
		for(int i = 0; i < n; ++i)
			set.add(r.nextInt(n) + 1);
		set.display();
		System.out.println("BST size:" + set.size());
		System.out.println("Min:" + set.findMin());
		System.out.println("Element of rank " +set.size()/2 +" is:" + set.select(set.size()/2));
		System.out.println("Element of rank " +set.size() +" is:" + set.select(set.size()));
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testSortedSet(new TreeSet(), n);
	}

}
