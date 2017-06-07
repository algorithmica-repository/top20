package com.alg.top20.list;

import java.util.Random;

public class Driver {

	public static void testList(List l) {
		Random r = new Random();
		for(int i = 0; i < 40; ++i)
			l.add(r.nextInt(100) + 1);
		l.display();
	}
	public static void main(String[] args) {
		testList(new ArrayList());
	}

}
