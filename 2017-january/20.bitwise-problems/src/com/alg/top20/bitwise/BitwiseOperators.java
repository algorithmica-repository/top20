package com.alg.top20.bitwise;

public class BitwiseOperators {

	public static void extractBit(int n, int k) {
		if( (n & (1 << k-1)) == 0)
			System.out.println("0");
		else
			System.out.println("1");		
	}
	
	public static void rightShifts(int n) {
		Utils.showBits(n);
		Utils.showBits(n>>1);
		Utils.showBits(n>>>1);
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		//extractBit(n, 1);
		//extractBit(n, 2);
		//extractBit(n, 3);
		rightShifts(n);

	}

}
