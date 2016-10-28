package com.alg.top20.ll;

public class MyRandom {
	long seed;
	long prev;
	
	public MyRandom(int seed) {
		this.seed = seed;
		this.prev = seed;
	}
	public MyRandom() {
		this.seed = System.currentTimeMillis();
		this.prev = this.seed;
	}

	public static long random1(int n) {
		 return System.currentTimeMillis()%n;
	}
		
	public float random2() {
		 long a = 1100,b = 1234, m=35537 ;
		 prev = (a * prev + b ) %m;
		 return (float)prev / m;
	}
	
	public long nextInt(int n) {
		return 0;
	}
	
	public static void main(String[] args) {
		//System.out.println(Math.random());
		MyRandom mr = new MyRandom();
		for(int i = 1; i <= 100; ++i)
		System.out.println(mr.random2());

	}

}
