package com.alg.top20.mc.sorting;

import java.util.Arrays;
import java.util.Random;

public class ParallelDriver {

	public static void main(String[] args) throws Exception {
		int size = Integer.parseInt(args[0]);
		int[] in = new int[size];
		Random rand = new Random(100);
		for(int i = 0; i <size; ++i)
			in[i] = rand.nextInt(100000000) + 1;
		
		//System.out.println(Arrays.toString(in));
		
		int ncores = Runtime.getRuntime().availableProcessors();
		int part_size = size / ncores;
		SortThread[] threads = new SortThread[ncores];
		int l = 0;
		for(int i = 0; i < ncores; ++i) {
			int r = l + part_size-1;
			threads[i] = new SortThread(in, l, r);
			//System.out.println(l + " " + r);
			l = r+1;			
		}
		for(int i = 0; i < ncores; ++i) {
			threads[i].start();
		}
		for(int i = 0; i < ncores; ++i) {
			threads[i].join();
		}
		//merge of 4-sorted pieces into one
		
		//System.out.println(Arrays.toString(in));
		
		/*long start = System.currentTimeMillis();
		
		long end = System.currentTimeMillis();
		System.out.println("time:" + (end-start)/1000.0 + " seconds");
		
		//System.out.println(Arrays.toString(in));
*/	}

}
