package com.alg.top20.file;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class PerformanceTest {
	
	public static void writeRAM(long size) throws Exception {
		char[] in = new char[2048];		
		char[] out = new char[2048];
		int iter = (int)Math.ceil(size/2048.0);
		long start = System.currentTimeMillis();
		for(int i = 1; i <= iter; ++i)
			System.arraycopy(in, 0, out, 0, 2048);
		long end = System.currentTimeMillis();
		System.out.println("Time taken for writing " + size + " bytes=" + (end-start)/1000.0 + "sec");
	}

	public static void writeDisk(String file, long size) throws Exception {
		char[] in = new char[2048];		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		int iter = (int)Math.ceil(size/2048.0);
		long start = System.currentTimeMillis();
		for(int i = 1; i <= iter; ++i)
			bw.write(in);
		bw.close();	
		long end = System.currentTimeMillis();
		System.out.println("Time taken for writing " + size + " bytes=" + (end-start)/1000.0 + "sec");
	}
	public static void main(String[] args) throws Exception {
		String file = args[0];
		long size = Long.parseLong(args[1]);
		System.out.println(size);
		//writeDisk(file, size);
		writeRAM(size);
	}

}
