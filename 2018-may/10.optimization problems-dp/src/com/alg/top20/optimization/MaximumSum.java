package com.alg.top20.optimization;
import java.util.Arrays;
import java.util.Random;


public class MaximumSum {

	public static int maxSum1(int[] in) {
		return auxSum1(in.length, in);
	}
	public static int auxSum1(int i, int[] in) {
		if(i == 0) return 0;
		if(i == 1) return in[i-1];
		int exclusive = auxSum1(i-1, in);
		int inclusive = auxSum1(i-2, in) + in[i-1];
		return Math.max(exclusive, inclusive);
	}
	
	public static int maxSum2(int[] in) {
		int[] mem = new int[in.length+1];
		auxSum2(in.length, in, mem);
		return mem[in.length];
	}
	public static int auxSum2(int i, int[] in, int[] mem) {
		if(i == 0) return 0;
		if(i == 1) return in[i-1];
		if(mem[i] != 0) return mem[i];
		int exclusive = auxSum2(i-1, in, mem);
		int inclusive = auxSum2(i-2, in, mem) + in[i-1];
		mem[i] = Math.max(exclusive, inclusive);
		//System.out.println(Arrays.toString(mem));
		return mem[i];
	}
	
	//TC:O(n)  SC:O(n)
	private static void getOptimalPath(int i, int[] mem) {
		if(i == 1) {
			System.out.println(i);
			return;
		}
		if(mem[i] == mem[i-1]) {
			getOptimalPath(i-1, mem);
		} else {
			getOptimalPath(i-2, mem);
			System.out.println(i);
		}
	}
	public static int maxSum3(int[] in) {
		int[] mem = new int[in.length+1];
		mem[0] = 0;
		mem[1] = in[0];
		for(int i = 2; i <= in.length; ++i) {
			int exclusive = mem[i-1];
			int inclusive = mem[i-2] + in[i-1];
			mem[i] = Math.max(exclusive, inclusive);
		}	
		System.out.println(Arrays.toString(mem));
		getOptimalPath(in.length, mem);
		return mem[in.length];
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(n) + 1;
		System.out.println(Arrays.toString(in));
		//System.out.println(maxSum2(in));
		System.out.println(maxSum3(in));

	}

}
