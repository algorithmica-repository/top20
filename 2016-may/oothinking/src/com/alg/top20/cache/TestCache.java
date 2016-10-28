package com.alg.top20.cache;

import java.util.Random;
import java.util.UUID;

public class TestCache {

	public static void testCache(ICache cache, int n) {
		Random r = new Random(100);
		for(int i = 1; i <= n; ++i) {
			int key = r.nextInt(30);
			String value = UUID.randomUUID().toString();
			System.out.println("(" + key + "," + value + ")");
			cache.add(key, value);
			cache.display();
		}
		/*System.out.println(cache.get(20));
		System.out.println(cache.get(5));
		cache.display();*/
		
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testCache(new LinkedMapCache(5), n);

	}

}
