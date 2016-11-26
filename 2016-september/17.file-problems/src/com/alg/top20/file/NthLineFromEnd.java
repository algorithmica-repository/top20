package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

import org.apache.commons.io.input.ReversedLinesFileReader;

public class NthLineFromEnd {

	public static String nthLineFromEnd1(String file, int n) throws Exception {
		//pass1:count number of lines in a given file
		BufferedReader br = new BufferedReader(new FileReader(file));
		int nlines = 0;
		String line = null;
		while((line = br.readLine()) != null)
			++nlines;
		br.close();
		if(nlines < n) return null;
		
		//pass2: read nlines - n th line from start
		br = new BufferedReader(new FileReader(file));
		int count = 0;
		line = null;
		while((line = br.readLine()) != null) {
			if(++count == nlines-n+1)
				break;
		}
		br.close();
		return line;
			
	}
	
	public static String nthLineFromEnd2(String file, int n) throws Exception {
		LinkedList<String> lines = new LinkedList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		int nlines = 0;
		String line = null;
		while((line = br.readLine()) != null) {
			lines.add(line);
			++nlines;
		}
		br.close();
		if(nlines < n) return null;
		return lines.get(nlines-n);			
	}
	
	public static String nthLineFromEnd3(String file, int n) throws Exception {
		BoundedBuffer lines = new BoundedBuffer(n);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while((line = br.readLine()) != null) {
			lines.add(line);
		}
		br.close();
		if(lines.size() < n) return null;
		return lines.get(0);			
	}
	
	public static String nthLineFromEnd4(String file, int n) throws Exception {
		ReversedLinesFileReader rfr = new ReversedLinesFileReader(new File(file));
		int count = 0;
		String line = null;
		while((line = rfr.readLine()) != null) {
			if(++count == n)
				break;
		}
		rfr.close();
		return line;
	}
	public static void main(String[] args) throws Exception {
		String file = args[0];
		int n = Integer.parseInt(args[1]);
		
		long start = System.currentTimeMillis();
		System.out.println(nthLineFromEnd4(file, n));
		long end = System.currentTimeMillis();
		System.out.println("Time to read file" +  (end-start)/1000.0 + "seconds");

		/*start = System.currentTimeMillis();
		System.out.println(nthLineFromEnd2(file, n));
		end = System.currentTimeMillis();
		System.out.println("Time to read file" +  (end-start)/1000.0 + "seconds");

		start = System.currentTimeMillis();
		System.out.println(nthLineFromEnd3(file, n));
		end = System.currentTimeMillis();
		System.out.println("Time to read file" +  (end-start)/1000.0 + "seconds");

		start = System.currentTimeMillis();
		System.out.println(nthLineFromEnd4(file, n));
		end = System.currentTimeMillis();
		System.out.println("Time to read file" +  (end-start)/1000.0 + "seconds");
*/	}

}
