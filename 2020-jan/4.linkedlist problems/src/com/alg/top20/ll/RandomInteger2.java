package com.alg.top20.ll;

import java.util.HashMap;

public class RandomInteger2 {
	private long a, b, m, seed;

	public RandomInteger2() {
		this(System.currentTimeMillis());
	}

	//m must be powers of 2
    //b and m must be relatively prime
    //a = gcf(b,m) + 4k (for some k)
	public RandomInteger2(long seed) {
		this.seed = seed;
		this.a  = 1103515245L;
		this.b = 12345L;
		this.m = 1L<<32;
	}

	public int nextInt(int n) {
		seed = (a * seed + b) % m;
		return (int) (seed % n);
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		RandomInteger2 random = new RandomInteger2(0);
		for (int i = 1; i <= 10000; ++i) {
			int r = random.nextInt(n);
			if (hmap.get(r) == null)
				hmap.put(r, 1);
			else
				hmap.put(r, hmap.get(r) + 1);
			System.out.println(r);
		}
		System.out.println(hmap);
	}
}
