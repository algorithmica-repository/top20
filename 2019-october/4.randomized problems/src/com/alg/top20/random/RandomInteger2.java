package com.alg.top20.random;

public class RandomInteger2 {
	private long seed;
	private final long a  = 5;
	private final long b = 7;
	private final long m = 11;

	public RandomInteger2() {
		this.seed = System.currentTimeMillis();
	}

	public RandomInteger2(long seed) {
		this.seed = seed;
	}

	public int rand(int n) {
		seed = (a * seed + b) % m;
		return (int) (seed % n);
	}

	public static void main(String[] args) {
		RandomInteger2 r = new RandomInteger2();
		for (int i = 1; i <= 20; ++i)
			System.out.println(r.rand(10));
	}

}
