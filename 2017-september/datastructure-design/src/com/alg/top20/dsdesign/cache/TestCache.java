package com.alg.top20.dsdesign.cache;
import java.util.Random;
import java.util.UUID;


public class TestCache {

	public static void testCase1(ICache cache) {
		cache.add("k1", 10);
		cache.display();
		cache.add("k2", 20);
		cache.display();
		cache.add("k3", 30);
		cache.display();
		System.out.println(cache.get("k4"));
		System.out.println(cache.get("k2"));
		cache.display();
		cache.add("k4", 40);
		cache.display();		
	}
	
	public static void testCase2(ICache cache, int n) {
		Random r = new Random();
		for(int i = 0; i <= n; ++i) {
			cache.add(UUID.randomUUID().toString(), r.nextInt(100) + 1);
			cache.display();
		}
		
	}
	public static void main(String[] args) {
		testCase2(new LinkedHashCache(3), 3);
	}

}
