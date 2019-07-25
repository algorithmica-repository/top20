package com.alg.top20.bit;

public class IPAddress {

	public static int extractNetworkId(int ip) {
		return (ip & 0xFF000000) >>> 24;
		//return (ip >>> 4) & 0x000000FF
	}
	public static void showDotNotation(int ip) {
		int mask = 0xFF000000;
		System.out.print( (ip & mask) >>> 24 );
		mask = mask >>> 8;
		System.out.print( "." + ( (ip & mask) >>> 16) );
		mask = mask >>> 8;
		System.out.print( "." + ( (ip & mask) >>> 8) );
		mask = mask >>> 8;
		System.out.print( "." + (ip & mask) );
		System.out.println();
	}
	public static void main(String[] args) {
		int ip = Integer.parseInt(args[0]);
		BitWiseUtils.showBits(ip);
		showDotNotation(ip);
		System.out.println(extractNetworkId(ip));
	}

}
