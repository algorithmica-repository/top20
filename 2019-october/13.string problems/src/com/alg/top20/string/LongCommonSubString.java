package com.alg.top20.string;

import java.util.Arrays;

import com.alg.top20.string.trie.ITrie;
import com.alg.top20.string.trie.TSTTrie;

public class LongCommonSubString {

	private static int commonPrefix1(int i, int j, String s1, String s2) {
		int res = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				++i;
				++j;
				++res;
			} else
				break;
		}
		return res;
	}

	public static int longCommonSubstring1(String s1, String s2) {
		int maxl = 0;
		for (int i = 0; i < s1.length(); ++i) {
			for (int j = 0; j < s2.length(); ++j) {
				int res = commonPrefix1(i, j, s1, s2);
				maxl = Math.max(maxl, res);
			}
		}
		return maxl;
	}

	private static int commonPrefix2(String s1, String s2) {
		int res = 0;
		s1 = s1.substring(0, s1.length() - 1);
		s2 = s2.substring(0, s2.length() - 1);
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) == s2.charAt(j)) {
				++i;
				++j;
				++res;
			} else
				break;
		}
		return res;
	}

	public static int longCommonSubstring2(String s1, String s2) {
		String[] suffixes = new String[s1.length() + s2.length()];
		int k = 0;
		for (int i = 0; i < s1.length(); ++i) {
			suffixes[k++] = s1.substring(i) + "#";
		}
		for (int i = 0; i < s2.length(); ++i) {
			suffixes[k++] = s2.substring(i) + "$";
		}
		Arrays.sort(suffixes);
		//System.out.println(Arrays.toString(suffixes));
		int maxl = 0;
		for (int i = 1; i < suffixes.length; ++i) {
			if (suffixes[i].endsWith("#") && suffixes[i - 1].endsWith("$")
					|| suffixes[i].endsWith("$") && suffixes[i - 1].endsWith("#")) {
				int res = commonPrefix2(suffixes[i], suffixes[i - 1]);
				maxl = Math.max(maxl, res);
			}
		}
		return maxl;
	}

	public static int longCommonSubstring3(String s1, String s2) {
		ITrie trie = new TSTTrie();
		int maxl = 0;
		for (int i = 0; i < s2.length(); ++i)
			trie.add(s2.substring(i));
		for (int i = 0; i < s1.length(); ++i) {
			int res = trie.lcp(s1.substring(i)).length();
			maxl = Math.max(maxl, res);
		}
		return maxl;
	}

	public static void main(String[] args) {
		System.out.println(longCommonSubstring1(args[0], args[1]));
		System.out.println(longCommonSubstring2(args[0], args[1]));
		System.out.println(longCommonSubstring3(args[0], args[1]));

	}

}
