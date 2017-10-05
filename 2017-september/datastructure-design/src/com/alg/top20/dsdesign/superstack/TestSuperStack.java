package com.alg.top20.dsdesign.superstack;

import java.util.Random;

public class TestSuperStack {

	public static void main(String[] args) {
		SuperStack ss = new SuperStack();
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		for(int i = 0; i < n; ++i) {
			ss.push(r.nextInt(n));
			ss.display();
		}
		System.out.println(ss.findMin());
		ss.pop();
		ss.display();
		System.out.println(ss.findMin());
	}

}
