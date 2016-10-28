package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Random;

public class UrlFilter {

	public static boolean isbadURL1(String url) throws Exception {
		String file = "D:\\chrome\\badurls.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line = br.readLine()) != null) {
			if(line.trim().equalsIgnoreCase(url))
				return true;
		}
		br.close();
		return false;
	}
	
	public static HashSet<String> preProcessFile1() throws Exception {
		String file = "D:\\chrome\\badurls.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		HashSet<String> hs = new HashSet<String>();
		while((line = br.readLine()) != null) {
			hs.add(line.trim().toLowerCase());
		}
		br.close();
		return hs;
	}
	public static boolean isbadURL2(String url, HashSet<String> hs) throws Exception {
		return hs.contains(url.toLowerCase());
	}
	
	public static HashSet<String> preProcessFile2() throws Exception {
		String file = "D:\\chrome\\badurls.txt";
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		HashSet<String> hs = new HashSet<String>();
		while((line = br.readLine()) != null) {
			hs.add(line.trim().toLowerCase());
		}
		br.close();
		return hs;
	}
	public static boolean isbadURL3(String url, HashSet<String> hs) throws Exception {
		return hs.contains(url.toLowerCase());
	}
	
	public static void generateTestData(String file, long n) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file)));
		for(long i = 1; i <= n; ++i) {
			String url = "badurl" +i;
			bw.write("www." + url + ".com");
			bw.newLine();
		}
		bw.close();		
	}
	public static void main(String[] args) throws Exception {
		String file = "D:\\chrome\\badurls.txt";
		int n = Integer.parseInt(args[0]);
		//generateTestData(file, n);
		Runtime r = Runtime.getRuntime();
		System.out.println(r.freeMemory());
		HashSet<String> hs = preProcessFile1();
		System.out.println(r.freeMemory());
		System.out.println(isbadURL2("www.badurl10.com", hs));
		System.out.println(isbadURL2("www.url10.com", hs));
	}

}
