package com.alg.top20.setmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public class GroupAnagrams {

	//time:o(n^2 m)   space:O(n)
	public static void groupAnagrams1(String[] in)  {
		boolean[] used = new boolean[in.length];
		for(int i = 0; i < in.length; ++i) {
			if(used[i] == true) continue;
			System.out.print(in[i]+" ");
			for(int j  = i + 1; j < in.length; ++j) {
				if(Anagrams.anagrams2(in[i], in[j])) {
					System.out.print(in[j] +" ");
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
			super();
			this.first = first;
			this.second = second;
		}
	}
	
	static class MyComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair p1, Pair p2) {
			return p1.first.compareTo(p2.first);
		}
		
	}
	
	//time: n mlogm + m n logn + nm ~ O(nm log mn)
	//space:O(nm)
	public static void groupAnagrams2(String[] in)  {
		Pair[] elements = new Pair[in.length];
		for(int i = 0; i < in.length; ++i) {
			char[] tmp = in[i].toCharArray();
			Arrays.sort(tmp);
			String key = Arrays.toString(tmp);
			elements[i] = new Pair(key, in[i] );
		}
		Arrays.sort(elements, new MyComparator());
		System.out.print(elements[0].second + " ");
		for(int i = 1; i < elements.length; ++i){
			if(elements[i].first.equals(elements[i-1].first) )
				System.out.print(elements[i].second + " ");
			else {
				System.out.println();
				System.out.print(elements[i].second + " ");
			}			
		}	
	}
	//time: n * ( mlogm  + 2 *O(1)) ~ O(nm log m)
	//space:O(nm)
	public static void groupAnagrams3(String[] in)  {
		HashMap<String, ArrayList<String>> hmap = new HashMap<String, ArrayList<String>>();
		for(int i = 0; i < in.length; ++i) {
			char[] tmp = in[i].toCharArray();
			Arrays.sort(tmp);
			String key = Arrays.toString(tmp);
			ArrayList<String> val = hmap.get(key);
			if(val == null) {
				val = new ArrayList<String>();
				val.add(in[i]);
				hmap.put(key, val);
			} else {
				val.add(in[i]);
			}
		}
		for(Entry<String, ArrayList<String>> entry: hmap.entrySet())
			System.out.println(entry);
	}
	
	public static String randomString(Random r, int n) {
		String s  = "";
		for(int i = 0; i < n; ++i)
			s  = s + (char)('a' + r.nextInt(26));
		return s;		
	}
	public static String[] testcase1(int n, int m) {
		String[] in = new String[n];
		Random r = new Random(100);
		for(int i = 0; i < n; ++i) {
			in[i] = randomString(r, r.nextInt(m)+1);
		}
		return in;		
	}
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		String[] in = testcase1(n, m);
		System.out.println(Arrays.toString(in));
		//groupAnagrams1(in);
		groupAnagrams2(in);
		//groupAnagrams3(in);
	}

}
