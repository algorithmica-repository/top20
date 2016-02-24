package com.alg.top20.trees;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class RandomTest {
	public static void randomNumber() {
		Date d = new Date();
		long[] counters = new long[10];
		for (int i = 1; i <= 100000; ++i) {
			long r = d.getTime() % 10;
			counters[(int) r]++;
		}
		System.out.println(Arrays.toString(counters));
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

	public static void useRandom() {
		Random rand = new Random(100);
		for (int i = 1; i <= 10; ++i) {
			int r = rand.nextInt(20);
			System.out.println(r);
		}
	}

	public static void simulateDice() {
		Random rand = new Random();
		int r = rand.nextInt(6) + 1;
		System.out.println(r);
	}

	public static void main(String[] args) {
		// simulateDice();
		useRandom();
	}
}
