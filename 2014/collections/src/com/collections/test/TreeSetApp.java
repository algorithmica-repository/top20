package com.collections.test;

/**
 * @author	Srinivas Reddy
 * @email	srinivas96alluri@gmail.com
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.collections.SortedSet;
import com.collections.TreeSet;

public class TreeSetApp {
	public static void main(String[] args) {

		List<Integer> elements = new ArrayList<Integer>();

		Random rand = new Random();

		for (int index = 0; index < 20; ++index) {
			elements.add(rand.nextInt(99));
		}

		SortedSet<Integer> treeSet = new TreeSet<Integer>(elements.get(0));

		int limit = elements.size();

		for (int index = 1; index < limit; index++) {
			treeSet.add(elements.get(index));
		}

		System.out.println("Array form = " + elements);

		System.out.println("TreeSet form = " + treeSet.toString());

		System.out.println("TreeSet Contains(20) = " + treeSet.contains(20));

		System.out.println("TreeSet Max = " + treeSet.findMax());
		System.out.println("TreeSet Min = " + treeSet.findMin());
		System.out.println("TreeSet Kth = " + treeSet.findKthSmallest(3));

	}
}
