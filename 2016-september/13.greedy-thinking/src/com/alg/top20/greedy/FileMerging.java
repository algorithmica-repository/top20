package com.alg.top20.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

import com.google.common.collect.TreeMultiset;

public class FileMerging {

	public static int minCostFileMerge1(int[] in) {
		return 0;
	}

	public static int minCostFileMerge2(int[] in) {
		LinkedList<Integer> files = new LinkedList<Integer>();
		for (int i = 0; i < in.length; ++i) {
			files.add(in[i]);
		}
		int totalcost = 0;
		Collections.sort(files);
		while (files.size() > 1) {
			int smallest1 = files.removeFirst();
			int smallest2 = files.removeFirst();
			totalcost += (smallest1 + smallest2);
			files.add(smallest1 + smallest2);
			Collections.sort(files);
		}
		return totalcost;
	}
	
	public static class MyComparator<Integer> implements Comparator {

		@Override
		public int compare(Object arg0, Object arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	public static int minCostFileMerge2(int[] in) {
		TreeMultiset<Integer> files =  null;
		for (int i = 0; i < in.length; ++i) {
			files.add(in[i]);
		}
		int totalcost = 0;
		while (files.size() > 1) {
			int smallest1 = files.
			int smallest2 = files.removeFirst();
			totalcost += (smallest1 + smallest2);
			files.add(smallest1 + smallest2);
		}
		return totalcost;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		Random r = new Random(100);
		int[] in = new int[n];
		
		for(int i = 0; i < n; ++i) {
			in[i] = r.nextInt(10) + 1;
			//System.out.println(in[i]);
		}
		
		System.out.println(minCostFileMerge2(in));

	}

}
