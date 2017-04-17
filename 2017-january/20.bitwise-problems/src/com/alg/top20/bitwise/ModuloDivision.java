package com.alg.top20.bitwise;

public class ModuloDivision {

	public static int moduloDivision8Sol1(int n) {
		return  n % 8;
	}
	public static int moduloDivision8Sol2(int n) {
		return  n & 7;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(moduloDivision8Sol1(n));
		System.out.println(moduloDivision8Sol2(n));

	}

}
