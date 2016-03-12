package com.alg.top20.dp;

import java.util.Random;

public class MaxContgSum {

	private static int auxContgSum1(int j, int[] in) {
		if(j == 0) return 0;
		if(j == 1) return in[0];
		int incj = auxContgSum1(j-2, in) + in[j-1];
		int nincj = auxContgSum1(j-1,in);
		return Math.max(incj, nincj);
	}
	public static int maxContgSum1(int[] in) {
		return auxContgSum1(in.length, in);
	}
	
	private static int auxContgSum2(int j, int[] in, int[] mem) {
		if(j == 0) return 0;
		if(j == 1) return in[0];
		if(mem[j] != 0) return mem[j];
		int incj = auxContgSum2(j-2, in, mem) + in[j-1];
		int nincj = auxContgSum2(j-1,in, mem);
		mem[j] = Math.max(incj, nincj);
		return mem[j];
	}
	public static int maxContgSum2(int[] in) {
		int[] mem = new int[in.length + 1];
		auxContgSum2(in.length, in, mem);
		return mem[in.length];
	}
	
	public static int maxContgSum3(int[] in) {
		int[] mem = new int[in.length + 1];
		mem[0] = 0;
		mem[1] = in[0];
		for(int j = 2; j <= in.length; ++j) {
			mem[j] = Math.max(mem[j-1], mem[j-2] + in[j-1]);
		}		
		return mem[in.length];
	}
	public static void main(String[] args) {
		//int[] in = { 1,5,4,3,6 };
		//System.out.println(maxContgSum1(in));
		
		Random r = new Random(100);
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i) {
			in[i] = r.nextInt(10) + 1;
			//System.out.print(in[i]  + " ");
		}
		//System.out.println();
		//System.out.println(maxContgSum1(in));
		//System.out.println(maxContgSum2(in));
		System.out.println(maxContgSum3(in));
	}

}
