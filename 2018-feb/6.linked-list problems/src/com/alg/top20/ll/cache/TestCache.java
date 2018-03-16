package com.alg.top20.ll.cache;

import java.util.Random;
import java.util.UUID;

public class TestCache {

	public static void test1(ICache cache, int size) {
		Random r = new Random(100);
		for(int i = 0; i < size+5; ++i) {
			cache.put(UUID.randomUUID().toString(), r.nextInt(1000));
			cache.display();
		}		
	}
	
	public static void test2(ICache cache) {
		Random r = new Random(100);
		cache.put("abc", r.nextInt(1000));
		cache.display();
		cache.put("def", r.nextInt(1000));
		cache.display();
		cache.put("def", r.nextInt(1000));
		cache.display();
		cache.put("xyz", r.nextInt(1000));
		cache.display();
		System.out.println(cache.get("def"));
		cache.display();
		cache.put("pqr", r.nextInt(1000));
		cache.display();
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		test2(new LinkedHashMapCache(n));
	}

}
