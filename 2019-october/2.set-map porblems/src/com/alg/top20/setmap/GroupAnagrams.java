package com.alg.top20.setmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GroupAnagrams {
	
	public static boolean checkAnagram(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		int[] count = new int[26];
		for(int i = 0; i < s1.length(); ++i)
			++count[s1.charAt(i)-'a'];
		for(int i = 0; i < s2.length(); ++i) {
			if(count[s2.charAt(i)-'a'] == 0) return false;
			--count[s2.charAt(i)-'a'];
		}
		return true;
	}

	public static void groupAnagrams1(String[] in) {
		boolean[] used = new boolean[in.length];
		for (int i = 0; i < in.length; ++i) {
			if (used[i])
				continue;
			System.out.println(in[i]);
			for (int j = i + 1; j < in.length; ++j) {
				if (checkAnagram(in[i], in[j])) {
					System.out.println(in[j]);
					used[j] = true;
				}
			}
			System.out.println();
		}
	}
	static class Pair {
		String first;
		String second;
		public Pair(String first, String second) {
			this.first = first;
			this.second = second;
		}
		@Override
		public String toString() {
			return "Pair [first=" + first + ", second=" + second + "]";
		}
		
	}
	static class MyComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair o1, Pair o2) {
			return o1.first.compareTo(o2.first);
		}
		
	}
	public static void groupAnagrams2(String[] in) {
		Pair[] aux = new Pair[in.length];
		for(int i = 0; i < in.length; ++i) {
			char[] tmp = in[i].toCharArray();
			Arrays.parallelSort(tmp);
			String sorted_string = String.valueOf(tmp);
			aux[i] = new Pair(sorted_string, in[i]);
		}		
		Arrays.parallelSort(aux, new MyComparator());
		for(Pair tmp: aux)
			System.out.println(tmp);
	}

	public static void groupAnagrams3(String[] in) {
		HashMap<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();
		for(String s: in) {
			char[] tmp = s.toCharArray();
			Arrays.parallelSort(tmp);
			String sorted_string = String.valueOf(tmp);
			if(hmap.containsKey(sorted_string)) {
				hmap.get(sorted_string).add(s);
			} else {
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				hmap.put(sorted_string, list);
			}
		}
		for(String key:hmap.keySet()) {
			System.out.println(key + ":" + hmap.get(key));
		}		
	}

	public static String[] testCase1(int n, int k) {
		String[] in = new String[n];
		Random r = new Random(0);
		for (int i = 0; i < n; ++i) {
			String tmp = "";
			for (int j = 0; j < k; ++j)
				tmp += (char) ('a' + r.nextInt(26));
			in[i] = tmp;
		}
		return in;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		String[] in = testCase1(n, k);
		for(String tmp: in)
			System.out.print(tmp+ ",");
		System.out.println();
		groupAnagrams2(in);
	}

}
