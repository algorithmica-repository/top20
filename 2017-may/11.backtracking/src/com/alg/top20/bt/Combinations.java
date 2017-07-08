package com.alg.top20.bt;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	//recursion : fix the bug
	public static void combinations1(char[] in) {
		List<Character> out = new ArrayList<Character>();
		auxCombinations1(0, in, out);
	}
	
	private static void auxCombinations1(int d, char[] in, List<Character> out) {
		System.out.println(out);
		if( d == in.length) return;
		for(int i = 0; i <= 1; ++i) {
			if(i == 1) {
				out.add(in[d]);
				auxCombinations1(d+1, in, out);
				out.remove(out.size()-1);
			} else
				auxCombinations1(d+1, in, out);
		}			
	}
	public static void main(String[] args) {
		char[] in = args[0].toCharArray();
		// System.out.println(Arrays.toString(in));
		combinations1(in);

	}

}
