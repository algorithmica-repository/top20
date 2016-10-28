package com.alg.top20.random;

import java.util.Random;

public class Simulation {
	
	public static void simulateDice() {
		Random rand = new Random();
		int r = rand.nextInt(6) + 1;
		System.out.println(r);
	}
	
	public static void simulateCoin() {
		int nh = 0, nt = 0;
		for (int i = 0; i < 10000; ++i) {
			double r = Math.random();
			if (r < 0.5)
				nh++;
			else
				nt++;
		}
		System.out.println("Head count:" + nh);
		System.out.println("Tail count:" + nt);
	}

	public static void main(String[] args) {
		simulateCoin();
		simulateDice();
	}

}
