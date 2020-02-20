package com.alg.top20.ll;

import java.util.HashMap;

public class MyRandom {

	public static int random1(int n) {
		return (int) System.currentTimeMillis() % n;
	}
	public static int random2(int n) {
		
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i = 1; i <= 10000; ++i) {
			int r = random1(n);
			if(hmap.get(r) == null)
				hmap.put(r, 1);
			else
				hmap.put(r, hmap.get(r)+1);
			System.out.println(r);
		}
		System.out.println(hmap);
	}
}
