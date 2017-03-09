package com.alg.top20.random;

import java.util.Arrays;
import java.util.Random;

public class RandomGenerator {
	
	private long seed;
	private static final int A = 5;
	private static final int B = 7;
	private static final int M = 1024;
	
	public RandomGenerator() {
		seed = System.nanoTime();
	}
	public RandomGenerator(int seed) {
		this.seed = seed;
	}
	
	public static long getRandom1(int n)  {
		return System.nanoTime() % n;
	}
	
	public static long getRandom2(int n)  {
		int[] obj = new int[1];
		System.out.println(obj);
		return 0;
	}
	public long getRandom3(int n)  {
		long tmp = (A  * seed+ B) % M;
		seed = tmp;
		return tmp % n;
	}
	
	public static void main(String[] args) {
		/*int[] counts = new int[10];
		for(int i = 1; i <= 100000; ++i) {
			long tmp = getRandom2(10);
			counts[(int)tmp]++;
			System.out.println(tmp);
		}
		System.out.println(Arrays.toString(counts));
	}*/
		
		
		/*Random r = new Random(100);
		for(int i = 1; i <= 20; ++i) {
			System.out.println(r.nextInt(10));
		}*/
		
		RandomGenerator rg = new RandomGenerator(10);
		for(int i = 1; i <= 20; ++i) {
			System.out.println(rg.getRandom3(10));
		}
		
		
	}
}
