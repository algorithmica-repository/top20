package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

import javax.sound.sampled.ReverbType;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class NthLineFromEnd {

	public static String findNthLinefromEnd1(String file, int n) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		int nlines = 0;
		String line;
		while((line = br.readLine()) != null) {
			++nlines;
		}
		br.close();
		
		br = new BufferedReader(new FileReader(file));		
		int count = 0;
		while((line = br.readLine()) != null) {
			if(++count == (nlines - n + 1) )
				return line;
		}
		br.close();
		return null;
	}
	static class CircularBuffer {
		private LinkedList<String> buffer;
		private int size;
		private int capacity;
		
		public CircularBuffer(int k) {
			buffer = new LinkedList<String>();
			capacity = k;
			size = 0;
		}
		
		public void add(String line) {
			if(size == capacity)
				buffer.removeFirst();
			else 
				++size;
			buffer.addLast(line);
		}
		
		public int size() {
			return size;
		}
		
		public String get(int ind) {
			return buffer.get(ind);
		}
		
		public void display() {
			System.out.println(buffer);
		}
	}
	
	public static String findNthLinefromEnd2(String file, int n) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		CircularBuffer cb = new CircularBuffer(n);
		String line;
		while((line = br.readLine()) != null) {
			cb.add(line);
		}
		//cb.display();
		br.close();
		if(cb.size() < n) return null;
		return cb.get(0);
	}
	
	public static String findNthLinefromEnd3(String file, int n) throws Exception {
		ReversedLinesFileReader rf = new ReversedLinesFileReader(new File(file));
		String line;
		int count = 0;
		while((line = rf.readLine()) != null) {
			if(++count == n) return line;
		}
		rf.close();
		return null;
	}
	public static void main(String[] args) throws Exception {
		String file = args[0];
		int n = Integer.parseInt(args[1]);
		long start = System.currentTimeMillis();
		System.out.println(findNthLinefromEnd3(file, n));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end-start)/1000.0 + " seconds");
	}

}
