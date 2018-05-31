package com.alg.top20.ll;

import java.util.Random;

public class RandomTest {

	public static void simulateCoinToss(int n) {
		Random r = new Random();
		int nh = 0, nt =0;
		for(int i = 1; i <= n; ++i) {
			if(r.nextInt(2) == 0)
				++nh;
			else
				++nt;
			System.out.print(r.nextInt(2));
		}
		System.out.println("\n"+ nh +","+nt);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		simulateCoinToss(n);
	}

}
