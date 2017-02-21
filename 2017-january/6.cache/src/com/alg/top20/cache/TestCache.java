package com.alg.top20.cache;

import java.util.Random;
import java.util.UUID;

public class TestCache {

	public static void testCache(ICache cache, int n) {
		Random r = new Random();
		String tmp = null;
		for(int i = 1; i <= n; ++i) {
			String key = UUID.randomUUID().toString();
			int value = r.nextInt(1000);
			cache.add(key, value);
			if(i == 3) tmp = key;
			cache.display();
		}
		System.out.println(cache.get(tmp));
		cache.display();
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		testCache(new LinkedHashMapCache(10), n);
		
	}

}
