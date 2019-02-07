package com.alg.top20.setmap;

import java.util.*;

public class GroupAnagrams {

	// TC:O(m n^2) SC:O(n)
	public static void groupAnagrams1(String[] in) {
		boolean[] used = new boolean[in.length];
		for (int i = 0; i < in.length; ++i) {
			if (!used[i]) {
				System.out.print(in[i] + " ");
				for (int j = i + 1; j < in.length; ++j) {
					if (AnagramCheck.anagramCheck21(in[i], in[j])) {
						used[j] = true;
						System.out.print(in[j] + " ");
					}
				}
				System.out.println();
			}
		}
	}

	// TC:O(nm log m) SC:O(nm)
	public static void groupAnagrams2(String[] in) {
		HashMap<String, List<String>> hmap = new HashMap<String, List<String>>();
		for (int i = 0; i < in.length; ++i) {
			char[] tmp1 = in[i].toCharArray();
			Arrays.sort(tmp1);
			String tmp2 = Arrays.toString(tmp1);
			List<String> val = hmap.get(tmp2);
			if (val == null) {
				ArrayList<String> list = new ArrayList<String>();
				list.add(in[i]);
				hmap.put(tmp2, list);
			} else
				val.add(in[i]);
		}
		for (String tmp : hmap.keySet())
			System.out.println(tmp + ":" + hmap.get(tmp));
	}

	static class Pair {
		String s1;
		String s2;

		public Pair(String s1, String s2) {
			this.s1 = s1;
			this.s2 = s2;
		}
		
		public String toString() {
			return "(" + s1 + "," + s2 + ")";
		}
	}

	static class MyComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair p1, Pair p2) {
			return p1.s1.compareTo(p2.s1);
		}

	}

	// TC:O(nm log m + nm log n) ~ O(nm log nm) SC:O(nm)
	public static void groupAnagrams3(String[] in) {
		ArrayList<Pair> list = new ArrayList<Pair>();
		// horizontal sort
		for (String tmp : in) {
			char[] tmp1 = tmp.toCharArray();
			Arrays.sort(tmp1);
			String tmp2 = Arrays.toString(tmp1);
			list.add(new Pair(tmp2, tmp));
		}
		// vertical sort
		Collections.sort(list, new MyComparator());
		System.out.println(list);
	}

	public static void main(String[] args) {
		String[] in = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(Arrays.toString(in));
		groupAnagrams1(in);
		System.out.println();
		groupAnagrams2(in);
		System.out.println();
		groupAnagrams3(in);
	}

}
