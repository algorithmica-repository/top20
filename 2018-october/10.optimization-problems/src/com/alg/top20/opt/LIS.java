package com.alg.top20.opt;

import java.util.Arrays;
import java.util.Random;

public class LIS {

	//naive
	public static int lis1(int[] in) {
		MyInteger max = new MyInteger(0);
		for(int i = in.length; i >= 1; --i) { 
			auxlis1(i, in, 0, max);
			System.out.println(max.get());
		}
		return max.get();
	}
	private static void auxlis1(int i, int[] in, int length, MyInteger max) {
		if(i == 1) {
			max.set(Math.max(max.get(), length+1));
			return;
		}
		for(int j = 1; j < i; ++j) {
			if(in[i-1] > in[j-1])
				auxlis1(j, in, length+1, max);
		}
		max.set(Math.max(max.get(), length+1));
	}
		
	//recursion
	public static int lis2(int[] in) {
		int max = 0;
		for(int i = in.length; i >= 1; --i) {
			int tmp = auxlis2(i, in);
			//System.out.println(tmp);
			max = Math.max(max, tmp);
		}
		return max;
	}
	private static int auxlis2(int i, int[] in) {
		int max = 1;
		if(i <= 1) return i;
		for(int j = 1; j < i; ++j) {
			if(in[i-1] > in[j-1])
				max = Math.max(max, auxlis2(j, in)+1);
		}
		return max;
	}
	
	//memoization
	public static int lis3(int[] in) {
		int max = 0;
		int[] mem = new int[in.length+1];
		for(int i = in.length; i >= 1; --i) {
			int tmp = auxlis3(i, in, mem);
			//System.out.println(tmp);
			max = Math.max(max, tmp);
		}
		return max;
	}
	private static int auxlis3(int i, int[] in, int[] mem) {
		int max = 1;
		if(i <= 1) return i;
		if(mem[i] != 0) return mem[i];
		for(int j = 1; j < i; ++j) {
			if(in[i-1] > in[j-1])
				max = Math.max(max, auxlis3(j, in, mem)+1);
		}
		return mem[i] = max;
	}
	
	//dynamic programming
	public static int lis4(int[] in) {
		int max = 0;
		int[] mem = new int[in.length+1];
		mem[1] = 1;
		for(int i = 2; i <= in.length; ++i) {
			int tmp = 1;
			for(int j = 1; j < i; ++j) {
				if(in[i-1] > in[j-1])
					tmp = Math.max(tmp, mem[j]+1);
			}
			mem[i] = tmp;
			max = Math.max(max, tmp);
		}
		return max;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(20)+1;
		System.out.println(Arrays.toString(in));
		//System.out.println(lis2(in));
		System.out.println(lis1(in));
		System.out.println(lis2(in));

	}

}
