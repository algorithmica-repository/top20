package com.alg.top20.set;

import java.util.Random;

public class TestSet {

	public static void testSet(ISet set, int n) {
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			set.add(r.nextInt(100000) + 1);
		}
		set.display();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testSet(new HashSet(), n);
	}

}
