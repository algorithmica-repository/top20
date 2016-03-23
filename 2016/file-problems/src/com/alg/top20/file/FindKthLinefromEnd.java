package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.LinkedList;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class FindKthLinefromEnd {

	public static String findkthline1(File f, int k) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = null;
		int nlines = 0;
		while((line = br.readLine())!= null)
			++nlines;
		br.close();
		
		br = new BufferedReader(new FileReader(f));
		line = null;
		int count = 0;
		while((line = br.readLine())!= null) {
			if(++count == nlines - k + 1)
				break;
		}
		br.close();
		return line;
	}
	static class CircularBuffer {
		private LinkedList<String> buffer;
		private int capacity;
		private int size;
		
		public CircularBuffer(int k) {
			buffer = new LinkedList<String>();
			capacity = k;
		}
		
		public void add(String e) {
			if(size == capacity) {
				buffer.remove(0);
				buffer.add(e);
			}
			else {
				buffer.add(e);
				++size;
			}						
		}
		public String get(int ind) {
			return buffer.get(ind);
		}
		
	}
	
	public static String findkthline2(File f, int k) throws Exception {
		CircularBuffer cb = new CircularBuffer(k);
		BufferedReader br = new BufferedReader(new FileReader(f));
		String line = null;
		while((line = br.readLine())!= null) {
			cb.add(line);
		}
		br.close();
		return cb.get(0);
	}
	
	public static String findkthline3(File f, int k) throws Exception {
		ReversedLinesFileReader rfr = new ReversedLinesFileReader(f);
		String line = null;
		int count = 0;
		while((line = rfr.readLine())!= null) {
			if(++count == k) break;
		}
		rfr.close();
		return line;
	}
	
	
	public static void main(String[] args) throws Exception {
		File f = new File("D:\\input\\" + args[0]);
		int k = Integer.parseInt(args[1]);
		long start = System.currentTimeMillis();
		System.out.println(findkthline1(f, k));
		long end = System.currentTimeMillis();
		System.out.println((float)(end-start)/1000 + " seconds");

		start = System.currentTimeMillis();
		System.out.println(findkthline2(f, k));
		end = System.currentTimeMillis();
		System.out.println((float)(end-start)/1000 + " seconds");
		
		start = System.currentTimeMillis();
		System.out.println(findkthline3(f, k));
		end = System.currentTimeMillis();
		System.out.println((float)(end-start)/1000 + " seconds");

		
	}

}
