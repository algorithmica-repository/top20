package com.alg.top20.bit;

public class BitUtils {

	public static void showBits(int n) {
		for(int i = 31; i >= 0; --i) {
			if( (n & (1 << i)) != 0)
				System.out.print("1");
			else 
				System.out.print("0");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
