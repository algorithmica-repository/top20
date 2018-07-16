package com.alg.top20.bit;

public class PowerOf2 {

	public static boolean solution1(int n) {
		int nones = 0;
		for(int i = 31; i >= 0; --i) {
			if( (n & (1 << i)) != 0)
				++nones;
		}
		return nones == 1;
	}
	public static boolean solution2(int n) {
		return (n & (n-1)) == 0;
	}
	public static void main(String[] args) {
		for(int i = 1; i <= 32; ++i) {
			BitUtils.showBits(i);
			System.out.println(solution2(i));
		}
	}

}
