package com.alg.top20.bit;

public class ReverseBits {

	public static int solution1(int x) {
		x = ((x & 0x55555555) << 1) | ((x >>> 1) & 0x55555555);
		x = ((x & 0x33333333) << 2) | ((x >>> 2) & 0x33333333);
		x = ((x & 0x0F0F0F0F) << 4) | ((x >>> 4) & 0x0F0F0F0F);
		x = ((x & 0x00FF00FF) << 8) | ((x >>> 8) & 0x00FF00FF);
		x = ((x & 0x0000FFFF) << 16) | ((x >>> 16) & 0x0000FFFF);
		return x;
	}
	public static void main(String[] args) {
		int x = Integer.parseInt(args[0]);
		BitUtils.showBits(x);
		int y = solution1(x);
		BitUtils.showBits(y);
		System.out.println(y);
	}

}
