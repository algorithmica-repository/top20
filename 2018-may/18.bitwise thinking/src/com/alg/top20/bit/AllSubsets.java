package com.alg.top20.bit;

public class AllSubsets {

	public static void allSubsets(String s) {
		int n = s.length();
		for(int i = 0; i < (1 << n); ++i) {
			StringBuffer sb = new StringBuffer();
			for(int j = 0; j < n; ++j) {
				if( (i & (1 << j)) != 0)
					sb.append(s.charAt(j));
			}
			System.out.println(sb.toString());
		}
	}
	public static void main(String[] args) {
		allSubsets(args[0]);
	}

}
