package com.alg.top20.random;

public class Random3 {
	private long seed;
	
	public Random3() {
		this.seed = System.currentTimeMillis();
	}
	public Random3(long seed) {
		this.seed = seed;
	}

    //m must be powers of 2
    //b and m must be relatively prime
    //a = gcf(b,m) + 4k (for some k)
	public double rand() {
		long a  = 1103515245L;
		long b = 12345L;
		long m = 1L<<32;
		seed = (a * seed + b) % m;
		return (double)seed / (m-1);
	}
	
	public int randInt(int x, int y)  {
		return (int)(rand() * (y-x) + x);
	}
	public static void main(String[] args) {
		Random3 r = new Random3();
		for(int i = 1; i <= 20; ++i)
			System.out.println(r.randInt(1, 10));
	}

}
