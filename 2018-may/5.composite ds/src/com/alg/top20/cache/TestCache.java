package com.alg.top20.cache;

public class TestCache {

	
	public static void main(String[] args) {
		LinkedHashCache cache = new LinkedHashCache(3);
		cache.put("abc", 100);
		cache.display();
		cache.put("def", 200);
		cache.display();
		cache.put("xyz", 300);
		cache.display();
		System.out.println(cache.get("abc"));
		cache.display();
		cache.put("xab", 400);
		cache.display();
	}

}
