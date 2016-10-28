package com.alg.top20.basic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Finduplicate {

	static int findDuplicate1(int[] in) {
		//n log n
		Arrays.sort(in);
		//<= n-1
		for(int i = 1; i < in.length; ++i) {
			if(in[i] == in[i-1]) return in[i];
		}
		return -1;
	}

	static int findDuplicate2(int[] in) {
		//<= n * c
		for(int i = 0; i < in.length; ++i) {
			int tmp = Math.abs(in[i]);
			if(in[tmp] < 0)
				return tmp;
			else 
				in[tmp] *= -1; 
		}
		return -1;
	}
	
	static int findDuplicate3(int[] in) {
		HashSet<Integer> hset = new HashSet<Integer>();
		//<= n * 2 * c
		for(int i = 0; i < in.length; ++i) {
			if(hset.contains(in[i])) return in[i];
			else
				hset.add(in[i]);
		}
		return -1;
	}
	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		
		int[] in = new int[size];
		int i;
		for(i = 0; i < in.length-1; ++i) {
			in[i] = i + 1;
		}
		Random r = new Random();
		//System.out.println(r.nextInt(9)+1);
		in[i] = r.nextInt(in.length-1) + 1;
		
		long start = System.currentTimeMillis();
		System.out.println(findDuplicate1(in));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 + "seconds");

		start = System.currentTimeMillis();
		System.out.println(findDuplicate3(in));
		end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 + "seconds");

	}

}
