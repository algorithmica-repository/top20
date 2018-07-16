package com.alg.top20.bit;

public class BitwiseOperators {

	public static void bitwiseOperators() {
		int n = 26, m = 4;
		BitUtils.showBits(n);
		BitUtils.showBits(m);
		n = n ^ m;		
		BitUtils.showBits(n);
	}
	public static void main(String[] args) {
		bitwiseOperators();
	}

}
