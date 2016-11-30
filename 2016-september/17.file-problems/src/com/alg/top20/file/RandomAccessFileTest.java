package com.alg.top20.file;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws Exception {
		RandomAccessFile rf = new RandomAccessFile(new File(args[0]), "r");
		System.out.println(rf.getFilePointer());
		rf.readLine();
		System.out.println(rf.getFilePointer());
		rf.readLine();
		System.out.println(rf.getFilePointer());
		rf.readLine();
		System.out.println(rf.getFilePointer());
		rf.seek(0);
		System.out.println(rf.readLine());
	}

}
