package com.alg.top20.sortedds;

import java.util.HashMap;
import java.util.Map.Entry;

import com.google.common.collect.Ordering;
import com.google.common.collect.TreeMultimap;

public class SortByFrequency {

	public static String sortByFreq1(String s) {
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length(); ++i) {
			if(hmap.containsKey(s.charAt(i)))
				hmap.put(s.charAt(i), hmap.get(s.charAt(i))+1);
			else
				hmap.put(s.charAt(i), 1);
		}
		TreeMultimap<Integer, Character> tmmap = TreeMultimap.create(Ordering.natural().reverse(), Ordering.natural());
		for(Entry<Character, Integer> entry: hmap.entrySet()){
			tmmap.put(entry.getValue(), entry.getKey());
		}
		System.out.println(tmmap);
		return null;
	}
	public static void main(String[] args) {
		sortByFreq1(args[0]);

	}

}
