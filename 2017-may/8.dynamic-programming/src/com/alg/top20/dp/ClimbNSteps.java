package com.alg.top20.dp;

public class ClimbNSteps {

	//TC: O(2 ^ n)   SC:O(n)
	public static long climbcount1(int n) {
		if(n <= 2) return n;
		//reduction and solution building
		return climbcount1(n-1) + climbcount1(n-2);
	}
	
	//TC: O(n)   SC:O(n) ~ n + n
	public static long climbcount2(int n) {
		long[] mem = new long[n+1];
		auxcount2(n, mem);
		return mem[n];
	}
	private static long auxcount2(int n, long[] mem) {
		if(n <= 2) return n;
		//lookup memory for existing solution
		if(mem[n] != 0) return mem[n];
		//fill the memory with solution of subproblems
		mem[n] = auxcount2(n-1, mem) + auxcount2(n-2, mem);
		return mem[n];
	}
	
	//TC: O(n)   SC:O(n)
	public static long climbcount3(int n) {
		long[] mem = new long[n+1];
		mem[1] = mem[2] = 1;
		for(int i = 3; i <= n; ++i)
			mem[i] = mem[i-1] + mem[i-2];
		return mem[n];
	}
	
	//TC: O(n)   SC:O(1)
	public static long climbcount4(int n) {
		long last1, last2, current = 0;
		last2 = 1;
		last1 = 2;
		for(int i = 3; i <= n; ++i) {
			current = last1 + last2;
			last2 = last1;
			last1 = current;
		}
		return current;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
