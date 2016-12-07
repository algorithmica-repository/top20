package com.alg.top20.mc.sorting;

import java.util.Arrays;

public class Sorting {
	private static void swap(int[] in, int i, int j) {
		int tmp = in[i];
		in[i] = in[j];
		in[j] = tmp;
	}

	public static void selection_sort_seq(int[] in) {
		for(int i = 0; i < in.length-1; ++i) {
			int min_index = i;
			for(int j = i+1; j < in.length; ++j) {
				if(in[j] < in[min_index]) {
					min_index = j;
				}
			}
			swap(in, i, min_index);
			//System.out.println(Arrays.toString(in));
		}
	}
}
