package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.UUID;

public class FileSearch {
	
	private static TreeMap<String, Long> index = new TreeMap<String, Long>();

	public static String searchFile1(String file, String key) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String emp;
		while ((emp = br.readLine()) != null) {
			String empid = emp.split(",")[0];
			if (empid.equals(key.trim().toLowerCase()))
				return emp;
		}
		return null;
	}
	
	public static void init(String file) throws Exception {
		RandomAccessFile rf = new RandomAccessFile(new File(file), "r");
		String emp;
		long line_offset = 0;
		while ((emp = rf.readLine()) != null) {
			String empid = emp.split(",")[0];
			index.put(empid, line_offset);
			line_offset = rf.getFilePointer();
		}
	}
	
	public static String searchFile2(String file, String key) throws Exception {
		if(! index.containsKey(key)) return null;
		long record_offset = index.get(key);
		RandomAccessFile rf = new RandomAccessFile(new File(file), "r");
		rf.seek(record_offset);
		return rf.readLine();
	}
	public static void createRandomFile(String infile, long n) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(infile));
		Random r = new Random(100);
		for (long i = 0; i < n; ++i) {
			String empid = "e" + (i+1);
			String empname = "Employee" + (i+1);
			int sal = r.nextInt(10000) + 10000;
			String dept = "dept" + (r.nextInt(10) +1);
			bw.write(empid + "," + empname + "," + sal + "," +dept);
			bw.newLine();
		}
		bw.close();
	}
	public static void main(String[] args) throws Exception {
		//createRandomFile(args[0], 1000000L);
		//System.out.println(searchFile1(args[0], args[1]));
		System.out.println("Indexing begin..");
		init(args[0]);
		System.out.println("Indexing completed");
		
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String key = scanner.nextLine();
			System.out.println(searchFile2(args[0], key));
		}
	}

}
