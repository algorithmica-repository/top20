package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class NthLineFromEnd {

	public static String getNthLineFromEnd1(String filename, int n) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		int nlines = 0;
		String line;
		while((line = br.readLine()) != null)
			++nlines;
		br.close();
		
		int count = 0;
		br = new BufferedReader(new FileReader(filename));
		while((line = br.readLine()) != null) {
			if(++count == nlines - n + 1)
				return line;
		}
		br.close();
		return null;
	}
	
	public static String getNthLineFromEnd2(String filename, int n) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		CircularBuffer cb = new CircularBuffer(n);
		
		String line;
		while((line = br.readLine()) != null)
			cb.add(line);
		br.close();
		
		return cb.readFirst();
	}
	
	public static String getNthLineFromEnd3(String filename, int n) throws Exception {
		ReversedLinesFileReader rfr = new ReversedLinesFileReader(new File(filename));
	
		int count = 0;
		String line;
		while((line = rfr.readLine()) != null) {
			if(++count == n)
				return line;
		}
		return null;		
	}
	public static void main(String[] args) throws Exception {
		String filename = args[0];
		int n = Integer.parseInt(args[1]);
		long start = System.currentTimeMillis();
		System.out.println(getNthLineFromEnd2(filename, n));
		long end = System.currentTimeMillis();
		System.out.println("Time lapse:" + (end-start)/1000.0 + "secs");

	}

}
