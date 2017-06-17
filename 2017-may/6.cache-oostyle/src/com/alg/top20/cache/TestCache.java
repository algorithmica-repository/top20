package com.alg.top20.cache;

import java.util.Random;
import java.util.UUID;

public class TestCache {

	public static void testCache(ICache cache) {
		Random r = new Random(100);
		String tmpkey = null;
		for(int i = 0; i < 5; ++i) {
			String key = UUID.randomUUID().toString();
			int value = r.nextInt(100) + 1;
			cache.put(key, value);
			if(i == 0)
				tmpkey = key;
			cache.display();
		}		
		System.out.println(cache.get(tmpkey));
		cache.display();
	}
	public static void main(String[] args) {
		int capacity = Integer.parseInt(args[0]);
		testCache(new LinkedHashCache(capacity));
	}

}
