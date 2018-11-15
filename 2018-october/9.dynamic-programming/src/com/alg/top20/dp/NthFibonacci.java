package com.alg.top20.dp;

public class NthFibonacci {

	public static int fib1(int n) {
		if(n <= 2) return 1;
		return fib1(n-1) + fib1(n-2);
	}
	
	public static int fib2(int n) {
		int[] mem = new int[n+1];
		auxFib2(n, mem);
		return mem[n];
	}
	private static int auxFib2(int n, int[] mem) {
		if(n <= 2) return 1;
		if(mem[n] != 0) return mem[n];
		mem[n] = auxFib2(n-1, mem) + auxFib2(n-2, mem);
		return mem[n];
	}
	
	public static int fib3(int n) {
		int[] mem = new int[n+1];
		mem[1] = mem[2] = 1;
		for(int i = 3; i <= n; ++i)
			mem[i] = mem[i-1] + mem[i-2];
		return mem[n];
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		//System.out.println(fib1(n));
		//System.out.println(fib2(n));
		System.out.println(fib3(n));
	}

}
