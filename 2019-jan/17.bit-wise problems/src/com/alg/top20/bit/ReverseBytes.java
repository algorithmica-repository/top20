package com.alg.top20.bit;

public class ReverseBytes {

	public static int reverseBytes(int n) {
		int tmp1 = n << 24;
		BitwiseUtils.showBits(tmp1);
		int tmp2 = n >>> 24;
		BitwiseUtils.showBits(tmp2);
		int tmp3 = (n & 0xFF00)<<8;
		BitwiseUtils.showBits(tmp3);
		int tmp4 = (n & 0xFF0000) >>> 8;
		BitwiseUtils.showBits(tmp4);
		int tmp =  tmp1 | tmp2  | tmp3 | tmp4;
		BitwiseUtils.showBits(tmp);
		return tmp;

	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BitwiseUtils.showBits(n);
		System.out.println(reverseBytes(n));
	}

}
