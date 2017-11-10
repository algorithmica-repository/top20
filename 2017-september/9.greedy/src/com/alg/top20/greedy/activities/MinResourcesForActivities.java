package com.alg.top20.greedy.activities;

import java.util.Arrays;

public class MinResourcesForActivities {

	//TC:O(n ^ 2)
	//SC:O(1)
	public static int findMinResources1(int[] start, int[] end) {
		int n = start.length;
		int maxOverlaps = 0;
		for(int i = 0; i < n; ++i) {
			int event = start[i];
			int count = 0;
			for(int j = 0; j < n; ++j) {
				if(start[j] <= event && end[j] > event)
					++count;
			}
			maxOverlaps = Math.max(maxOverlaps, count);
		}
		return maxOverlaps;
	}
	
	//TC:O(n log n)
	//SC:O(1)
	public static int findMinResources2(int[] start, int[] end) {
		int n = start.length;
		int maxOverlaps = 0;
		int count = 0;
		
		Arrays.sort(start);
		Arrays.sort(end);
		int i = 0, j = 0;
		while(i < n) {
			if(start[i] == end[j]) {
				++i;
				++j;
			} else if(start[i] < end[j]) {
				++count;
				++i;
				maxOverlaps = Math.max(maxOverlaps, count);
			} else {
				--count;
				++j;
			}			
		}
		return maxOverlaps;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
