package com.alg.basic;

import java.util.Arrays;
import java.util.HashSet;

public class FindNonRepeatednumber {

	// Solving with XOR logic
	public static int findUnRepeated1(int a[]) {
		int result = 0;
		for (int i = 0; i < a.length; i++)
			result ^= a[i];
		return result;
	}

	// Solution using sorting
	public static int findUnRepeated2(int a[]) {
		int i;
		Arrays.sort(a);
		for (i = 0; i < a.length - 1; i += 2)
			if (a[i] != a[i + 1])
				return a[i];
		return a[i];
	}

	// Solution with hashset
	public static int findUnRepeated3(int a[]) {
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < a.length; ++i) {
			if (hs.contains(a[i])) 
				hs.remove(a[i]);
			else
				hs.add(a[i]);
		}
		return hs.iterator().next();
	}
	
	public static void main(String[] args) {
		int i, j;
		int[] a = new int[11];
		for(i = 1, j = 0; i <=5; ++i, j = j+2) {
			a[j] = i;
			a[j+1] = i;
		}
		a[j] = i; 
	    System.out.println(Arrays.toString(a));	    
	    System.out.println(FindNonRepeatednumber.findUnRepeated1(a));	    
	    System.out.println(FindNonRepeatednumber.findUnRepeated2(a));
	    System.out.println(FindNonRepeatednumber.findUnRepeated3(a));
	}


}
