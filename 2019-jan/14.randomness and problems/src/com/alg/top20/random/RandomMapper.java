package com.alg.top20.random;

import java.util.Random;

public class RandomMapper {

	private static int getRandom1(int l, int r) {
		int a = 0, b = (r-l+1), c = l, d = r;
		Random random = new Random();
		int tmp = random.nextInt(b);
		return ( (tmp-a)/(b-a) * (d-c)) + c;
	}
	
	private static int getRandom2(int l, int r) {
		double tmp = Math.random();
		return  (int)(tmp * (r-l)) + l;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
