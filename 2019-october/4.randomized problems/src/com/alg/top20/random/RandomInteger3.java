package com.alg.top20.random;

import java.util.HashMap;

public class RandomInteger3 {
	private long seed;
	private final long a  = 1103515245L;
	private final long b = 12345L;
	private final long m = 1L<<32;

	public RandomInteger3() {
		this.seed = System.currentTimeMillis();
	}

	public RandomInteger3(long seed) {
		this.seed = seed;
	}

    //m must be powers of 2
    //b and m must be relatively prime
    //a = gcf(b,m) + 4k (for some k)
	public int rand(int n) {	
		seed = (a * seed + b) % m;
		return (int)(seed % n);
	}

	public static void main(String[] args) {
		RandomInteger3 r = new RandomInteger3(100);
		int n = Integer.parseInt(args[0]);
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i = 1; i <= 10000; ++i) {
			int random = r.rand(n);
			if(hmap.get(random) == null)
				hmap.put(random, 1);
			else
				hmap.put(random, hmap.get(random)+1);
			System.out.println(random);
		}
		System.out.println(hmap);
	}


}
