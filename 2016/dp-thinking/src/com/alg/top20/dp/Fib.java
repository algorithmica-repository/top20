package com.alg.top20.dp;

public class Fib {

	public static int fib1(int n) {
		if(n <= 2) return 1;
		return fib1(n-1) + fib1(n-2);
	}
	public static long fib2(int n) {
		long[] mem = new long[n+1];
		auxfib2(n,mem);
		return mem[n];
	}
	
	private static long auxfib2(int n, long[] mem) {
		if(n <= 2) return 1;
		if(mem[n] != 0) return mem[n];
		mem[n] = auxfib2(n-1,mem) + auxfib2(n-2,mem);
		return mem[n];
	}
	
	public static long fib3(int n) {
		long[] mem = new long[n+1];
		mem[1]=mem[2]=1;
		for(int i = 3; i < mem.length; ++i) {
			mem[i] = mem[i-1] + mem[i-2];
		}
		return mem[n];
	}
	
	public static void main(String[] args) {
		//System.out.println(fib2(1000));
		System.out.println(fib3(1000));
		//fib(30);
	}

}
