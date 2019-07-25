package com.alg.top20.random;

public class Random1 {

	public int nextInt(int m) {
		return (int)System.currentTimeMillis() % m;
	}
	public static void main(String[] args) {
		Random1 r = new Random1();
		for(int i = 1; i <= 2000; ++i)
			System.out.println(r.nextInt(10));
	}

}
