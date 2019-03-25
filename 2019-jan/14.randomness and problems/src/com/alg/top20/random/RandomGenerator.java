package com.alg.top20.random;

public class RandomGenerator {
	private static final long a = 0x5DEECE66DL;
	private static final long b =  0xBL;;
	private static final long m = (1L << 48) - 1;;
	private long seed;
	
	public static int nextInt1(int n)  {
		return (int)(System.nanoTime() % n);
	}
	public RandomGenerator(int seed) {
		this.seed = seed;
	}
	public RandomGenerator() {
		this.seed = System.nanoTime();
	}
	public int nextInt(int n)  {
		long tmp = (a * seed + b) & m;
		//System.out.println(tmp);
		seed = tmp;
		return (int)(tmp % n);
	}
	public static void main(String[] args) {
		RandomGenerator rg = new RandomGenerator(10);
		for(int i = 1; i <= 100; ++i)
			//System.out.println(rg.nextInt(10));
			System.out.println(nextInt1(10));
	}

}

