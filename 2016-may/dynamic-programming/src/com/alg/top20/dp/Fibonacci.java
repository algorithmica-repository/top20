package com.alg.top20.dp;

public class Fibonacci {

	public static long getFib1(int n) {
		if(n <= 2) return 1L;
		return getFib1(n - 1) + getFib1(n - 2);		
	}
	
	private static long auxFib2(int n, long[] mem) {
		if(n <= 2) return 1L;
		if(mem[n] != 0) return mem[n];
		mem[n] = auxFib2(n - 1, mem) + auxFib2(n - 2, mem);
		return mem[n];
	}
	public static long getFib2(int n) {
		long[] mem = new long[n + 1];
		auxFib2(n, mem);
		return mem[n];
	}
	
	public static long getFib3(int n) {
		long[] mem = new long[n + 1];
		mem[1] = mem[2] = 1;
		for(int i = 3; i <= n; ++i) {
			mem[i] = mem[i-1] + mem[i-2];
		}
		return mem[n];
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(getFib3(n));
	}

}
