package com.alg.top20.dp;

public class NthFibonacci {

	public static int fib1(int n) {
		if(n <= 2) return 1;
		int prev1 = fib1(n-1);
		int prev2 = fib1(n-2);
		return prev1 + prev2;
	}
	public static int fib2(int n) {
		int[] mem = new int[n+1];
		auxfib2(n, mem);
		return mem[n];
	}

	public static int auxfib2(int n, int[] mem) {
		if(n <= 2) return 1;
		if(mem[n] != 0) return mem[n];
		int prev1 = auxfib2(n-1, mem);
		int prev2 = auxfib2(n-2, mem);
		mem[n] = prev1 + prev2;
		return mem[n];
	}
	
	public static int fib31(int n) {
		int[] mem = new int[n+1];
		mem[1] = mem[2] = 1;
		for(int i = 3; i <= n; ++i)
			mem[i] = mem[i-1] + mem[i-2];
		return mem[n];
	}
	
	public static int fib32(int n) {
		int prev1 = 1, prev2 = 1, current = 0;
		for(int i = 3; i <= n; ++i) {
			current = prev1 + prev2;
			prev2 = prev1;
			prev1 = current;
		}
		return current;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		//System.out.println(fib2(n));
		System.out.println(fib31(n));
	}

}
