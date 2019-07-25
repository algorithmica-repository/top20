package com.alg.top20.random;

public class Random2 {
	private int seed;
	
	public Random2(int seed) {
		this.seed = seed;
	}

    //m must be powers of 2
    //b and m must be relatively prime
    //a = gcf(b,m) + 4k (for some k)
	public int nextInt(int m) {
		int a  = 5;
		int b = 15;
		seed = (a * seed + b) % m;
		return seed;
	}
	public static void main(String[] args) {
		Random2 r = new Random2(5);
		for(int i = 1; i <= 20; ++i)
			System.out.println(r.nextInt(16));
	}

}
