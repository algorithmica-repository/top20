package com.alg.top20.random;

import java.util.Arrays;
import java.util.Random;

public class RandomGenerator {
	
	public static long getRandom1(int n)  {
		return System.nanoTime() % n;
	}
	
	public static long getRandom2(int n)  {
		int[] obj = new int[1];
		System.out.println(obj);
		return 0;
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
		
		
		Random r = new Random(100);
		for(int i = 1; i <= 20; ++i) {
			System.out.println(r.nextInt(10));
		}
	}
}
