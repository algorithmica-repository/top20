package com.alg.top20.setmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class IdenticalArrays {

	//TC:O(n log n)  SC:O(1)
	public static boolean isIdentical1(int[] in1, int[] in2) {
		Arrays.sort(in1);
		Arrays.sort(in2);
		for(int i = 0; i < in1.length; ++i) {
			if(in1[i] != in2[i]) return false;		
		}
		return true;
	}
	//TC:O(n)  SC:O(n)
	public static boolean isIdentical2(int[] in1, int[] in2) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>(); 
		for(int i = 0; i < in1.length; ++i) {
			Integer tmp = hmap.get(in1[i]);
			if(tmp == null)
				hmap.put(in1[i], 1);
			else
				hmap.put(in1[i], tmp+1);
		}
		//System.out.println(hmap);
		for(int i = 0; i < in2.length; ++i) {
			Integer tmp = hmap.get(in2[i]);
			if(tmp == null) return false;				
			else {
				if(tmp == 1) hmap.remove(in2[i]);
				else hmap.put(in2[i], tmp-1);
			}
		}			
		return true;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in1 = new int[n];
		int[] in2 = new int[n];
		Random r = new Random(100);
		for(int i = 0; i < n; ++i) {
			int tmp = r.nextInt(100)+1;
			in1[i] = in2[n-1-i] = tmp;
		}
		//System.out.println(Arrays.toString(in1));
		//System.out.println(Arrays.toString(in2));
		long start = System.currentTimeMillis();
		System.out.println(isIdentical2(in1, in2));
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start)/1000.0 + "secs");
	}

}
