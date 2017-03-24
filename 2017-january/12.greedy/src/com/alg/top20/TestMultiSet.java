package com.alg.top20;

import com.google.common.collect.TreeMultiset;

public class TestMultiSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMultiset<Integer> bag = TreeMultiset.create();
		bag.add(10);
		bag.add(10);
		bag.add(20);
		bag.add(25);
		bag.add(20);
		System.out.println(bag.size());
		System.out.println(bag.firstEntry());
		System.out.println(bag.firstEntry());
		System.out.println(bag.size());
		/*for(int e:bag) 
			System.out.println(e);*/
	}

}
