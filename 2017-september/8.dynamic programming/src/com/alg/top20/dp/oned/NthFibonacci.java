package com.alg.top20.dp.oned;

public class NthFibonacci {

	//TC:O(2 ^ n)
	//SC:O(n)
	//Recursion
	public static int fib1(int n) {
		if(n <= 2) return 1;
		return fib1(n-1) + fib1(n-2);
	}
	
	//TC:O(n)
	//SC:O(n)
	//Recursion + memory = memoization
	public static int fib2(int n) {
		int[] mem = new int[n+1];
		auxfib(n, mem);
		return mem[n];
	}
	private static int auxfib(int n, int[] mem) {
		if(n <= 2) return 1;
		if(mem[n] != 0) return mem[n];
		mem[n] = auxfib(n-1, mem) + auxfib(n-2, mem);
		return  mem[n];
	}
	
	//TC:O(n)
	//SC:O(n)
	//No recursion + memory = dynamic programming
	public static int fib3(int n) {
		int[] mem = new int[n+1];
		mem[1] = mem[2] = 1;
		for(int j = 3; j <= n; ++j)
			mem[j] = mem[j-1] + mem[j-2];
		return mem[n];
	}
	
	//TC:O(n)
	//SC:O(1)
	//No recursion + memory = dynamic programming
	public static int fib4(int n) {
		if(n <= 2) return 1;
		int prev1, prev2, current = 0;
		prev1 = prev2 = 1;
		for(int j = 3; j <= n; ++j) {
			current = prev1 + prev2;
			prev2 = prev1;
			prev1 = current;
		}
		return current;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(fib3(n));
	}

}
