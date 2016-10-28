package com.alg.top20.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReadWrite {

	public static void writeDisk(String file) throws Exception {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("abcde");
		bw.newLine();
		bw.write("xyz");
		bw.close();		
	}
	
	public static void readDisk(String file) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}			
		br.close();		
	}
	
	public static void main(String[] args) throws Exception {
		String file = args[0];
		writeDisk(file);
		readDisk(file);
	}

}
