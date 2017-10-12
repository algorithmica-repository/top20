package com.alg.top20.set;

import java.util.Random;

public class TestSet {

	public static void testSet(ISet set, int n) {
		Random r = new Random(100);
		for(int i = 0; i < n; ++i) {
			int tmp = r.nextInt(n)+1;
			//System.out.println(tmp);
			set.add(tmp);
			//set.display();
			//System.out.println();
		}
		System.out.println(set.size());
		set.display();
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testSet(new HashSet(), n);
	}

}
