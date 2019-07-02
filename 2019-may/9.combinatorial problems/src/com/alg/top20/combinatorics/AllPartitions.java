package com.alg.top20.combinatorics;

public class AllPartitions {
	
	public static void partitions1(String in) {
		auxPartitions1(in, "");
	}
	private static void auxPartitions1(String in, String out) {
		if(in.length() == 0) {
			System.out.println(out);
			return;
		}
		for(int i = 0; i < in.length(); ++i)
			auxPartitions1(in.substring(i+1), out + "+" + in.substring(0, i+1) );
	}
	
	public static void main(String[] args) {
		partitions1(args[0]);
	}
}
