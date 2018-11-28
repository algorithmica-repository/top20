package com.alg.top20.sortedds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class KEmptySlots {

	//naive
	public static int kemptySlots1(int[] in, int k) {
		return 0;
	}
	
	//sorted set
	public static int kemptySlots2(int[] in, int k) {
		TreeSet<Integer> tset = new TreeSet<Integer>();
		tset.add(in[1]);
		for(int day = 2; day < in.length; ++day) {
			Integer prev = tset.floor(in[day]);
			if(prev != null && (in[day] - prev - 1) == k) return day;
			Integer next = tset.ceiling(in[day]);
			if(next != null && (next - in[day] - 1) == k) return day;
			tset.add(in[day]);
		}
		return -1;
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <= n; ++i)
			list.add(i);
		Collections.shuffle(list);
		int[] in = new int[n+1];
		for(int i = 1; i <= n; ++i)
			in[i] = list.remove(0);
		System.out.println(Arrays.toString(in));
		System.out.println(kemptySlots2(in, k));
	}

}
