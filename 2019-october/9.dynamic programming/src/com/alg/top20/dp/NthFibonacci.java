package com.alg.top20.dp;

public class NthFibonacci {
	
	public static int fib1(int n) {
		if(n <= 2) return 1;
		return fib1(n-1) + fib1(n-2);
	}
	
	public static int fib2(int n) {
		int[] mem = new int[n+1];
		auxfib2(n, mem);
		return mem[n];
	}

	private static int auxfib2(int n, int[] mem) {
		if(n <= 2) return 1;
		if(mem[n] != 0) return mem[n];
		mem[n] = auxfib2(n-1, mem) + auxfib2(n-2, mem);
		return mem[n];
	}
	
	public static int fib3(int n) {
		int[] mem = new int[n+1];
		mem[1] = mem[2] = 1;
		for(int i = 3; i <= n; ++i)
			mem[i] = mem[i-1] + mem[i-2];
		return mem[n];
	}
	
	public static int fib4(int n) {
		if(n <= 2) return 1;
		int prev1 = 1;
		int prev2 = 1;
		int res = 0;
		for(int i = 3; i <= n; ++i) {
			res = prev1 + prev2;
			prev2 = prev1;
			prev1 = res;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(fib4(n));
	}

}
