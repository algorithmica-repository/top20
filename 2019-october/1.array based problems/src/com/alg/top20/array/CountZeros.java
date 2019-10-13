package com.alg.top20.array;

import java.util.Arrays;
import java.util.Random;

public class CountZeros {

	public static int count1(int[] in) {
		int i;
		for (i = 0; i < in.length; ++i) {
			if (in[i] != 0)
				break;
		}
		return i;
	}

	public static int count2(int[] in) {
		int left = 0, right = in.length - 1;
		while (right - left > 1) {
			int mid = (left + right) / 2;
			if (in[mid] == 0)
				left = mid;
			else
				right = mid - 1;
		}
		if (in[right] == 0)
			return right + 1;
		return left + 1;

	}
	
	public static int[] testCase1(int n) {
		int[] in = new int[n];
		Random r =new Random(0);
		int p = r.nextInt(n);
		for(int i = 0; i <= p; ++i)
			in[i] = 0;
		for(int i = p+1; i < n; ++i)
			in[i] = r.nextInt(10)+1;
		return in;
	}

	public static void main(String[] args) {// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
		int[] in = testCase1(n);
		//System.out.println(Arrays.toString(in));
		long start = System.currentTimeMillis();
		System.out.println(count1(in));
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start)/1000.0 +"secs");
	}

}
