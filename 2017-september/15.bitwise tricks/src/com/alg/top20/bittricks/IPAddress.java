package com.alg.top20.bittricks;

public class IPAddress {
	
	public static int getNetworkId(int n) {
		int mask = 0xFF000000;
		return (n & mask) >>> 24;
	}
	public static int getHostId(int n) {
		int mask = 0xFFFFFF;
		return n & mask;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		BitWiseUtilities.display(n);
		System.out.println(getNetworkId(n));
		System.out.println(getHostId(n));
	}
}
