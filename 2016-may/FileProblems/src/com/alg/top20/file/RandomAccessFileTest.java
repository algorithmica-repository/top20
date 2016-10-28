package com.alg.top20.file;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws Exception {
		String file = args[0];
		RandomAccessFile rf = new RandomAccessFile(new File(file), "r");
		System.out.println(rf.getFilePointer());
		System.out.println(rf.readLine());
		System.out.println(rf.getFilePointer());
		System.out.println(rf.readLine());
		System.out.println(rf.getFilePointer());
		rf.seek(13);
		System.out.println(rf.readLine());
		rf.close();
		
	}

}
