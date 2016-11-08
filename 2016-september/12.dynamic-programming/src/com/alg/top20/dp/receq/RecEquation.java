package com.alg.top20.dp.receq;

public class RecEquation {
	
	public static long solution1(int n) {
		if(n <= 2) return n+1;
		return solution1(n-1) + solution1(n-2) + solution1(n-3);
	}
	
	public static long solution2(int n) {
		long[] mem = new long[n+1];
		auxSolution2(n, mem);
		return mem[n];
	}
	private static long auxSolution2(int n, long[] mem) {
		if(n <= 2) return n+1;
		if(mem[n] != 0) return mem[n];
		mem[n] = auxSolution2(n-1, mem) + auxSolution2(n-2, mem) + auxSolution2(n-3, mem);
		return mem[n];
	}
	
	public static long solution3(int n) {
		long[] mem = new long[n+1];
		mem[0] = 1;
		mem[1] = 2;
		mem[2] = 3;
		for(int i = 3; i <= n; ++i) {
			mem[i] = mem[i-1] + mem[i-2] + mem[i-3];
		}
		return mem[n];
	}
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(solution3(n));
	}
}
