package com.alg.top20.map;

import java.util.Random;
import java.util.UUID;

public class Driver {
	
	public static void main(String[] args) {
		HashMap hmap = new HashMap();
		
		int limit = Integer.parseInt(args[0]);
		Random r = new Random(100);
		
		for(int i = 1; i <= limit; ++i) {
			hmap.put(UUID.randomUUID().toString(),r.nextInt(1000));
		}
		System.out.println(hmap.size());
		hmap.display();

	}

}
