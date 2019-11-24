package com.alg.top20.dp;

import java.util.Arrays;
import java.util.Random;

public class MaxNonConsSum {
	
	public static int maxNonConsSum1(int[] in) {
		MyInteger gmax = new MyInteger(0);
		auxNonConsSum1(in, 0, 0, gmax);
		return gmax.get();
	}
	private static void auxNonConsSum1(int[] in, int i, int psum, MyInteger gmax) {
		if(i >= in.length) {
			gmax.set(Math.max(psum, gmax.get()));
			return;
		}
		auxNonConsSum1(in, i+2, psum + in[i], gmax);
		auxNonConsSum1(in, i+1, psum, gmax);
	}
	
	public static int maxNonConsSum2(int[] in) {
		return auxNonConsSum2(in, 0);
	}
	private static int auxNonConsSum2(int[] in, int i) {
		if(i >= in.length) return 0;
		int inclusive = auxNonConsSum2(in, i+2);
		int exclusive = auxNonConsSum2(in, i+1);
		return Math.max(inclusive+in[i], exclusive);
	}
	
	public static int maxNonConsSum31(int[] in) {
		int[] mem = new int[in.length];
		auxNonConsSum31(in, 0, mem);
		System.out.println(Arrays.toString(mem));
		return mem[0];
	}
	private static int auxNonConsSum31(int[] in, int i, int[] mem) {
		if(i >= in.length) return 0;
		if(mem[i] != 0) return mem[i];
		int inclusive = auxNonConsSum31(in, i+2,  mem);
		int exclusive = auxNonConsSum31(in, i+1, mem);
		mem[i] = Math.max(inclusive+in[i], exclusive);
		return mem[i];
	}
	
	public static int maxNonConsSum32(int[] in) {
		int n = in.length;
		int[] mem = new int[n+2];
		mem[n+1] = mem[n] = 0;
		for(int  i = n-1; i >= 0; --i) {
			int inclusive = mem[i+2] + in[i];
			int exclusive = mem[i+1];
			mem[i] = Math.max(inclusive, exclusive);
		}
		System.out.println(Arrays.toString(mem));
		tracePath(mem, in);
		return mem[0];
	}
	private static void tracePath(int[] mem, int[] in) {
		for(int i = 0; i < in.length; ) {
			if(mem[i] == mem[i+1]) {
				i = i + 1;
			} else {
				System.out.print("(" + in[i] + "," + i + ")" + "->");
				i = i + 2;
			}
		}
		System.out.println();
	}


	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n)+1;
		System.out.println(Arrays.toString(in));
		//System.out.println(maxNonConsSum1(in));
		//System.out.println(maxNonConsSum2(in));
		//System.out.println(maxNonConsSum31(in));
		System.out.println(maxNonConsSum32(in));

	}

}
