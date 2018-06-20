package com.alg.top20.optimization;

public class LIS {

	public static int lis1(int[] in) {
		int gmax = 0;
		for(int i = 1; i <= in.length; ++i)
			gmax = Math.max(gmax, lisEnding1(i, in));
		return gmax;
	}
	private static int lisEnding1(int i, int[] in) {
		if(i <= 1) return i;
		int max = 0;
		for(int j = 1; j < i; ++j) {
			if(in[j-1] < in[i-1]) {
				int tmp = lisEnding1(j, in);
				max = Math.max(max, tmp);
			}				
		}
		return 1 + max;
	}
	
	public static int lis2(int[] in) {
		int gmax = 0;
		int[] mem = new int[in.length+1];
		for(int i = 1; i <= in.length; ++i)
			gmax = Math.max(gmax, lisEnding2(i, in, mem));
		return gmax;
	}
	private static int lisEnding2(int i, int[] in,  int[] mem) {
		if(i <= 1) return i;
		if(mem[i] != 0) return mem[i];
		int max = 0;
		for(int j = 1; j < i; ++j) {
			if(in[j-1] < in[i-1]) {
				int tmp = lisEnding1(j, in);
				max = Math.max(max, tmp);
			}				
		}
		mem[i] = 1 + max;
		return mem[i];
	}
	
	public static int lis3(int[] in) {
		int gmax = 0;
		int[] mem = new int[in.length+1];
		for(int i = 1; i <= in.length; ++i) {
			int max = 0;
			for(int j = 1; j < i; ++j) {
				if(in[j-1] < in[i-1]) 
					max = Math.max(max, mem[j]);
			}
			mem[i] = 1 + max;
			gmax = Math.max(gmax, mem[i]);
		}
		return gmax;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
