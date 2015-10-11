package com.alg.rec;

public class Honai {
	
	public static void doHonai1(int n, char src, char aux, char target) {
		if(n == 1) { System.out.println(src + "->" + target); return; }
		doHonai1(n-1, src, target, aux);
		System.out.println(src + "->" + target);
		doHonai1(n-1, aux, src, target);
	}
	
	//Same logic as above with different base condition. What are pros and cons of this code?
	public static void doHonai2(int n, char src, char aux, char target) {
		if(n == 0) { return; }
		doHonai2(n-1, src, target, aux);
		System.out.println(src + "->" + target);
		doHonai2(n-1, aux, src, target);
	}
	
	public static void main(String[] args) {
		doHonai1(3, 'A', 'B', 'C');
		doHonai2(3, 'A', 'B', 'C');
	}

}
