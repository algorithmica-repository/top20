package com.alg.top20.combinatorics;

public class AllPartitions {

	public static void allPartitions(String in) {
		auxPartitions(in, "");
	}
	private static void auxPartitions(String in, String res)  {
		if(in.length() == 0) {
			System.out.println(res);
			return;
		}
		for(int i = 0; i < in.length(); ++i) 
			auxPartitions(in.substring(i+1), res + "+" + in.substring(0, i+1));
	}
	public static void main(String[] args) {
		allPartitions(args[0]);
	}

}
