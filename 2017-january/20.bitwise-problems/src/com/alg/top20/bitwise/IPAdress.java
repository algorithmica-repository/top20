package com.alg.top20.bitwise;

public class IPAdress {
	
	public static int getNetworkId(int ip) {
		return (ip >>> 24) & 0xFF;
	}
	
	public static int getHostId(int ip) {
		return ip & 0xFFFFFF;
	}
	
	public static void main(String[] args) {
		int ip = 0x10100000;
		System.out.println(getHostId(ip));
		System.out.println(getNetworkId(ip));
	}

}
