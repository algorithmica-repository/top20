package com.alg.top20.random;

public class Random2 {
	private long seed;
	private static final long multiplier = 7;
	private static final long addend = 3;
	private static final long modulus = (1 << 21)-1;
	
	public Random2(long seed) {
		this.seed = seed;
	}
	public Random2() {
		this.seed = System.currentTimeMillis();
	}
	//O(1)
	public int nextInt(int n) {
		long tmp = (seed * multiplier + addend) % modulus;
		seed = tmp;
		return (int)(tmp % n);
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random2 r = new Random2();
		for(int i = 0; i < 10; ++i)
			System.out.println(r.nextInt(n));
	}
}