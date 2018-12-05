package com.alg.top20.cs;

public class AllPartitions {

	public static void allPartitions(String in) {
		auxPartitions(in, "");
	}
	private static void auxPartitions(String in, String out) {
		if(in.length() == 0) {
			System.out.println(out);
			return;
		}
		for(int i = 0; i < in.length(); ++i) {
			auxPartitions(in.substring(i+1), out+in.substring(0, i+1) +"+");
		}
	}
	
	public static void main(String[] args) {
		allPartitions(args[0]);

	}

}
