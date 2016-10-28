package com.alg.top20.cache;

import java.util.Random;
import java.util.UUID;

public class Driver {

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		ICache cache = new LinkedHashCache(size);
		Random r = new Random(100);
		
		String tmp = null;
		for(int i =  1; i <= 10; ++i) {
			String rkey = UUID.randomUUID().toString();
			if(i == 6) tmp = rkey;
			cache.put(rkey, r.nextInt(200));
			System.out.println("After element" + i);
			cache.display();
		}
		
		System.out.println(cache.get(tmp));
		cache.display();

	}

}

