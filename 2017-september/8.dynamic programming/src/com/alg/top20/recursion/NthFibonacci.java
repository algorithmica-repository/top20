package com.alg.top20.recursion;

public class NthFibonacci {

	//TC: O(2 ^ n)   SC:O(n)
	public static long fib1(int n) {
		if(n <= 2) return 1;
		//reduction and solution building
		return fib1(n-1) + fib1(n-2);
	}
	
	//TC: O(n)   SC:O(n)
	public static long fib2(int n) {
		long[] mem = new long[n+1];
		auxfib2(n, mem);
		return mem[n];
	}
	private static long auxfib2(int n, long[] mem) {
		if(n <= 2) return 1;
		//lookup memory for existing solution
		if(mem[n] != 0) return mem[n];
		//fill the memory with solution of subproblems
		mem[n] = auxfib2(n-1, mem) + auxfib2(n-2, mem);
		return mem[n];
	}
	
	//TC: O(n)   SC:O(n)
	public static long fib3(int n) {
		long[] mem = new long[n+1];
		mem[1] = mem[2] = 1;
		for(int i = 3; i <= n; ++i)
			mem[i] = mem[i-1] + mem[i-2];
		return mem[n];
	}
	
	//TC: O(n)   SC:O(1)
	public static long fib4(int n) {
		long last1, last2, current = 0;
		last2 = last1 = 1;
		for(int i = 3; i <= n; ++i) {
			current = last1 + last2;
			last2 = last1;
			last1 = current;
		}
		return current;
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(fib4(n));
	}
}
