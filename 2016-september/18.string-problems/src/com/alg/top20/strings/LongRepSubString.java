package com.alg.top20.strings;

import java.util.HashSet;
import java.util.Random;

import com.alg.top20.trie.ITrie;
import com.alg.top20.trie.TernarySearchTree;

public class LongRepSubString {

	// tc: O(n3) sc:O(n)
	public static int findLRSubstr1(String s) {
		HashSet<String> set = new HashSet<String>();
		int n = s.length();
		for (int l = n - 1; l >= 1; --l) {
			for (int i = 0; i <= n - l; ++i) {
				String tmp = s.substring(i, i + l);
				// System.out.println(tmp);
				if (set.contains(tmp))
					return l;
				else
					set.add(tmp);
			}
			set.clear();
		}
		return 0;
	}

	private static int findCommonPrefixLength(String s, int i, int j) {
		int clength = 0;
		while (j < s.length()) {
			if (s.charAt(i++) == s.charAt(j++))
				++clength;
			else
				break;
		}
		return clength;
	}

	// tc: O(n3) sc:O(1)
	public static int findLRSubstr2(String s) {
		int n = s.length();
		int maxl = 0;
		for (int i = 0; i < n; ++i) {
			//System.out.println(s.substring(i));
			for (int j = i + 1; j < n; ++j) {
				//System.out.println(s.substring(j));
				int common_prefix_l = findCommonPrefixLength(s, i, j);
				maxl = Math.max(common_prefix_l, maxl);
			}
			//System.out.println();
		}
		return maxl;
	}

	//use trie for storing all suffixes
	/*public static int findLRSubstr3(String s) {
		int n = s.length();
		Trie t = new TernarySearchTree();
		for (int i = 0; i < n; ++i) {
			t.add(s.substring(i));
		}
		//start from longest suffix to shortest suffix for max prefix match
		int maxl = 0;
		for(int i = 0; i < n; ++i) {
			t.remove(s.substring(i));
			int l = t.findLongestPrefix(s.substring(i));
			maxl = Math.max(l, maxl);
		}
		return maxl;
	}*/
	
	//use suffix trie tc: O(n2) sc:O(n2)
	public static int findLRSubstr3(String s) {
		int n = s.length();
		ITrie t = new TernarySearchTree();
		int maxl = 0;
		for(int i = n-1; i >=0; --i) {
			int l = t.findLongestCommonPrefix(s.substring(i));
			maxl = Math.max(l, maxl);
			t.add(s.substring(i));
		}
		return maxl;
	}
	
	//use suffix array tc:O() sc:O(n)
	public static int findLRSubstr4(String s) {
		int[] sarray = new int[s.length()];
		for(int i = 0; i < s.length(); ++i)
			sarray[i] = i;
		suffix_sort(sarray);
	
		int maxl = 0;
		for(int i = 0; i < s.length(); ++i) {
			int l = findCommonPrefixLength(sarray, i, i+1);
			maxl = Math.max(l, maxl);
		}
		return maxl;
	}
	public static void main(String[] args) {
		Random r = new Random(100);
		String s = "";
		int n = Integer.parseInt(args[0]);
		for (int i = 0; i < n; ++i) {
			s = s + (char) (97 + r.nextInt(26));
		}
		// System.out.println(s);
		System.out.println(findLRSubstr4("aaaaaa"));
		// System.out.println("abcd".substring(0,3));

	}

}
