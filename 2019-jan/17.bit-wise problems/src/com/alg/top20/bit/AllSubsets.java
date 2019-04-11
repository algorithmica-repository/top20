package com.alg.top20.bit;

public class AllSubsets {

	public static void allSubsets(int[] in) {
		int n = in.length;
		int nsubsets = 1 << n;
		for(int i = 0; i < nsubsets; ++i) {
			int mask = 1 << n-1;
			for(int j = 0; j < n; ++j) {
				if( (i & mask) != 0)
					System.out.print(in[j] +" ");
				mask = mask >>> 1;
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i+1;
		allSubsets(in);

	}

}
