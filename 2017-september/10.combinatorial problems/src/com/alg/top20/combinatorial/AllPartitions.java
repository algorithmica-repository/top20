package com.alg.top20.combinatorial;

public class AllPartitions {

	public static void allPartitions1(String s) {
		auxPartitions1(0, s, "");
	}
	private static void auxPartitions1(int start, String s, String res) {
		if(start == s.length()) {
			System.out.println(res);
			return;
		}			
		for(int i = start; i < s.length(); ++i) {
			String tmp = s.substring(start, i+1);
			auxPartitions1(i+1, s, res+"+"+tmp);
		}		
	}
	
	public static void allPartitions2(String s) {
		auxPartitions2(s, "");
	}
	private static void auxPartitions2(String s, String res) {
		if(s.length() == 0) {
			System.out.println(res);
			return;
		}			
		for(int i = 0; i < s.length(); ++i) {
			String tmp = s.substring(0, i+1);
			auxPartitions2(s.substring(i+1), res+"+"+tmp);
		}		
	}
	public static void main(String[] args) {
		allPartitions2(args[0]);
	}

}
