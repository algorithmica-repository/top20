package com.alg.top20.bits;

public class ExtractHostFromIP {

	public static int getHostIdClassA(int ip) {
		return ip & 0x00FFFFFF;
	}
	public static int getNetworkIdClassA(int ip) {
		return (ip >>> 24)& 0x000000FF;
	}
	public static void main(String[] args) {
		int n = 240 + (1 << 30) + (1 << 29) + (1<<31);
		BitwiseOperators.show_bits(n);
		System.out.println(getHostIdClassA(n));
		System.out.println(getNetworkIdClassA(n));

	}

}
