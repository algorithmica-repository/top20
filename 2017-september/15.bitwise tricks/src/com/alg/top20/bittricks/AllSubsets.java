package com.alg.top20.bittricks;

public class AllSubsets {

	public static void allSubsets(int[] in) {
		int n = in.length;
		int limit = 1 << n;
		for(int i = 0; i < limit; ++i) {
			for(int j = 1; j <= n; ++j) {
				if( (i & (1<<j-1)) != 0)
					System.out.print(in[j-1]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i+10;
		allSubsets(in);
	}

}
