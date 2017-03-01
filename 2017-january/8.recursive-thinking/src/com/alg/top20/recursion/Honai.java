package com.alg.top20.recursion;

public class Honai {
	
	private static int counter = 0;

	public static void honai(int n, char src, char aux, char target) {
		if(n == 0) return;
		honai(n-1, src, target, aux);
		++counter;
		System.out.println(src + "->" + target);
		honai(n-1, aux, src, target);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		honai(n, 'A', 'B', 'C');
		System.out.println("total moves:" + counter);
	}

}
