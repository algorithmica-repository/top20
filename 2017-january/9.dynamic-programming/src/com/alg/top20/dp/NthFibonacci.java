package com.alg.top20.dp;

public class NthFibonacci {
	
	//tc:O(2 ^ n)   sc:O(n)
	public static int fib1(int n) {
		if(n <= 2) return 1; 
		int prev1 = fib1(n-1);
		int prev2 = fib1(n-2);
		return prev1 + prev2;
	}
	
	//tc:O(n)   sc:O(n) = n  + n
	public static int fib2(int n) {
		int[] mem = new int[n+1];
		auxfib2(n, mem);
		return mem[n];
	}
	private static int auxfib2(int n, int[] mem) {
		if(n <= 2) return 1; 
		//look up memory
		if(mem[n] != 0) return mem[n];
		int prev1 = auxfib2(n-1, mem);
		int prev2 = auxfib2(n-2, mem);
		//fill  memory with subproblem solutions
		return mem[n] = prev1 + prev2;
	}
	
	//tc:O(n)   sc:O(n) = n
	public static int fib3(int n) {
		int[] mem = new int[n+1];
		mem[1] = mem[2] = 1;
		//fill up memory from bottom-up manner
		for(int i = 3; i <= n; ++i)
			mem[i] = mem[i-1] + mem[i-2];
		return mem[n];
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(fib3(n));
	}

}
