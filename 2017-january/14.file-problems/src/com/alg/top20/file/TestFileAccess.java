package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;

public class TestFileAccess {

	public static void main(String[] args) throws Exception {
		String filename = args[0];
		/*BufferedReader br = new BufferedReader(new FileReader(filename));
		System.out.println(br.readLine());
		System.out.println(br.readLine());
		br.reset();
		System.out.println(br.readLine());
		*/
		RandomAccessFile raf = new RandomAccessFile(filename, "r");
		System.out.println(raf.getFilePointer());
		System.out.println(raf.readLine());
		System.out.println(raf.getFilePointer());
	}

}
