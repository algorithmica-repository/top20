package com.alg.top20.random;

import java.util.HashMap;

public class RandomInteger4 {
	private long seed;
	private final long a  = 1103515245L;
	private final long b = 12345L;
	private final long m = 1L<<32;

	public RandomInteger4() {
		this.seed = System.currentTimeMillis();
	}

	public RandomInteger4(long seed) {
		this.seed = seed;
	}

    //m must be powers of 2
    //b and m must be relatively prime
    //a = gcf(b,m) + 4k (for some k)
	public double rand() {	
		seed = (a * seed + b) % m;
		return ((double)seed / (m-1) );
	}

	public static void main(String[] args) {
		RandomInteger4 r = new RandomInteger4(100);
		HashMap<Double, Integer> hmap = new HashMap<Double, Integer>();
		for(int i = 1; i <= 10000; ++i) {
			double random = r.rand();
			if(hmap.get(random) == null)
				hmap.put(random, 1);
			else
				hmap.put(random, hmap.get(random)+1);
			System.out.println(random);
		}
		//System.out.println(hmap);
	}


}
