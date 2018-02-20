package com.alg.top20.ds.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class IdenticalArrays {

	public static boolean isIdentical1(int[] in1, int[] in2) {
		Arrays.sort(in1);
		Arrays.sort(in2);
		for(int i = 0; i < in1.length; ++i) {
			if(in1[i] != in2[i]) return false;
		}
		return true;
	}
	
	public static boolean isIdentical2(int[] in1, int[] in2) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		for(int i = 0; i < in1.length;++i) {
			Integer value = hmap.get(in1[i]);
			if(value == null) 
				hmap.put(in1[i], 1);
			else
				hmap.put(in1[i], value+1);
		}
		for(int i = 0; i < in2.length; ++i) {
			Integer value = hmap.get(in2[i]);
			if(value == null) return false;
			if(value > 1)
				hmap.put(in2[i], value-1);
		}
		return true;	
	}
		
		
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in1 = new int[n];
		int[] in2 = new int[n];
		//testcase 1
		Random r = new Random(100);
		for(int i = 0; i < n; ++i)
			in1[i] = in2[n-1-i] = r.nextInt(n);
		//System.out.println(Arrays.toString(in1));
		//System.out.println(Arrays.toString(in2));

		long start = System.currentTimeMillis();
		System.out.println(isIdentical1(in1, in2));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 +"seconds");

	}

}
