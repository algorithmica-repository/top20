package com.alg.top20.bits;

public class IsEvenOdd {

	public static boolean isEven1(int n) {
		return n % 2 ==0;
	}
	
	public static boolean isEven2(int n) {
		return (n & 1) == 0;
	}
	public static void main(String[] args) {
		System.out.println(isEven1(20));
		System.out.println(isEven2(20));
		System.out.println(isEven1(31));
		System.out.println(isEven2(31));
	}

}
