package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class UrlFiltering {

	private static HashSet<String> unsafe_url_set = new HashSet<String>();

	public static boolean isUrlUnSafe1(String url, String file)
			throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String unsafeurl;
		while ((unsafeurl = br.readLine()) != null) {
			if (url.equals(unsafeurl.trim().toLowerCase()))
				return true;
		}
		return false;
	}

	public static void init(String file) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String unsafeurl;
		while ((unsafeurl = br.readLine()) != null) {
			unsafe_url_set.add(unsafeurl.trim().toLowerCase());
		}
	}

	public static boolean isUrlUnSafe2(String url) {
		return unsafe_url_set.contains(url);
	}

	public static void createRandomFile(String infile, long n) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(infile));
		for (long i = 0; i < n; ++i) {
			bw.write("www." + UUID.randomUUID() + ".com");
			bw.newLine();
		}
		bw.close();
	}

	public static void main(String[] args) throws Exception {
		// createRandomFile("D:/chrome/unsafe.txt", Integer.parseInt(args[0]));
		init("D:/chrome/unsafe.txt");
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String url = scanner.nextLine();
			System.out.println(isUrlUnSafe2(url));
		}
	}

}
