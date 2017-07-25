package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.util.HashMap;

import org.apache.commons.io.input.ReversedLinesFileReader;


public class NthLineFromEnd {

	public static String findNthLinEnd1(String file, int k) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		int nlines = 0;
		while( (line = br.readLine()) != null) 
			++nlines;
		br.close();
		
		int count = 0;
		br = new BufferedReader(new FileReader(file));
		while ( (line = br.readLine()) != null) {
			if(++count == nlines-k+1)
				return line;
		}
		return null;
	}
	
	public static String findNthLinEnd2(String file, int k) throws Exception {
		CircularBuffer cb = new CircularBuffer(k);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while( (line = br.readLine()) != null) 
			cb.add(line);
		br.close();
		return cb.getFirst();
	}
	
	public static String findNthLinEnd3(String file, int k) throws Exception {
		ReversedLinesFileReader rfr = new ReversedLinesFileReader(new File(file)); 
		String line = null;
		int count = 0;
		while( (line = rfr.readLine()) != null) { 
			if(++count == k)
				break;
		}
		rfr.close();
		return line;
	}
	
	public static String findNthLinEnd4(String file, int k) throws Exception {
		HashMap<Long, Long> line_index = new HashMap<Long, Long>();
		RandomAccessFile raf = new RandomAccessFile(file, "r");
		String line;
		long count = 1;
		line_index.put(count, 0L);
		while( (line = raf.readLine()) != null) { 
			line_index.put(++count, raf.getFilePointer());
		}
		System.out.println(line_index);
		raf.seek(line_index.get(count-k));
		return raf.readLine();
	}
	public static void main(String[] args) throws Exception {
		int k = Integer.parseInt(args[1]);
		long start = System.currentTimeMillis();
		System.out.println(findNthLinEnd4(args[0], k));
		long end = System.currentTimeMillis();
		System.out.println("Time:" + (end-start)/1000.0 + " seconds");
	}

}
