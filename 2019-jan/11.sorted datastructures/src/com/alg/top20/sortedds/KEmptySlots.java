package com.alg.top20.sortedds;

import java.util.TreeSet;

public class KEmptySlots {

	//add boundary checks
	public static int kemptyslots1(int[] in, int k) {
		int[] non_empty_slots = new int[in.length];
		non_empty_slots[in[0]] = 1;
		int i, j;
		for(i = 1; i < in.length; ++i) {
			int cslot = in[i];
			//check k slots backward
			for(j = 1; j <= k; ++j) 
				if(non_empty_slots[cslot-j] != 0) break;
			if(j > k && non_empty_slots[cslot-j] != 0) return i+1;
			//check k slots forward
			for(j = 1; j <= k; ++j) 
				if(non_empty_slots[cslot+j] != 0) break;
			if(j > k && non_empty_slots[cslot+j] != 0) return i+1;
			non_empty_slots[in[i]] = 1;
		}
		return -1;
	}
	public static int kemptyslots2(int[] in, int k) {
		TreeSet<Integer> non_empty_slots = new TreeSet<Integer>();
		non_empty_slots.add(in[0]);
		for(int day = 1; day < in.length; ++day) {
			Integer floor_slot = non_empty_slots.floor(in[day]);
			if(floor_slot != null && in[day]-floor_slot-1 == k) return day+1;
			Integer ceil_slot = non_empty_slots.ceiling(in[day]);
			if(ceil_slot != null && ceil_slot-in[day]-1 == k) return day+1;
			non_empty_slots.add(in[day]);
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
