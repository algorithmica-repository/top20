package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class FileSorting {

	public static void sortFile1(String infile, String outfile) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(infile));
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		String line;
		while((line=br.readLine()) != null) {
			list.add(Integer.parseInt(line));
		}
		br.close();
		//System.out.println(list);
		
		Collections.sort(list);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(outfile));
		for(int i = 0; i < list.size(); ++i) {
			bw.write(Integer.toString(list.get(i)));
			bw.newLine();
		}
		bw.close();
	}
	
	public static void createRandomFile(String infile, long n) throws Exception {
		Random r = new Random(100);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(infile));
		for(long i = 0; i < n; ++i) {
			bw.write(Integer.toString(r.nextInt(1000000) + 1));
			bw.newLine();
		}
		bw.close();
	}
	
	public static void sortFile2(String infile, String outfile) throws Exception {
		//sort phase
		
		//merge phase
	}
	
	public static void main(String[] args) throws Exception {
		String infile = args[1];
		String outfile = args[2];		
		createRandomFile(infile, Integer.parseInt(args[0]));
		sortFile1(infile, outfile);
	}
}
