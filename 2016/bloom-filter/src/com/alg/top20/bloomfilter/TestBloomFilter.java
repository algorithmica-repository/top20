package com.alg.top20.bloomfilter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class TestBloomFilter {

	public static void test_basic() {
		BloomFilter blf = new BloomFilter(10000, 0.001);
		blf.add("java");
		blf.add("javascript");
		System.out.println(blf.contains("java"));
		System.out.println(blf.contains("javascript"));
		System.out.println(blf.contains("c++"));
		System.out.println(blf.contains("c"));
	}

	public static void test_advanced(File file, int n) throws Exception {
		BloomFilter blf = new BloomFilter(n, 0.00001);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = br.readLine()) != null) {
			blf.add(line);
		}
		System.out.println(blf.contains("java"));
		System.out.println(blf.contains("javascript"));
		System.out.println(blf.contains("www.owpkkifklbueglupnpdf.com"));
		System.out.println(blf.contains("www.vdpuvmoinmwcejwlsivu.com"));
		System.out.println(blf.contains("www.zuakvqekdbypgruhiarj.com"));
	}

	public static void generate_random_urls(File file, int n) throws Exception {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));

		Random rnd = new Random(100);
		for (int i = 0; i < n; ++i) {
			StringBuilder sb = new StringBuilder(10);
			for (int j = 0; j < 20; ++j)
				sb.append(alphabet.charAt(rnd.nextInt(alphabet.length())));
			bw.write("www." + sb.toString() + ".com");
			bw.newLine();
		}
		bw.close();
	}

	public static void main(String[] args) throws Exception {
		// test_basic();
		File file = new File(args[0]);
		int n = Integer.parseInt(args[1]);
		generate_random_urls(file,n);
		test_advanced(file,n);
	}

}
