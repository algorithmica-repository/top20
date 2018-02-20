package com.alg.top20.ds.stack;

public class Test {

	//"1234"
	public static void main(String[] args) {
	/*	String s = args[0];
		int result = 0;
		for(int i = 0; i < s.length(); ++i) {
			result = result * 10 + (int)(s.charAt(i)-'0');
		}
		System.out.println(result);*/
		
		String s = "12+3/4+(1-2)*7/4";
		String[] tokens = s.split("[+*/()-]");
		for(String token:tokens)
			System.out.println(token);
	}

}
