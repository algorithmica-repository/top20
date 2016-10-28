package com.alg.top20.map;

import java.util.Random;

public class TestMap {

	public static void testSet(IMap map, int n) {
		Random r = new Random(100);
		for (int i = 0; i < n; ++i) {
			map.add(r.nextInt(100000) + 1, "abc");
		}
		map.display();
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testSet(new HashMap(), n);
	}

}
