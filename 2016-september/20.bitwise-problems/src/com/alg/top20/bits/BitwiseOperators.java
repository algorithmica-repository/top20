package com.alg.top20.bits;

public class BitwiseOperators {

	private static int extract_bit(int n, int k) {
		return ((n & 1<<(k-1)) != 0)?1:0;
	}
	
	public static int clear_bit(int n, int k) {
		return n & ~(1<<(k-1));
	}
	
	public static int set_bit(int n, int k) {
		return n | 1<<(k-1);
	}
	
	public static int toggle_bit(int n, int k) {
		return n ^ 1<<(k-1);
	}
	
	public static void rightShifts() {
		int n = -20;
		show_bits(n);
		//arithmatic right shift 
		//m = n / 2^1
		int m = n >> 1;
		System.out.println(m);
		show_bits(m);
		//logical right shift
		int p = n >>> 1;
		System.out.println(p);
		show_bits(p);		
	}
	
	public static void leftShifts() {
		int n = 20;
		show_bits(n);
		//n * 2^1
		n = n << 1;
		show_bits(n);
		
		//1 * 2^2
		show_bits(1 << 2);
		//1 * 2^5
		show_bits(1 << 5);
		
	}
	public static void show_bits(int n) {
		for(int k = 32; k >= 1; --k)
			System.out.print(extract_bit(n, k));
		System.out.println();
	}

	public static void main(String[] args) {
		int n = 31;
		show_bits(n);
		n = clear_bit(n, 5);
		show_bits(n);
		n = set_bit(n, 32);
		show_bits(n);
		n = toggle_bit(n, 4);
		show_bits(n);
		n = toggle_bit(n, 16);
		show_bits(n);
		leftShifts();
	}

}
