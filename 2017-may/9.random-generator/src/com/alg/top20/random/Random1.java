package com.alg.top20.random;
import java.util.Random;


public class Random1 {
	
	public static void getRandomJava(int n) {
		Random r = new Random(100);
		for(int i = 0; i < 10; ++i)
			System.out.println(r.nextInt(n));
	}

	public static void getRandom1(int n) {
		for(int i = 0; i < 10; ++i)
			System.out.println((int)(System.currentTimeMillis() % n));
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		getRandomJava(n);
	}

}
