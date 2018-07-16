package com.alg.top20.bit;

public class ModuloPowerof2 {

	public static int solution1(int n) {
		return n % 8;
	}
	
	public static int solution2(int n) {
		return n & 7;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(solution1(n));
		System.out.println(solution2(n));
	}

}
