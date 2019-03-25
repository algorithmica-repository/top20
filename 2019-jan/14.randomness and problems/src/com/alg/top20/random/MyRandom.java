package com.alg.top20.random;

import java.util.Random;

public class MyRandom {
	private Random random = new Random();
	
	public int nextInt(int l, int r) {
		int a =0, b = r-1, c = l, d = r-1;
		int tmp = random.nextInt(b+1);
		return ( (tmp-a)/(b-a) * (d-c)) + c;
	}

}
