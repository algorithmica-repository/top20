package com.alg.top20.cs;

public class AllPartitions {

	public static void allPartitions1(String in) {
		auxPartitions1(0, in, "");
	}
	private static void auxPartitions1(int start, String in, String res) {
		if(start == in.length())
			System.out.println(res);
		for(int i = start; i < in.length(); ++i) {
			String tmp = in.substring(start, i+1);
			auxPartitions1(i+1, in, res+"+"+tmp);
		}
	}
	public static void main(String[] args) {
		allPartitions1(args[0]);
	}

}
