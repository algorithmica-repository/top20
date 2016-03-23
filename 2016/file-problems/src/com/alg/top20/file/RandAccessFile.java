package com.alg.top20.file;

import java.io.File;
import java.io.RandomAccessFile;

public class RandAccessFile {

	public static void checkOffsets(File f) throws Exception {
		RandomAccessFile rf = new RandomAccessFile(f, "r");
		long length = rf.length();
		long blksize=4096;
		byte[] buffer = new byte[(int)blksize];
		long lastblksize;
		if(length%blksize == 0) {
			lastblksize = blksize;
		} else {
			lastblksize = length%blksize;
		}
		
		long offset = length;
		rf.seek(offset);
		System.out.println(rf.getFilePointer());
		while(true) {
			offset = offset - lastblksize;
			if(offset < 0) break;
			rf.seek(offset);
			System.out.println(rf.getFilePointer());
			rf.read(buffer, 0, (int)lastblksize);
			//count lines inside buffer
			lastblksize = blksize;
		}
	}
	public static void main(String[] args) throws Exception {
		File f = new File("D:\\input\\" + args[0]);
		checkOffsets(f);
	}

}
