package com.collections.test;

/**
 * @author	Srinivas Reddy
 * @email	srinivas96alluri@gmail.com
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingWords {
	static String input = "Red lorry, yellow lorry, red lorry, yellow lorry";

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		input = input.toLowerCase();
		int countOfDifferWords = 0;
		Pattern pat = Pattern.compile("\\w+");
		Matcher mat = pat.matcher(input);
		StringBuilder sb = new StringBuilder(input);
		while (mat.find()) {
			countOfDifferWords++;
			int i = 0;
			System.out.print(mat.group() + " = ");
			Pattern pat1 = Pattern.compile("\\b" + mat.group() + "\\b");
			Matcher mat1 = pat1.matcher(input);
			while (mat1.find()) {
				i++;
				int len = mat.group().length();
				sb.replace(mat1.start(), (mat1.start() + len), new String(
						new char[len]));
			}
			System.out.println(i);
			mat = pat.matcher(sb.toString());
		}
		long alltime = System.currentTimeMillis() - start;
		System.out.println("\ncount of different words is "
				+ countOfDifferWords);
		System.out.println("execution time: ~" + alltime + " ms");
	}
}