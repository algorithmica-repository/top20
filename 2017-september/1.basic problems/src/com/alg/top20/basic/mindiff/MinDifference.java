package com.alg.top20.basic.mindiff;

import java.util.Arrays;
import java.util.Random;

public class MinDifference {

	//TC: O(n ^ 2)   
	//SC:O(1)
	public static int findMinDiff1(int[] in1, int[] in2) {
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < in1.length; ++i) {
			for(int j = 0; j < in2.length; ++j) {
				min = Math.min(min, Math.abs(in1[i] - in2[j]));
			}
		}
		return min;			
	}
	
	//TC: O(n log n)   
	//SC:O(1)
	public static int findMinDiff2(int[] in1, int[] in2) {
		int min = Integer.MAX_VALUE;
		Arrays.sort(in1);
		Arrays.sort(in2);
		int i = 0, j = 0;
		while(i < in1.length && j < in2.length) {
			min = Math.min(min, Math.abs(in1[i] - in2[j]));
			if(in1[i] == in2[j]) {
				++i;
				++j;
			} else if(in1[i] < in2[j])
				++i;
			else
				++j;			 
		}
		return min;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in1 = new int[n];
		int[] in2 = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; ++i) {
			in1[i] = r.nextInt(n);
			in2[i] = r.nextInt(n) + n;
		}
		//System.out.println(Arrays.toString(in1));
		//System.out.println(Arrays.toString(in2));

		
		//System.out.println(findMinDiff2(in1, in2));

		long start = System.currentTimeMillis();
		System.out.println(findMinDiff2(in1, in2));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + " seconds");

	}

}
