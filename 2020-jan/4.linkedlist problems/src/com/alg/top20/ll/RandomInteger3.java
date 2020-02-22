package com.alg.top20.ll;

import java.util.HashMap;

public class RandomInteger3 {
	private long a, b, m, seed;

	public RandomInteger3() {
		this(System.currentTimeMillis());
	}

	//m must be powers of 2
    //b and m must be relatively prime
    //a = gcf(b,m) + 4k (for some k)
	public RandomInteger3(long seed) {
		this.seed = seed;
		this.a  = 1103515245L;
		this.b = 12345L;
		this.m = 1L<<32;
	}

	//bug:overflow due to multiplication
	public float rand() {
		seed = (a * seed + b) % m;
		return (float)seed / (m-1);
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		RandomInteger3 random = new RandomInteger3(1);
		for (int i = 1; i <= 10000; ++i) {
			int r = (random.rand() >= 0.5f)?0:1;
			if (hmap.get(r) == null)
				hmap.put(r, 1);
			else
				hmap.put(r, hmap.get(r) + 1);
			System.out.println(r);
		}
		System.out.println(hmap);
	}
}
