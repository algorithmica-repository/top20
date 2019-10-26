package com.alg.top20.random;

import java.util.HashMap;

public class RandomInteger1 {
	
	public static int random1(int n) {
		long time = System.currentTimeMillis();
		return (int) (time % n);
	}
	public static int random2(int n) {
		long time = System.nanoTime();
		return (int) (time % n);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i = 1; i <= 10000; ++i) {
			int random = random2(n);
			if(hmap.get(random) == null)
				hmap.put(random, 1);
			else
				hmap.put(random, hmap.get(random)+1);
			System.out.println(random);
		}
		System.out.println(hmap);
	}

}
