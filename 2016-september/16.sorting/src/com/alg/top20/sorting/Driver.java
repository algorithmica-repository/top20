package com.alg.top20.sorting;

import java.util.Arrays;
import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		int size = Integer.parseInt(args[0]);
		int[] in = new int[size];
		Random r = new Random(100);
		for(int i = 0; i <size; ++i)
			in[i] = r.nextInt(100000000) + 1;
		//System.out.println(Arrays.toString(in));
		
		long start = System.currentTimeMillis();
		Sorting.quick_sort5(in);
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start)/1000.0 + " seconds");
		
		//System.out.println(Arrays.toString(in));
	}

}
