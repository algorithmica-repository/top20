package com.alg.top20.array;

import java.util.Arrays;

public class FindDuplicate {

	public static int findDuplicate1(int[] in) {
		int n = in.length;
		for (int i = 0; i < n - 1; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (in[j] == in[i])
					return in[i];
			}
		}
		return -1;
	}
	
	public static int findDuplicate2(int[] in) {
		int n = in.length;
		Arrays.parallelSort(in);
		for (int i = 1; i < n; ++i) 
			if(in[i] == in[i-1]) return in[i];
		return -1;
	}
	
	public static int findDuplicate3(int[] in) {
		int n = in.length;
		int[] aux = new int[n];
		for (int i = 0; i < n; ++i) {
			if(aux[in[i]] == 1) return in[i];
			aux[in[i]] = 1;
		}
		return -1;
	}
	
	public static int findDuplicate4(int[] in) {
		int n = in.length;
		for (int i = 0; i < n; ++i) {
			int tmp = Math.abs(in[i]);
			if(in[tmp] < 0) return tmp;
			in[tmp] *= -1;
		}
		return -1;
	}

	public static int[] testcase1(int n) {
		int[] in = new int[n];
		for(int i = 0; i < n-1; ++i) {
			in[i] = i+1;
		}
		in[n-1] = n-1;
		return in;
	}
	
	public static int[] testcase2(int n) {
		int[] in = new int[n];
		for(int i = 0; i < n-1; ++i) {
			in[i] = n-1-i;
		}
		in[n-1] = n-1;
		return in;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = testcase1(n);
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		int res = findDuplicate4(in);
		long end = System.currentTimeMillis();
		System.out.println(res);
		System.out.println("Time taken:" + (end-start) /1000.0 + " secs");
	}

}
