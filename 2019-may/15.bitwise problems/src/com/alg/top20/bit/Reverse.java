package com.alg.top20.bit;

public class Reverse {

	public static int reverse1(int n) {
		int mask1 = 1;
		int mask2 = 1 << 31;
		int res = 0;
		while(n != 0) {
			if( (n & mask1) != 0)
				res = res | mask2;
			n = n >>> 1;
			mask2 = mask2 >>> 1;
		}
		return res;
	}
	public static int reverse2(int n) {
		n =  ((n & 0x55555555) << 1 ) | ( (n >>> 1) & 0x55555555 );
		BitWiseUtils.showBits(n);
		n =  ((n & 0x33333333) << 2 ) | ( (n >>> 2) & 0x33333333 );
		BitWiseUtils.showBits(n);
		n =  ((n & 0x0F0F0F0F) << 4 ) | ( (n >>> 4) & 0x0F0F0F0F );
		BitWiseUtils.showBits(n);
		n =  ((n & 0x00FF00FF) << 8 ) | ( (n >>> 8) & 0x00FF00FF );
		BitWiseUtils.showBits(n);	
		n =  ((n & 0x0000FFFF) << 16 ) | ( (n >>> 16) & 0x0000FFFF );
		BitWiseUtils.showBits(n);
		return n;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BitWiseUtils.showBits(n);
		int res  = reverse2(n);
		System.out.println(res);
	}

}
