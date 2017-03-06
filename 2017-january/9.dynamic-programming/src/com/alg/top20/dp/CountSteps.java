package com.alg.top20.dp;

public class CountSteps {

	//TC:O(3^n) SC:O(n) pure recursion
	public static long countSteps1(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;
		long prev1 = countSteps1(n-1);
		long prev2 = countSteps1(n-2);
		long prev3 = countSteps1(n-3);
		return prev1 + prev2 + prev3;
	}
	
	//TC:O(n) SC:O(n+n)- O(n) memoization
	public static long countSteps2(int n) {
		long[] mem = new long[n+1];
		auxCountSteps2(n, mem);
		return mem[n];
	}
	private static long auxCountSteps2(int n, long[] mem) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;
		if(mem[n] != 0) return mem[n];
		long prev1 = auxCountSteps2(n-1, mem);
		long prev2 = auxCountSteps2(n-2, mem);
		long prev3 = auxCountSteps2(n-3, mem);
		return mem[n]= prev1 + prev2 + prev3;
	}
	
	//TC:O(n) SC:O(n) dp
	public static long countSteps3(int n) {
		long[] mem = new long[n+1];
		mem[1] = 1;
		mem[2] = 2;
		mem[3] = 4;
		for(int i = 4; i <= n; ++i)
			mem[i] = mem[i-1] + mem[i-2] + mem[i-3] ;
		return mem[n];
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(countSteps3(n));
	}

}
